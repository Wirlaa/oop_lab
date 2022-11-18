package agh.ics.oop;

import java.util.*;

public class GrassField extends AbstractWorldMap {
    private final List<Grass> grassList = new ArrayList<>();
    // pewnie jak przestaniemy korzystac z list to ta lista list nie bedzie przydatna, ale przynajmniej przekonalam sie
    // jak bardzo typecastowanie w javie jest trudne :D
    // moze istnieje jakis ladniejszy sposob, na razie zostawiam tak
    private final List<List<? extends AbstractWorldMapElement>> elements = new ArrayList<>(Arrays.asList(animals, grassList));
    // gettery
    public List<Grass> getGrassList() { return Collections.unmodifiableList(grassList); }
    public GrassField (int size) {
        //List<AbstractWorldMapElement> ldsad = (List<AbstractWorldMapElement>) grassList;
        elements.add(animals);
        // losowanie trawy
        for (int i = 0; i < size; i++) {
            grassList.add(new Grass(new Vector2d(
                    (int) Math.floor(Math.random() * (Math.sqrt(size * 10) + 1)),
                    (int) Math.floor(Math.random() * (Math.sqrt(size * 10) + 1))
            )));
        }
        // ustalenie jakiegos srodka mapy od ktorego mozna ja rozszerzyc
        lowerBound = grassList.get(0).getPosition();
        upperBound = lowerBound;
        coordsUpdate();
    }
    protected void coordsUpdate() {
        for (List<? extends AbstractWorldMapElement>  list: elements) {
            lowerBound = list.stream().map(AbstractWorldMapElement::getPosition).reduce(lowerBound, Vector2d::lowerLeft);
            upperBound = list.stream().map(AbstractWorldMapElement::getPosition).reduce(upperBound, Vector2d::upperRight);
        }
    }
    public boolean canMoveTo (Vector2d position) {
        if (isOccupied(position)) return false;
        if (objectAt(position) instanceof Grass) {
            grassList.remove((Grass) objectAt(position));
            Vector2d newPosition;
            do {
                newPosition = new Vector2d(
                        (int) Math.floor(Math.random() * (upperBound.getX() - lowerBound.getX()) + lowerBound.getX()),
                        (int) Math.floor(Math.random() * (upperBound.getY() - lowerBound.getY()) + lowerBound.getY())
                );
            } while (!Objects.equals(newPosition, position));
            grassList.add(new Grass(newPosition));
        }
        return true;
    }
    // nie podoba mi sie ze publiczne
    public void mapUpdate() {
        coordsUpdate();
    }
    public Object objectAt(Vector2d position) {
        AbstractWorldMapElement result;
        for (List<? extends AbstractWorldMapElement> list: elements) {
            result = list.stream()
                    .filter(element -> Objects.equals(position, element.getPosition()))
                    .findFirst()
                    .orElse(null);
            if (result != null) return result;
        }
        return null;
    }
}

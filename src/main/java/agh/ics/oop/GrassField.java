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
        elements.add(animals);
        // losowanie trawy
        for (int i = 0; i < size; i++) {
            Vector2d newPosition;
            do {
                newPosition = new Vector2d(
                        (int) Math.floor(Math.random() * (Math.sqrt(size * 10) + 1)),
                        (int) Math.floor(Math.random() * (Math.sqrt(size * 10) + 1))
                );
            } while (objectAt(newPosition) != null);
            grassList.add(new Grass(newPosition));
        }
        elements.add(grassList);
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
    // odpowiedzialna rowniez za znikanie trawy w momencie wywolania
    // (prawdopodobnie powinna tym sie zajmowac funkcja move, ale ona jest w klasie animal, a zjadanie trawy na razie
    // jest wylaczne dla tej mapy)
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
            } while (Objects.equals(newPosition, position) && objectAt(newPosition) != null);
            grassList.add(new Grass(newPosition));
        }
        return true;
    }
    // nie podoba mi sie ze publiczne, ale musi byc w interface
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

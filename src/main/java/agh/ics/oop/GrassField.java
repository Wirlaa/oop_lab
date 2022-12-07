package agh.ics.oop;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class GrassField extends AbstractWorldMap {
    private final int size;
    public GrassField (int size) {
        this.size = size;
        List<Vector2d> positions = shuffleGrid(size);
        elements.putAll(positions.stream().collect(Collectors.toMap(Function.identity(), Grass::new)));
    }
    @Override
    public Vector2d getLowerBound() {
        return elements.keySet().stream().reduce(Vector2d::lowerLeft).orElse(null);
    }
    @Override
    public Vector2d getUpperBound() {
        return elements.keySet().stream().reduce(Vector2d::upperRight).orElse(null);
    }
    private List<Vector2d> shuffleGrid(int size) {
        // probowalam z flat map i intstream, ale to bylo poza moim zasiegiem :D
        // IntStream nums = IntStream.range(0, (int) Math.sqrt(size*10) + 1);
        List<Vector2d> positionsGrid = new ArrayList<>();
        for (int i = 0; i < Math.sqrt(this.size*10); i++) {
            for (int j = 0; j < Math.sqrt(this.size*10); j++) {
                positionsGrid.add(new Vector2d(i,j));
            }
        }
        // nie wiem czy to dobrze robie, moze powinnam korzystac ze streamof
        positionsGrid = positionsGrid.stream().filter(position -> !elements.containsKey(position)).collect(Collectors.toList());
        Collections.shuffle(positionsGrid);
        return positionsGrid.subList(0,size);
    }
    private void eatGrass(Vector2d position) {
        if (objectAt(position) instanceof Grass) {
            if (!shuffleGrid(1).isEmpty()) {
                Vector2d newPosition = shuffleGrid(1).get(0);
                elements.put(newPosition, new Grass(newPosition));
                elements.remove(position);
            }
        }
    }
    @Override
    public boolean place (Animal animal) {
        eatGrass(animal.getPosition());
        return super.place(animal);
    }
    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        // gdyby cala mapa byla zajeta oprocz miejsce na ktore zwierze sie przenosci, to trawa nie pojawilaby sie na zwolnionym miejscu
        eatGrass(newPosition);
        super.positionChanged(oldPosition,newPosition);
    }
    // zostawiam instanceof, bo lubie trzymac obiekty w jednej liscie
    public boolean canMoveTo (Vector2d position) {
        return !(objectAt(position) instanceof Animal);
    }
}

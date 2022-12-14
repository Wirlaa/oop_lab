package agh.ics.oop;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class GrassField extends AWorldMap {
    private final int size;
    private final MapBoundary mapBoundary = new MapBoundary();
    public GrassField (int size) {
        this.size = size;
        List<Vector2d> positions = shuffleGrid(size);
        elements.putAll(positions.stream().collect(Collectors.toMap(Function.identity(), Grass::new)));
        mapBoundary.putAll(elements);
    }
    @Override
    public Vector2d getLowerBound() { return mapBoundary.LowerBound(); }
    @Override
    public Vector2d getUpperBound() { return mapBoundary.UpperBound(); }
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
        positionsGrid = positionsGrid.parallelStream().filter(position -> !elements.containsKey(position)).collect(Collectors.toList());
        Collections.shuffle(positionsGrid);
        return positionsGrid.subList(0,size);
    }
    private void eatGrass(Vector2d position) {
        // tak wlasciwie to nie potrzebuje remove, bo i tak na starej pozycji powinno sie pojawic zwierze
        if (!shuffleGrid(1).isEmpty()) {
            Vector2d newPosition = shuffleGrid(1).get(0);
            Grass grass = new Grass(newPosition);
            elements.put(newPosition, grass);
            elements.remove(position);
            mapBoundary.put(newPosition, grass);
            mapBoundary.remove(position);
        }
    }
    @Override
    public void place (Animal animal) {
        if (objectAt(animal.getPosition()) instanceof Grass) {
            eatGrass(animal.getPosition());
        }
        super.place(animal);
        // jezeli canMoveTo rzuca wyjatek, to i tak funkcja sie nie wykona
        mapBoundary.put(animal.getPosition(), animal);
        animal.addObserver(mapBoundary);
    }
    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        // gdyby cala mapa byla zajeta oprocz miejsce na ktore zwierze sie przenosci, to trawa nie pojawilaby sie na zwolnionym miejscu
        if (objectAt(newPosition) instanceof Grass){
            eatGrass(newPosition);
        }
        super.positionChanged(oldPosition,newPosition);
    }
    // zostawiam instanceof, bo lubie trzymac obiekty w jednej liscie
    public boolean canMoveTo (Vector2d position) {
        return !(objectAt(position) instanceof Animal);
    }
}

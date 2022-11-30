package agh.ics.oop;

import java.util.*;

public abstract class AbstractWorldMap implements IWorldMap {
    // na razie wole protected, bo i tak umozliwiam mapom zmiane tych pol
    protected Vector2d lowerBound;
    protected Vector2d upperBound;
    protected final List<Animal> animals = new ArrayList<>();
    public List<Animal> getAnimals() { return Collections.unmodifiableList(animals); }
    public Vector2d getLowerBound() { return lowerBound; }
    public Vector2d getUpperBound() { return upperBound; }
    public boolean place (Animal animal) {
        if (canMoveTo(animal.getPosition())) {
            animals.add(animal);
            mapUpdate();
            return true;
        }
        return false;
    }
    public boolean isOccupied (Vector2d position) {
        return animals.stream().anyMatch(animal -> animal.isAt(position));
    }
    /*
        W szczególności dodaj implementację metody toString() w klasie AbstractWorldMap,
         w taki sposób, aby wykorzystywała ona abstrakcyjne metody zdefiniowane w tej klasie,
         posiadające odrębne implementacje w klasach dziedziczących.
     */
    // nie wiem czy nie naduzywam lowerBound i upperBound, bo w mojej implementacji nie ma potrzeby korzystania z osobnych metod

    @Override
    public String toString() {
        return new MapVisualizer(this).draw(lowerBound, upperBound);
    }
}

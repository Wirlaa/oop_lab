package agh.ics.oop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class RectangularMap implements IWorldMap {
    private final Vector2d lowerBound = new Vector2d(0, 0);
    private final Vector2d upperBound;
    private List<Animal> animals = new ArrayList<>();
    public RectangularMap (int width, int height) {
        this.upperBound = lowerBound.add(new Vector2d(width, height));
    }
    //gettery
    public Vector2d getLowerBound() { return lowerBound; }
    public Vector2d getUpperBound() { return upperBound; }
    public List<Animal> getAnimals() { return Collections.unmodifiableList(animals); }
    public boolean canMoveTo (Vector2d position) {
        return !isOccupied(position) && Objects.equals(position, position.upperRight(lowerBound).lowerLeft(upperBound));
    }
    public boolean place (Animal animal, Vector2d position, MapDirection orientation) {
        if (canMoveTo(position)) {
            animal = new Animal(this, position, orientation);
            animals.add(animal);
            return true;
        }
        return false;
    }
    public boolean isOccupied (Vector2d position) {
        return !(objectAt(position) == null);
    }
    // istnieje optional ktore radzi sobie z nullami
    public Object objectAt(Vector2d position) {
        return animals.stream()
                .filter(animal -> animal.isAt(position))
                .findFirst()
                .orElse(null);
    }

    @Override
    public String toString() {
        return new MapVisualizer(this).draw(lowerBound, upperBound);
    }
}

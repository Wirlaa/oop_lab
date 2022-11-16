package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.isNull; // czemu musze importowac :c

public class RectangularMap implements IWorldMap {
    // powinny byc final czy moga sie zmieniac?
    private Vector2d lowerBound = new Vector2d(0, 0);
    private Vector2d upperBound;
    private List<Animal> animals = new ArrayList<>();
    public RectangularMap (int width, int height) {
        this.upperBound = lowerBound.add(new Vector2d(width, height));
    }
    //gettery
    public Vector2d getLowerBound() { return lowerBound; }
    public Vector2d getUpperBound() { return upperBound; }
    public List<Animal> getAnimals() {
        return animals; }
    // jakie sa restrykcje? tylko krawedzie mapy i czy miejsce jest puste?
    public boolean canMoveTo (Vector2d position) {
        return !isOccupied(position) && position.equals(position.upperRight(lowerBound).lowerLeft(upperBound));
    }
    public boolean place (Animal animal, Vector2d position, MapDirection orientation) {
        if (isNull(objectAt(position))) {
            animal = new Animal(this, position, orientation);
            animals.add(animal);
            return true;
        }
        return false;
    }
    // na razie obiektami sa tylko zwierzeta, wiec korzystam z klasy animal, bo posiada funkcje isAt
    public boolean isOccupied (Vector2d position) {
        for (Animal animal : animals) {
            if (animal.isAt(position)) { return true; }
        }
        return false;
    }
    public Object objectAt(Vector2d position) {
        for (Animal animal : animals) {
            if (animal.isAt(position)) { return animal; }
        }
        return null;
    }

    @Override
    public String toString() {
        return new MapVisualizer(this).draw(lowerBound, upperBound);
    }
}

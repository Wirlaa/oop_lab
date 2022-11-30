package agh.ics.oop;

import java.util.Objects;

public class RectangularMap extends AbstractWorldMap {
    public RectangularMap (int width, int height) {
        lowerBound = new Vector2d(0, 0);
        upperBound = lowerBound.add(new Vector2d(width, height));
    }
    public boolean canMoveTo (Vector2d position) {
        return !isOccupied(position) && Objects.equals(position, position.upperRight(lowerBound).lowerLeft(upperBound));
    }
    public void mapUpdate() {
        //nothing to do
    }
    public Object objectAt(Vector2d position) {
        return animals.stream()
                .filter(animal -> animal.isAt(position))
                .findFirst()
                .orElse(null);
    }
}

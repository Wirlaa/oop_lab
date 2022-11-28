package agh.ics.oop;

import java.util.Objects;

public class RectangularMap extends AbstractWorldMap {
    private final Vector2d lowerBound;
    private final Vector2d upperBound;
    public RectangularMap (int width, int height) {
        lowerBound = new Vector2d(0, 0);
        upperBound = lowerBound.add(new Vector2d(width, height));
    }
    @Override
    public Vector2d getLowerBound() { return lowerBound; }
    @Override
    public Vector2d getUpperBound() { return upperBound; }

    public boolean canMoveTo (Vector2d position) {
        return !isOccupied(position) && Objects.equals(position, position.upperRight(lowerBound).lowerLeft(upperBound));
    }
}

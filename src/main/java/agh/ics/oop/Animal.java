package agh.ics.oop;

import java.util.Objects;

public class Animal extends AbstractWorldMapElement {
    private MapDirection orientation;
    private final IWorldMap map;
    public Animal (IWorldMap map) {
        this(map, map.getLowerBound(), MapDirection.NORTH);
    }
    public Animal(IWorldMap map, Vector2d initialPosition, MapDirection orientation) {
        this.map = map;
        this.orientation = orientation;
        this.position = initialPosition;
    }
    //gettery
    public MapDirection getOrientation() { return orientation; }
    public IWorldMap getMap() { return map; }
    public boolean isAt(Vector2d position) { return Objects.equals(this.position, position); }
    public void move(MoveDirection direction) {
        switch (direction) {
            case RIGHT -> orientation = orientation.next();
            case LEFT -> orientation = orientation.previous();
            case FORWARD -> {
                if (map.canMoveTo(position.add(orientation.toUnitVector()))) {
                    position = position.add(orientation.toUnitVector());
                    map.mapUpdate();
                }
            }
            case BACKWARD -> {
                if (map.canMoveTo(position.subtract(orientation.toUnitVector()))) {
                    position = position.subtract(orientation.toUnitVector());
                    map.mapUpdate();
                }
            }
        }
    }
    @Override
    public String toString()  { return orientation.toString(); }
}


package agh.ics.oop;

import java.util.Objects;

public class Animal {
    private MapDirection orientation;
    private Vector2d position;
    private final IWorldMap map;
    public Animal (IWorldMap map) {
        this(map, new Vector2d(0,0), MapDirection.NORTH);
    }
    public Animal(IWorldMap map, Vector2d initialPosition, MapDirection orientation) {
        this.map = map;
        this.orientation = orientation;
        this.position = initialPosition;
    }
    //gettery
    public MapDirection getOrientation() { return orientation; }
    public Vector2d getPosition() { return position; }
    public IWorldMap getMap() { return map; }
    public boolean isAt(Vector2d position) { return Objects.equals(this.position, position); }
    @Override
    public String toString()  { return orientation.toString(); }
    public void move(MoveDirection direction) {
        switch (direction) {
            case RIGHT -> orientation = orientation.next();
            case LEFT -> orientation = orientation.previous();
            case FORWARD -> {
                if (map.canMoveTo(position.add(orientation.toUnitVector()))) {
                    position = position.add(orientation.toUnitVector());
                }
            }
            case BACKWARD -> {
                if (map.canMoveTo(position.substract(orientation.toUnitVector()))) {
                    position = position.substract(orientation.toUnitVector());
                }
            }
        }
    }
}


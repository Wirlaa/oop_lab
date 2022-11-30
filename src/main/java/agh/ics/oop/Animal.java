package agh.ics.oop;

import java.util.*;

public class Animal extends AbstractMapElement {
    private MapDirection orientation;
    private final IWorldMap map;
    private final List<IPositionChangeObserver> observers = new ArrayList<>();
    public Animal(IWorldMap map, Vector2d initialPosition, MapDirection orientation) {
        this.map = map;
        this.orientation = orientation;
        this.position = initialPosition;
    }
    public MapDirection getOrientation() { return orientation; }
    public IWorldMap getMap() { return map; }
    public List<IPositionChangeObserver> getObservers() { return Collections.unmodifiableList(observers); }
    public void move(MoveDirection direction) {
        Vector2d newPosition = null;
        switch (direction) {
            case RIGHT -> orientation = orientation.next();
            case LEFT -> orientation = orientation.previous();
            case FORWARD -> {
                if (map.canMoveTo(position.add(orientation.toUnitVector()))) {
                    newPosition = position.add(orientation.toUnitVector());
                }
            }
            case BACKWARD -> {
                if (map.canMoveTo(position.subtract(orientation.toUnitVector()))) {
                    newPosition = position.subtract(orientation.toUnitVector());
                }
            }
        }
        if (newPosition != null) {
            positionChanged(position, newPosition);
            position = newPosition;
        }
    }
    public void addObserver (IPositionChangeObserver observer) {
        observers.add(observer);
    }
    public void removeObserver (IPositionChangeObserver observer) {
        observers.remove(observer);
    }
    private void positionChanged (Vector2d oldPosition, Vector2d newPosition) {
        for (IPositionChangeObserver observer: observers) {
            observer.positionChanged(oldPosition, newPosition);
        }
    }
    @Override
    public String toString()  { return orientation.toString(); }
}


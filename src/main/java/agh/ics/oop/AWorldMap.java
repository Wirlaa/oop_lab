package agh.ics.oop;

import java.util.*;

public abstract class AWorldMap implements IWorldMap, IPositionChangeObserver {
    // na razie wole protected, bo i tak umozliwiam mapom zmiane tych pol
    protected final Map<Vector2d, IMapElement> elements = new HashMap<>();
    public Map<Vector2d, IMapElement> getElements() { return Collections.unmodifiableMap(elements); }
    public abstract Vector2d getLowerBound();
    public abstract Vector2d getUpperBound();
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        elements.put(newPosition, elements.remove(oldPosition));
    }
    public void place (Animal animal) throws IllegalArgumentException {
        if (canMoveTo(animal.getPosition())) {
            elements.put(animal.getPosition(),animal);
            animal.addObserver(this);
            //animal.addObserver((oldPosition, newPosition) -> System.out.println(oldPosition + " -> " + newPosition));
        }
        else {
            throw new IllegalArgumentException(animal.getPosition() + " is not a valid position");
        }
    }
    // kowariancja zwracanego typu
    public IMapElement objectAt(Vector2d position) {
        return elements.get(position);
    }
    @Override
    public String toString() {
        return new MapVisualizer(this).draw(getLowerBound(), getUpperBound());
    }
}

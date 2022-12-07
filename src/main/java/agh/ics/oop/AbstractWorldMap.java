package agh.ics.oop;

import java.util.*;

public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver {
    // na razie wole protected, bo i tak umozliwiam mapom zmiane tych pol
    protected final Map<Vector2d, IMapElement> elements = new HashMap<>();
    public Map<Vector2d, IMapElement> getElements() { return Collections.unmodifiableMap(elements); }
    protected abstract Vector2d getLowerBound();
    protected abstract Vector2d getUpperBound();
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        elements.put(newPosition, elements.remove(oldPosition));
    }
    public boolean place (Animal animal) {
        if (canMoveTo(animal.getPosition())) {
            elements.put(animal.getPosition(),animal);
            animal.addObserver(this);
            return true;
        }
        return false;
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

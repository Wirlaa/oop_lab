package agh.ics.oop;

import java.util.*;

public class MapBoundary implements IPositionChangeObserver {
    private final SortedMap<Vector2d, IMapElement> elementsXOrder = new TreeMap<>
            (Comparator.comparingInt(Vector2d::getX).thenComparingInt(Vector2d::getY));
    private final SortedMap<Vector2d, IMapElement> elementsYOrder = new TreeMap<>
            (Comparator.comparingInt(Vector2d::getY).thenComparingInt(Vector2d::getX));
    public SortedMap<Vector2d, IMapElement> getElementsXOrder() { return Collections.unmodifiableSortedMap(elementsXOrder); }
    public SortedMap<Vector2d, IMapElement> getElementsYOrder() { return Collections.unmodifiableSortedMap(elementsYOrder); }
    public Vector2d LowerBound() {
        return new Vector2d(elementsXOrder.firstKey().getX(), elementsYOrder.firstKey().getY());
    }
    public Vector2d UpperBound() {
        return new Vector2d(elementsXOrder.lastKey().getX(), elementsYOrder.lastKey().getY());
    }
    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        put(newPosition, remove(oldPosition));
    }
    public void put (Vector2d position, IMapElement element) {
        elementsXOrder.put(position, element);
        elementsYOrder.put(position, element);
    }
    public IMapElement remove (Vector2d position) {
        // w teorii remove jest niepotrzebny
        elementsYOrder.remove(position);
        return elementsXOrder.remove(position);
    }
    public void putAll(Map<Vector2d, IMapElement> map) {
        elementsXOrder.putAll(map);
        elementsYOrder.putAll(map);
    }
}

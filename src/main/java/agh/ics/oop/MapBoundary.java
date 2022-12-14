package agh.ics.oop;

import java.util.*;

public class MapBoundary implements IPositionChangeObserver {
    // wybralam mapy, bo positionChanged przyjmuje pozycje, a nie chce trzymac setu tylko z pozycjami gdyby w przyszlosci
    // na jednej pozycji moglo byc wiecej niz jeden obiekt
    private final SortedMap<Vector2d, IMapElement> elementsXOrder = new TreeMap<>
            (Comparator.comparingInt(Vector2d::getX).thenComparingInt(Vector2d::getY));
    private final SortedMap<Vector2d, IMapElement> elementsYOrder = new TreeMap<>
            (Comparator.comparingInt(Vector2d::getY).thenComparingInt(Vector2d::getX));
    public SortedMap<Vector2d, IMapElement> getElementsXOrder() { return Collections.unmodifiableSortedMap(elementsXOrder); }
    public SortedMap<Vector2d, IMapElement> getElementsYOrder() { return Collections.unmodifiableSortedMap(elementsYOrder); }
    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        put(newPosition, remove(oldPosition));
    }
    // nie wiem czy powinnam tworzyc metody o takich samych nazwach jak te w kolekcjach
    public void put (Vector2d position, IMapElement element) {
        elementsXOrder.put(position, element);
        elementsYOrder.put(position, element);
    }
    public IMapElement remove (Vector2d position) throws IllegalArgumentException  {
        // dodalam wyjatek
        IMapElement element = elementsXOrder.remove(position);
        if (element != null) {
            return element;
        }
        else {
            throw new IllegalArgumentException("Element at" + position + " cannot be null");
        }
    }
    public void putAll(Map<Vector2d, IMapElement> map) {
        elementsXOrder.putAll(map);
        elementsYOrder.putAll(map);
    }

}

package agh.ics.oop;

public interface IPositionChangeObserver {
    /**
     * Change the position of an object in map's hashmap containing elements.
     *
     * @param oldPosition
     *          The old position of an object.
     * @param newPosition
     *          The new position of an object.
     */
    void positionChanged(Vector2d oldPosition, Vector2d newPosition);
}

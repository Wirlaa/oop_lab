package agh.ics.oop;

/**
 * The interface responsible for managing elements placed on maps.
 * Assumes that Vector2d and MoveDirection classes are defined.
 */

public interface IMapElement {
    /**
     * Return a position of an object.
     *
     * @return Vector2d
     */
    Vector2d getPosition();
}

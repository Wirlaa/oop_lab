package agh.ics.oop;

/**
 * The interface responsible for managing elements placed on maps.
 * Assumes that Vector2d class is defined.
 */

public interface IMapElement {
    /**
     * Return a position of an object.
     *
     * @return Vector2d
     */
    Vector2d getPosition();
    /**
     * Indicate if an object is at the given position.
     *
     * @param position
     *      The given position.
     *
     * @return True if an object is at the given position.
     */
    boolean isAt(Vector2d position);
    /**
     * Get the path to an image representation.
     *
     * @return String with a valid path.
     */
    String getImageName();
    /**
     * Get string description of an element.
     *
     * @return String with a desciption.
     */
    String getDescription();
}

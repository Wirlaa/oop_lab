package agh.ics.oop;
// czy mozemy zmieniac interfejs?

import java.util.List;

/**
 * The interface responsible for interacting with the map of the world.
 * Assumes that Vector2d and MoveDirection classes are defined.
 *
 * @author apohllo
 *
 */
public interface IWorldMap {
    // dodalam getter, bo nie wiem gdzie maja byc trzymane zwierzeta
    List<Animal> getAnimals();

    /**
     * Indicate if any object can move to the given position.
     *
     * @param position
     *            The position checked for the movement possibility.
     * @return True if the object can move to that position.
     */
    boolean canMoveTo(Vector2d position);

    //dodałam parametry position i orientation
    /**
     * Place an animal on the map.
     *
     * @param animal
     *            The animal to place on the map.
     * @param position
     *            Position for placement.
     * @param orientation
     *            Orientation on placement.
     * @return True if the animal was placed. The animal cannot be placed if the map is already occupied.
     */
    boolean place(Animal animal, Vector2d position, MapDirection orientation);

    /**
     * Return true if given position on the map is occupied. Should not be
     * confused with canMove since there might be empty positions where the animal
     * cannot move.
     *
     * @param position
     *            Position to check.
     * @return True if the position is occupied.
     */
    boolean isOccupied(Vector2d position);

    /**
     * Return an object at a given position.
     *
     * @param position
     *            The position of the object.
     * @return Object or null if the position is not occupied.
     */
    Object objectAt(Vector2d position);
}

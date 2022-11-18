package agh.ics.oop;

import java.util.List;

/**
 * The interface responsible for interacting with the map of the world.
 * Assumes that Vector2d and MoveDirection classes are defined.
 *
 * @author apohllo
 *
 */

// zmienilam definicje objectAt i isOccupied wedlug mojej interpretacji
// czy tak sie robi w praktyce ze interfejsy maja definicje getterow?
public interface IWorldMap {
    List<Animal> getAnimals();
    Vector2d getLowerBound();
    Vector2d getUpperBound();
    /**
     * Indicate if any object can move to the given position.
     *
     * @param position
     *            The position checked for the movement possibility.
     * @return True if the object can move to that position.
     */
    boolean canMoveTo(Vector2d position);

    /**
     * Update map accordingly.
     */
    void mapUpdate();

    /**
     * Place an animal on the map.
     *
     * @param animal
     *            The animal to place on the map.
     * @return True if the animal was placed. The animal cannot be placed if the map is already occupied.
     */
    boolean place(Animal animal);

    /**
     * Return true if given position on the map is occupied by another animal. Should not be
     * confused with canMove since there might be empty positions where the animal
     * cannot move.
     *
     * @param position
     *            Position to check.
     * @return True if the position is occupied.
     */

    boolean isOccupied (Vector2d position);

    /**
     * Return an object at a given position.
     * First searches for an object of type animal, then grass.
     *
     * @param position
     *            The position of the object.
     * @return Object or null if the position is not occupied.
     */
    Object objectAt(Vector2d position);

}

package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {

    @Test
    void isOrientationCorrect() {
        // given animal and map
        IWorldMap map = new RectangularMap(10, 5);
        Animal animal = new Animal(map);
        // when starting
        assertEquals(MapDirection.NORTH, animal.getOrientation());
        // after going right 3 times
        for(int i = 0; i < 3; i++) animal.move(MoveDirection.RIGHT);
        assertEquals(MapDirection.WEST, animal.getOrientation());
        // after going left 6 times from there
        for(int i = 0; i < 6; i++) animal.move(MoveDirection.LEFT);
        assertEquals(MapDirection.EAST, animal.getOrientation());
    }

    @Test
    void isMoveWorking() {
        // given animal and map at least 2x2
        IWorldMap map = new RectangularMap(10, 5);
        Animal animal = new Animal(map);
        // when starting
        assertTrue(animal.isAt(map.getLowerBound()));
        // after turning left twice and right once
        animal.move(MoveDirection.LEFT); animal.move((MoveDirection.LEFT)); animal.move((MoveDirection.RIGHT));
        assertTrue(animal.isAt(new Vector2d(0,0)));
        // after going backward, right, forward, right, forward, left, backward
        animal.move(MoveDirection.BACKWARD);
        assertTrue(animal.isAt(new Vector2d(1,0)));
        animal.move(MoveDirection.RIGHT);
        assertTrue(animal.isAt(new Vector2d(1,0)));
        animal.move(MoveDirection.FORWARD);
        assertTrue(animal.isAt(new Vector2d(1,1)));
        animal.move(MoveDirection.RIGHT);
        assertTrue(animal.isAt(new Vector2d(1,1)));
        animal.move(MoveDirection.FORWARD);
        assertTrue(animal.isAt(new Vector2d(2,1)));
        animal.move(MoveDirection.LEFT);
        assertTrue(animal.isAt(new Vector2d(2,1)));
        animal.move(MoveDirection.BACKWARD);
        assertTrue(animal.isAt(new Vector2d(2,0)));
    }

    @Test
    void isInBounds() {
        // given animal and rectangular map with dimensions
        int width = 10;
        int height = 5;
        IWorldMap map = new RectangularMap(width, height);
        Animal animal = new Animal(map);
        // checking north border
        for(int i = 0; i < height + 2; i++) animal.move(MoveDirection.FORWARD);
        assertFalse(animal.isAt(new Vector2d(0,height + 2)));
        assertTrue(animal.isAt(new Vector2d(0,height)));
        // checking west border
        animal.move(MoveDirection.RIGHT);
        for(int i = 0; i < width + 2; i++) animal.move(MoveDirection.FORWARD);
        assertFalse(animal.isAt(new Vector2d(width + 2,height)));
        assertTrue(animal.isAt(new Vector2d(width,height)));
        // checking south border
        animal.move(MoveDirection.RIGHT);
        for(int i = 0; i < height + 2; i++) animal.move(MoveDirection.FORWARD);
        assertFalse(animal.isAt(new Vector2d(width,-2)));
        assertTrue(animal.isAt(new Vector2d(width,0)));
        // checking east border
        animal.move(MoveDirection.RIGHT);
        for(int i = 0; i < width + 2; i++) animal.move(MoveDirection.FORWARD);
        assertFalse(animal.isAt(new Vector2d(-2,0)));
        assertTrue(animal.isAt(new Vector2d(0,0)));
    }

}
package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {

    @Test
    void isOrientationCorrect() {
        // given
        Animal animal = new Animal();
        // when starting
        assertEquals(MapDirection.NORTH.toString(), animal.toString().split(" ")[0]);
        // after going right 3 times
        for(int i = 0; i < 3; i++) animal.move(MoveDirection.RIGHT);
        assertEquals(MapDirection.WEST.toString(), animal.toString().split(" ")[0]);
        // after going left 6 times from there
        for(int i = 0; i < 6; i++) animal.move(MoveDirection.LEFT);
        assertEquals(MapDirection.EAST.toString(), animal.toString().split(" ")[0]);
    }

    @Test
    void isPositionCorrect() {
        // given
        Animal animal = new Animal();
        // when starting
        assertTrue(animal.isAt(new Vector2d(2,2)));
        // after turning left twice and right once
        animal.move(MoveDirection.LEFT); animal.move((MoveDirection.LEFT)); animal.move(MoveDirection.RIGHT);
        assertTrue(animal.isAt(new Vector2d(2,2)));
        // after going forward, left, forward, right, backward
        animal.move(MoveDirection.FORWARD);
        assertTrue(animal.isAt(new Vector2d(1,2)));
        animal.move(MoveDirection.LEFT);
        assertTrue(animal.isAt(new Vector2d(1,2)));
        animal.move(MoveDirection.FORWARD);
        assertTrue(animal.isAt(new Vector2d(1,1)));
        animal.move(MoveDirection.RIGHT);
        assertTrue(animal.isAt(new Vector2d(1,1)));
        animal.move(MoveDirection.BACKWARD);
        assertTrue(animal.isAt(new Vector2d(2,1)));
    }

    @Test
    void isInBounds() {
        // given
        Animal animal = new Animal();
        // checking north border
        for(int i = 0; i < 5; i++) animal.move(MoveDirection.FORWARD);
        assertFalse(animal.isAt(new Vector2d(2,7)));
        assertTrue(animal.isAt(new Vector2d(2,4)));
        // checking west border
        animal.move(MoveDirection.LEFT);
        for(int i = 0; i < 5; i++) animal.move(MoveDirection.FORWARD);
        assertFalse(animal.isAt(new Vector2d(-3,4)));
        assertTrue(animal.isAt(new Vector2d(0,4)));
        // checking south border
        animal.move(MoveDirection.LEFT);
        for(int i = 0; i < 5; i++) animal.move(MoveDirection.FORWARD);
        assertFalse(animal.isAt(new Vector2d(0,-1)));
        assertTrue(animal.isAt(new Vector2d(0,0)));
        // checking east border
        animal.move(MoveDirection.LEFT);
        for(int i = 0; i < 5; i++) animal.move(MoveDirection.FORWARD);
        assertFalse(animal.isAt(new Vector2d(5,0)));
        assertTrue(animal.isAt(new Vector2d(4,0)));
    }

}
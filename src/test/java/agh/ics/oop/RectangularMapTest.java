package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangularMapTest {

    @Test
    void canMoveTo() {
        // given
        int width = 10;
        int height = 5;
        IWorldMap map = new RectangularMap(width, height);
        // when at starting position
        assertTrue(map.canMoveTo(new Vector2d(0,0)));
        // when at border
        assertTrue(map.canMoveTo(new Vector2d(0, height)));
        assertTrue(map.canMoveTo(new Vector2d(width, height)));
        // when out of border
        assertFalse(map.canMoveTo(new Vector2d(-width,height)));
        assertFalse(map.canMoveTo(new Vector2d(0, height + 1)));
        assertFalse(map.canMoveTo(new Vector2d(width, -height)));
        assertFalse(map.canMoveTo(new Vector2d(width + 1, 0)));
    }

    @Test
    void place() {
        // given map at least 3x3
        int width = 10;
        int height = 5;
        IWorldMap map = new RectangularMap(width, height);
        // when
        assertFalse(map.isOccupied(new Vector2d(2,3)));
        map.place(new Animal(map, new Vector2d(2,3), MapDirection.NORTH));
        assertTrue(map.isOccupied(new Vector2d(2,3)));
    }

}
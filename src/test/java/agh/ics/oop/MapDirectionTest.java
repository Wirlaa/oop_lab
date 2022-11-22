package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static agh.ics.oop.MapDirection.*;
import static org.junit.jupiter.api.Assertions.*;

class MapDirectionTest {

    @Test
    void nextTest() {
        assertEquals(SOUTH,EAST.next());
        assertEquals(WEST,SOUTH.next());
        assertEquals(NORTH,WEST.next());
        assertEquals(EAST,NORTH.next());
    }

    @Test
    void previousTest() {
        assertEquals(NORTH,EAST.previous());
        assertEquals(EAST,SOUTH.previous());
        assertEquals(SOUTH,WEST.previous());
        assertEquals(WEST,NORTH.previous());
    }

    @Test
    void toUnitVectorTest() {
        assertEquals(new Vector2d(1,0),EAST.toUnitVector());
        assertEquals(new Vector2d(0,-1),SOUTH.toUnitVector());
        assertEquals(new Vector2d(-1,0),WEST.toUnitVector());
        assertEquals(new Vector2d(0,1),NORTH.toUnitVector());
    }

}
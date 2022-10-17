package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static agh.ics.oop.MapDirection.*;
import static org.junit.jupiter.api.Assertions.*;

class MapDirectionTest {

    //nalezy zmieniac nazwy metod czy nie?
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

}
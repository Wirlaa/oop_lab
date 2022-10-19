package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Vector2dTest {
    Vector2d coords1 = new Vector2d(1,2);
    Vector2d coords2 = new Vector2d(3,0);
    Vector2d coords3 = new Vector2d(1,5);

    @Test
    void precedes() {
        assertFalse(coords1.precedes(coords2));
        assertTrue(coords1.precedes(coords3));
        assertFalse(coords3.precedes(coords1));
    }

    @Test
    void follows() {
        assertFalse(coords1.follows(coords2));
        assertFalse(coords3.follows(coords2));
        assertTrue(coords3.follows(coords1));
    }

    @Test
    void add() {
        assertEquals(new Vector2d(4,2),coords1.add(coords2));
        assertEquals(new Vector2d(4,2),coords2.add(coords1));
        assertEquals(new Vector2d(2,10),coords3.add(coords3));
    }

    @Test
    void substract() {
        assertEquals(new Vector2d(-2,2),coords1.substract(coords2));
        assertEquals(new Vector2d(2,-2),coords2.substract(coords1));
        assertEquals(new Vector2d(0,0),coords3.substract(coords3));
    }

    @Test
    void upperRight() {
        assertEquals(new Vector2d(3,2),coords1.upperRight(coords2));
        assertEquals(new Vector2d(3,2),coords2.upperRight(coords1));
        assertEquals(new Vector2d(1,5),coords3.upperRight(coords3));
    }

    @Test
    void lowerLeft() {
        assertEquals(new Vector2d(1,0),coords1.lowerLeft(coords2));
        assertEquals(new Vector2d(1,0),coords2.lowerLeft(coords1));
        assertEquals(new Vector2d(1,5),coords3.lowerLeft(coords3));
    }

    @Test
    void opposite() {
        assertEquals(new Vector2d(-1,-2),coords1.opposite());
        assertEquals(new Vector2d(-3,0),coords2.opposite());
        assertEquals(new Vector2d(1,5),coords3.opposite().opposite());
    }

    @Test
    void ToString() {
        assertEquals("(1,2)",coords1.toString());
        assertEquals("(3,0)",coords2.toString());
        assertEquals("(1,5)",coords3.toString());
    }

    @Test
    void equals() {
        assertNotEquals(new Vector2d(  1,3), new Vector2d(0,5));
        assertEquals(new Vector2d(3,2), new Vector2d(3,2));
        //istnieje assertSame do sprawdzania adresow
        //given when then
    }
}
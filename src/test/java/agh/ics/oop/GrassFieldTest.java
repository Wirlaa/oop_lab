package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// dodalam porzadniejsze testy, ale w sumie to nie wiem czy je w ogole dobrze pisze :D
class GrassFieldTest {
/*
    @Test
    void isMoveToWorking() {
        // given map with an animal placed on (0,3)
        GrassField map = new GrassField(25);
        map.place(new Animal(map, new Vector2d(0,3), MapDirection.NORTH));
        // try moving to a grass square
        Vector2d position = map.getGrassList().get(0).getPosition();
        assertTrue(map.canMoveTo(position));
        // check if grass square is gone
        assertNull(map.objectAt(position));
        // try moving to a square with an animal
        assertFalse(map.canMoveTo(new Vector2d(0,3)));
    }

    @Test
    void isPlaceWorking() {
        // given map
        GrassField map = new GrassField(25);
        // place first animal
        Animal animal = new Animal(map, new Vector2d(0,3), MapDirection.NORTH);
        assertTrue(map.place(animal));
        // try placing it again
        assertFalse(map.place(animal));
        // try placing at larger coords
        assertTrue(map.place(new Animal(map, new Vector2d(-99999,99999), MapDirection.NORTH)));
    }

    @Test
    void isGrassGeneratorWorking() {
        //given
        GrassField map = new GrassField(25);
        // when starting
        assertEquals(25,map.getGrassList().size());
        // when animal placed on a grass square
        Vector2d position = map.getGrassList().get(0).getPosition();
        map.place(new Animal(map, position, MapDirection.NORTH));
        assertEquals(25,map.getGrassList().size());
        assertFalse(map.objectAt(position) instanceof Grass);
    }

    @Test
    void isPlacingWorking() {
        // given animal and map
        IWorldMap map = new GrassField(25);
        Animal animal = new Animal(map);
        // when starting
        assertTrue(animal.isAt(map.getLowerBound()));
        animal = new Animal(map, new Vector2d(2,5), MapDirection.NORTH);
        assertFalse(animal.isAt(map.getLowerBound()));
        assertTrue(animal.isAt(new Vector2d(2,5)));
    }

    @Test
    void isMapUpdateWorking() {
        // given map
        GrassField map = new GrassField(15);
        // place animal in bounds
        Vector2d lower = map.getLowerBound();
        Vector2d upper = map.getUpperBound();
        map.place(new Animal(map, new Vector2d(2,5).upperRight(lower).lowerLeft(upper), MapDirection.NORTH));
        assertEquals(lower, map.getLowerBound());
        assertEquals(upper, map.getUpperBound());
        // place animal out of bounds
        map.place(new Animal(map, new Vector2d(-10,20), MapDirection.NORTH));
        map.place(new Animal(map, new Vector2d(20,-5), MapDirection.NORTH));
        assertEquals(new Vector2d(-10,-5), map.getLowerBound());
        assertEquals(new Vector2d(20,20), map.getUpperBound());
    }
*/
}
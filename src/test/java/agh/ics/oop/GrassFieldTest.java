package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// dodalam porzadniejsze testy, ale w sumie to nie wiem czy je w ogole dobrze pisze :D
class GrassFieldTest {

    @Test
    void isMoveToWorking() {
        // given map with an animal placed on (0,3)
        GrassField map = new GrassField(25);
        map.place(new Animal(map, new Vector2d(0,3), MapDirection.NORTH));
        // try moving to a grass square
        Vector2d position = map.getElements().values().stream().filter(element -> element instanceof Grass).findAny().get().getPosition();
        assertTrue(map.canMoveTo(position));
        // place an animal at a grass square
        IMapElement grass = map.objectAt(position);
        map.place(new Animal(map, position, MapDirection.NORTH));
        // check if grass square is gone from elements
        assertFalse(map.getElements().containsValue(grass));
        // try moving to a square with an animal
        assertFalse(map.canMoveTo(new Vector2d(0,3)));
    }

    @Test
    void isPlaceWorking() {
        // given map
        GrassField map = new GrassField(25);
        // place first animal
        Animal animal = new Animal(map, new Vector2d(0,3), MapDirection.NORTH);
        assertDoesNotThrow(() -> map.place(animal));
        // try placing it again
        assertThrows(IllegalArgumentException.class, () -> map.place(animal));
        // try placing at larger coords
        assertDoesNotThrow(() -> map.place(new Animal(map, new Vector2d(-99999,99999), MapDirection.NORTH)));
    }

    @Test
    void isGrassGeneratorWorking() {
        //given
        GrassField map = new GrassField(25);
        // when starting
        assertEquals(25,map.getElements().size());
        // when animal placed on a grass square
        Vector2d position = map.getElements().values().stream().filter(element -> element instanceof Grass).findAny().get().getPosition();
        map.place(new Animal(map, position, MapDirection.NORTH));
        assertEquals(26,map.getElements().size());
        assertFalse(map.objectAt(position) instanceof Grass);
    }

}
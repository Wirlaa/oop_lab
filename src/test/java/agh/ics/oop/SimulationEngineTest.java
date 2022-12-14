package agh.ics.oop;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SimulationEngineTest {

    @Test
    void testRunOnRectangularMap() {
        // given
        String[] args = {"f","b","r","l","f","f","r","r","f","f","f","f","f","f","f","f"};
        MoveDirection[] directions = OptionsParser.parse(args);
        IWorldMap map = new RectangularMap(10, 10);
        List<Vector2d> positions = new ArrayList<>();
        positions.add(new Vector2d(1, 2));
        positions.add(new Vector2d(3, 4));
        IEngine engine = new SimulationEngine(directions, map, positions);
        // run engine
        engine.run();
        assertFalse(map.isOccupied(new Vector2d(0,0)));
        assertFalse(map.isOccupied(new Vector2d(2,2)));
        assertFalse(map.isOccupied(new Vector2d(3,4)));
        assertTrue(map.isOccupied(new Vector2d(2,0)));
        assertTrue(map.isOccupied(new Vector2d(3,7)));
    }

    @Test
    void testRunOnGrassField() {
        // given
        String[] args = {"f","b","r","l","f","f","r","r","f","f","f","f","f","f","f","f"};
        MoveDirection[] directions = OptionsParser.parse(args);
        IWorldMap map = new GrassField(15);
        List<Vector2d> positions = new ArrayList<>();
        positions.add(new Vector2d(1, 2));
        positions.add(new Vector2d(3, 4));
        IEngine engine = new SimulationEngine(directions, map, positions);
        // run engine
        engine.run();
        assertFalse(map.isOccupied(new Vector2d(0,0)));
        assertFalse(map.isOccupied(new Vector2d(2,2)));
        assertFalse(map.isOccupied(new Vector2d(3,4)));
        assertTrue(map.isOccupied(new Vector2d(2,-1)));
        assertTrue(map.isOccupied(new Vector2d(3,7)));
    }

}
package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimulationEngineTest {
    String[] args = {"f","b","r","l","f","f","r","r","f","f","f","f","f","f","f","f"};
    MoveDirection[] directions = new OptionsParser().parse(args);
    IWorldMap map = new RectangularMap(10, 5);
    Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
    IEngine engine = new SimulationEngine(directions, map, positions);

    @Test
    void run() {
        engine.run();
        assertFalse(map.isOccupied(new Vector2d(0,0)));
        assertFalse(map.isOccupied(new Vector2d(2,2)));
        assertFalse(map.isOccupied(new Vector2d(3,4)));
        assertTrue(map.isOccupied(new Vector2d(2,0)));
        assertTrue(map.isOccupied(new Vector2d(3,5)));
    }


}
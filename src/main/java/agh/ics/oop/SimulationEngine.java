package agh.ics.oop;


import java.util.List;

public class SimulationEngine implements IEngine {
    private static final MapDirection STARTING_ORIENTATION = MapDirection.NORTH;
    private final MoveDirection[] directions;
    private final IWorldMap map;

    public SimulationEngine(MoveDirection[] directions, IWorldMap map, List<Vector2d> starting_positions) {
        this.directions = directions;
        this.map = map;
        for (Vector2d position: starting_positions) {
            map.place(new Animal(map, position, STARTING_ORIENTATION));
        }
    }
    public void run() {
        //znowu nie wiem czy stream czy streamof
        Animal[] animals = map.getElements().values().stream()
                .filter(element -> element instanceof Animal)
                .toArray(Animal[]::new);
        for (int i = 0; i < directions.length; i++) {
            animals[i % animals.length].move(directions[i]);
        }
        System.out.println(map);
    }
}

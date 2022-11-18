package agh.ics.oop;

public class SimulationEngine implements IEngine {
    private static final MapDirection STARTING_ORIENTATION = MapDirection.NORTH;
    private final MoveDirection[] directions;
    private final IWorldMap map;

    public SimulationEngine(MoveDirection[] directions, IWorldMap map, Vector2d[] starting_positions) {
        this.directions = directions;
        this.map = map;
        for (Vector2d position: starting_positions) {
            map.place(new Animal(map, position, STARTING_ORIENTATION));
        }
    }
    public void run() {
        for (int i = 0; i < directions.length; i++) {
            map.getAnimals().get(i % map.getAnimals().size()).move(directions[i]);
        }
        System.out.println(map.toString());
    }
}
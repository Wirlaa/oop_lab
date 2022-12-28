package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class SimulationEngine implements IEngine {
    private static final MapDirection STARTING_ORIENTATION = MapDirection.NORTH;
    private static final int moveDelay = 300;
    private MoveDirection[] directions;
    private final IWorldMap map;
    private final List<ISimulationChangeObserver> observers = new ArrayList<>();
    private int activeAnimal = 0;
    private Animal[] animals;
    public SimulationEngine(IWorldMap map, List<Vector2d> starting_positions) {
        this(null,map,starting_positions);
    }
    public SimulationEngine(MoveDirection[] directions, IWorldMap map, List<Vector2d> starting_positions) {
        this.directions = directions;
        this.map = map;
        for (Vector2d position: starting_positions) {
            Animal animal = new Animal(map, position, STARTING_ORIENTATION);
            map.place(animal);
        }
    }
    public void setDirections(MoveDirection[] directions) {
        this.directions = directions;
    }
    private void sleep() {
        try {
            Thread.sleep(moveDelay);
        }
        catch (InterruptedException exception) {
            exception.printStackTrace();
        }
    }
    public void run() {
        animals = map.getElements().values().stream()
                .filter(element -> element instanceof Animal)
                .toArray(Animal[]::new);
        simulationChanged();
        sleep();
        for (MoveDirection direction : directions) {
            animals[activeAnimal].move(direction);
            simulationChanged();
            //System.out.println(map);
            sleep();
        }
        //System.out.println(map);
    }
    /*@Override
    public void run() {
        Animal[] animals = map.getElements().values().stream()
                .filter(element -> element instanceof Animal)
                .toArray(Animal[]::new);
        simulationChanged();
        sleep();
        for (int i = 0; i < directions.length; i++) {
            animals[i % animals.length].move(directions[i]);
            simulationChanged();
            //System.out.println(map);
            sleep();
        }
        //System.out.println(map);
    }*/
    public void addObserver (ISimulationChangeObserver observer) {
        observers.add(observer);
    }
    public void removeObserver (ISimulationChangeObserver observer) {
        observers.remove(observer);
    }
    public void simulationChanged() {
        for (ISimulationChangeObserver observer: observers) {
            observer.simulationChanged();
        }
    }
    public void switchActiveAnimal() {
        activeAnimal = (activeAnimal + 1) % animals.length;
    }
}

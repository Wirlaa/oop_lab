package agh.ics.oop;


import agh.ics.oop.gui.App;

import java.util.List;

public class SimulationEngine implements IEngine {//, IPositionChangeObserver {
    private static final MapDirection STARTING_ORIENTATION = MapDirection.NORTH;
    private static final int moveDelay = 300;
    private MoveDirection[] directions;
    private final IWorldMap map;
    private final App app;
    public SimulationEngine(App app, IWorldMap map, List<Vector2d> starting_positions) {
        this(app,null,map,starting_positions);
    }
    public SimulationEngine(MoveDirection[] directions, IWorldMap map, List<Vector2d> starting_positions) {
        this(null,directions,map,starting_positions);
    }
    public SimulationEngine(App app, MoveDirection[] directions, IWorldMap map, List<Vector2d> starting_positions) {
        this.app = app;
        this.directions = directions;
        this.map = map;
        for (Vector2d position: starting_positions) {
            Animal animal = new Animal(map, position, STARTING_ORIENTATION);
            map.place(animal);
            //animal.addObserver(this);
        }
    }
    public void setDirections(MoveDirection[] directions) {
        this.directions = directions;
    }
    @Override
    public void run() {
        //znowu nie wiem czy stream czy streamof
        Animal[] animals = map.getElements().values().parallelStream()
                .filter(element -> element instanceof Animal)
                .toArray(Animal[]::new);
        app.mapUpdate();
        sleep();
        for (int i = 0; i < directions.length; i++) {
            animals[i % animals.length].move(directions[i]);
            app.mapUpdate();
            //System.out.println(map);
            sleep();
        }
        //System.out.println(map);
    }

    /*
    chcialam uwzglednic obserera, ale on nie uwzglednia zmiany orientacji, a chyba nie chodzi o to, zeby tworzyc kolejny interface
    mozna uznac, ze inicjalizacja z aplikacja jest zasubskyrbowaniem, a wywolanie mapUpdate jest powiadamianiem subskrybenta :P
    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        app.mapUpdate();
    }*/

    private void sleep() {
        try {
            Thread.sleep(moveDelay);
        }
        catch (InterruptedException exception) {
            exception.printStackTrace();
        }
    }
}

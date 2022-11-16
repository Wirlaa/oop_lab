package agh.ics.oop;

public class Animal {
    private MapDirection orientation;
    private Vector2d position;
    private IWorldMap map;
    // stary konstruktor raczej nie ma sensu, bo zwierzeta musza byc umieszczone na jakiejs mapie
    // ale przydaje sie do startch testow
    public Animal () {
        this.orientation = MapDirection.NORTH;
        this.position = new Vector2d(0,0);
    }
    // najchetniej to bym zostawila tylko ostatni konstruktor
    public Animal (IWorldMap map) {
        this.map = map;
    }
    public Animal(IWorldMap map, Vector2d initialPosition, MapDirection orientation) {
        this.map = map;
        this.orientation = orientation;
        this.position = initialPosition;
    }
    //gettery
    public MapDirection getOrientation() { return orientation; }
    public Vector2d getPosition() { return position; }
    public IWorldMap getMap() { return map; }

    // przy isAt mozna korzystac z Objects.equals żeby nie wywaliło null
    // ale tutaj mamy wlasnego equals ktory juz to sprawdza (chyba)
    public boolean isAt(Vector2d position) { return this.position.equals(position); }
    @Override
    public String toString()  { return orientation.toString(); }
    public void move(MoveDirection direction) {
        switch (direction) {
            case RIGHT -> orientation = orientation.next();
            case LEFT -> orientation = orientation.previous();
            case FORWARD -> {
                if (map.canMoveTo(position.add(orientation.toUnitVector()))) {
                    position = position.add(orientation.toUnitVector());
                }
            }
            case BACKWARD -> {
                if (map.canMoveTo(position.substract(orientation.toUnitVector()))) {
                    position = position.substract(orientation.toUnitVector());
                }
            }
        }
    }
}


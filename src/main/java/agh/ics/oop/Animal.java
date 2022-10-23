package agh.ics.oop;

public class Animal {
    private MapDirection orientation;
    private Vector2d position;
    //mozna przypisac powyzej zamiast konstruktora
    public Animal (){
        this.orientation = MapDirection.NORTH;
        this.position = new Vector2d(2,2);
    }
    /* pytanie 10:
    moze trzymac liste wszystkich utworzonych obiektow i metode sprawdzajacą, czy pole na ktore przechodzimy nie jest zajete
    albo trzymac mape typu bool, ktora jest automatycznie aktualizowana i od razu zwraca czy miejsce jest wolne
     */
    public boolean isAt(Vector2d position) { return this.position.equals(position); }
    //czy right i left rowniez maja zmieniac pozycje?
    //czy mozna dodac wlasne funkcje?
    //czy dobrze wykorzystuje yield?
    private boolean outOfBounds(Vector2d position){
        Vector2d top = new Vector2d(4,4);
        Vector2d bottom = new Vector2d(0,0);
        return position.upperRight(top).equals(top) && position.lowerLeft(bottom).equals(bottom);
    }
    public void move(MoveDirection direction) {
        this.orientation = switch (direction) {
            case RIGHT: yield this.orientation.next();
            case LEFT: yield this.orientation.previous();
            case FORWARD, BACKWARD:
                Vector2d movement = this.orientation.toUnitVector();
                Vector2d rawposition = (direction == MoveDirection.FORWARD) ? this.position.add(movement) : this.position.substract(movement);
                if (outOfBounds(rawposition)) this.position = rawposition;
                yield this.orientation;
        };

    }
    @Override
    public String toString()  { return orientation.toString() + ' ' + position.toString(); }
}

package agh.ics.oop;

public class Grass extends AMapElement {
    public Grass(Vector2d position) {
        this.position = position;
    }
    @Override
    public String toString() { return "*"; }
}

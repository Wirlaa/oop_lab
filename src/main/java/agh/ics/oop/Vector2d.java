package agh.ics.oop;

import java.util.Objects;
//moze byc record bo wszystkie pola sa publiczne

public class Vector2d {
    final public int x;
    final public int y;
    public Vector2d (int x, int y){
        this.x = x;
        this.y = y;
    }
    // interpretuje ze precedes znaczy ze wazne jest ktory obiekt porownuje a nie czy zachodzi np (5,3) i (7,2)
    public boolean precedes(Vector2d other) {
        return this.x <= other.x && this.y <= other.y;
    }
    public boolean follows(Vector2d other) {
        return this.x >= other.x && this.y >= other.y;
    }
    public Vector2d add(Vector2d other) {
        return new Vector2d (x + other.x,y + other.y);
    }
    public Vector2d substract(Vector2d other) {
        return new Vector2d (x - other.x,y - other.y);
    }
    public Vector2d upperRight(Vector2d other) {
        return new Vector2d (Math.max(this.x, other.x), Math.max(this.y, other.y));
    }
    public Vector2d lowerLeft(Vector2d other) {
        return new Vector2d (Math.min(this.x, other.x), Math.min(this.y, other.y));
    }
    public Vector2d opposite() {
        return new Vector2d (-x,-y);
    }
    @Override
    public String toString() {
        return "(%d,%d)".formatted(x,y);
    }
    @Override
    public boolean equals(Object other) {
        if (other == this) return true;
        if (!(other instanceof Vector2d)) return false;
        Vector2d other2d = (Vector2d) other;
        return other2d.x == this.x && other2d.y == this.y;
    }
    //wygenerowana metoda hashCode
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

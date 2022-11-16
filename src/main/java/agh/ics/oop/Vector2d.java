package agh.ics.oop;

//moze byc record bo wszystkie pola sa final

public record Vector2d(int x, int y) {
    //gettery
    //czy da sie bez nich?
    public int getX() { return x; }
    public int getY() { return y; }
    public boolean precedes(Vector2d other) {
        return this.x <= other.x && this.y <= other.y;
    }
    public boolean follows(Vector2d other) {
        return this.x >= other.x && this.y >= other.y;
    }
    public Vector2d add(Vector2d other) {
        return new Vector2d(x + other.x, y + other.y);
    }
    public Vector2d substract(Vector2d other) {
        return new Vector2d(x - other.x, y - other.y);
    }
    public Vector2d upperRight(Vector2d other) {
        return new Vector2d(Math.max(this.x, other.x), Math.max(this.y, other.y));
    }
    public Vector2d lowerLeft(Vector2d other) {
        return new Vector2d(Math.min(this.x, other.x), Math.min(this.y, other.y));
    }
    public Vector2d opposite() {
        return new Vector2d(-x, -y);
    }
    @Override
    public String toString() {
        return "(%d,%d)".formatted(x, y);
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) return true;
        if (!(other instanceof Vector2d)) return false;
        Vector2d other2d = (Vector2d) other;
        return other2d.x == this.x && other2d.y == this.y;
    }
}

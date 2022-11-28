package agh.ics.oop;

public record Vector2d(int x, int y) {
    public int getX() { return x; }
    public int getY() { return y; }
    // troche nie wiem gdzie trzeba bylo uzyc precedes i follows, bo ich nigdzie nie wykorzystuje
    // upperRight i lowerLeft wydaja mi sie wystarczajace
    public boolean precedes(Vector2d other) {
        return this.x <= other.x && this.y <= other.y;
    }
    public boolean follows(Vector2d other) {
        return this.x >= other.x && this.y >= other.y;
    }
    public Vector2d add(Vector2d other) {
        return new Vector2d(x + other.x, y + other.y);
    }
    public Vector2d subtract(Vector2d other) {
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
}

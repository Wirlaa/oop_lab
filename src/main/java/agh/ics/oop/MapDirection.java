package agh.ics.oop;

public enum MapDirection {
    NORTH,
    SOUTH,
    EAST,
    WEST;
    public MapDirection next() {
        return switch (this) {
            case NORTH -> EAST;
            case SOUTH -> WEST;
            case EAST -> SOUTH;
            case WEST -> NORTH;
        };
    }
    public MapDirection previous() {
        return switch (this) {
            case NORTH -> WEST;
            case SOUTH -> EAST;
            case EAST -> NORTH;
            case WEST -> SOUTH;
        };
    }
    public Vector2d toUnitVector() {
        return switch (this) {
            case NORTH -> new Vector2d(0, 1);
            case SOUTH -> new Vector2d(0, -1);
            case EAST -> new Vector2d(1, 0);
            case WEST -> new Vector2d(-1, 0);
        };
    }
    public String toName() {
        return switch (this) {
            case NORTH -> "Północ";
            case SOUTH -> "Południe";
            case EAST -> "Wschód";
            case WEST -> "Zachód";
        };
    }
    @Override
    public String toString() {
        return switch (this) {
            case NORTH -> "^";
            case SOUTH -> "v";
            case EAST -> ">";
            case WEST -> "<";
        };
    }
}

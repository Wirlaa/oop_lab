package agh.ics.oop;
import static agh.ics.oop.Direction.*;
import static java.lang.System.out;

public class World {
    public static void main(String[] args) {
        out.println("start");
        Direction[] directions = str_to_enum(args);
        run(directions);
        out.println("stop");
    }
    public static Direction[] str_to_enum(String[] args) {
        Direction[] enumDirections = new Direction[args.length];
        for (int i = 0; i < args.length; i++) {
            //enumDirections[i] = Direction.valueOf(args[i]); wywala blad
            enumDirections[i] = switch (args[i]) {
                case "f" -> FORWARD;
                case "b" -> BACKWARD;
                case "r" -> RIGHT;
                case "l" -> LEFT;
                default -> null;
            };
        }
        return enumDirections;
    }
    public static void run(Direction[] directions) {
        //out.println(String.join(", ", directions)); fajny sposob na laczenie napisow
        for (Direction argument : directions) {
            String direction = switch (argument) {
                case FORWARD -> "do przodu";
                case BACKWARD -> "do tyłu";
                case RIGHT -> "w prawo";
                case LEFT -> "w lewo";
            };
            out.println(direction);
        }
    }
}
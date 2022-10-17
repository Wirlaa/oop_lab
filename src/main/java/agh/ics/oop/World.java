package agh.ics.oop;

import static agh.ics.oop.MoveDirection.*;
import static java.lang.System.out;
import static agh.ics.oop.MapDirection.*;

public class World {
    public static void main(String[] args) {
        /*out.println("start");
        Direction[] directions = strToEnum(args);
        run(directions);
        out.println("stop");*/
        Vector2d position1 = new Vector2d(1,2);
        out.println(position1);
        Vector2d position2 = new Vector2d(1,2);
        out.println(position2);
        out.println(position1.add(position2));
        out.println(EAST);
        out.println(WEST.next());
        out.println(NORTH.previous());
        out.println(SOUTH.toUnitVector());

    }
    public static MoveDirection[] strToEnum(String[] args) {
        MoveDirection[] enumDirections = new MoveDirection[args.length];
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
    public static void run(MoveDirection[] directions) {
        //out.println(String.join(", ", directions)); fajny sposob na laczenie napisow
        for (MoveDirection argument : directions) {
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
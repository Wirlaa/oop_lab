package agh.ics.oop;

import java.util.Arrays;
import static java.lang.System.out;

public class World {
    public static void main(String[] args) {
        /*out.println("start");
        Direction[] directions = strToEnum(args);
        run(directions);
        out.println("stop");
        Vector2d position1 = new Vector2d(1,2);
        out.println(position1);
        Vector2d position2 = new Vector2d(1,2);
        out.println(position2);
        out.println(position1.add(position2));
        out.println(EAST);
        out.println(WEST.next());
        out.println(NORTH.previous());
        out.println(SOUTH.toUnitVector());

        Animal cat = new Animal();
        out.println(cat);
        cat.move(RIGHT);
        out.println(cat);
        cat.move(FORWARD);
        out.println(cat);
        cat.move(FORWARD);
        out.println(cat);
        cat.move(FORWARD);
        out.println(cat);*/

        out.println(Arrays.toString(OptionsParser.parse(args)));

        //run(OptionsParser.parse(args));


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
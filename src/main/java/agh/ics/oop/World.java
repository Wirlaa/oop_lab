package agh.ics.oop;

import java.util.Arrays;
import static java.lang.System.out;

public class World {
    public static void main(String[] args) {
        Animal cat = new Animal();
        out.println(Arrays.toString(OptionsParser.parse(args)));
        run(OptionsParser.parse(args), cat);
        out.println(cat);
    }

    public static void run(MoveDirection[] directions, Animal animal) {
        //out.println(String.join(", ", directions)); fajny sposob na laczenie napisow
        for (MoveDirection direction : directions) animal.move(direction);
    }
}
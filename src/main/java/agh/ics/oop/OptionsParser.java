package agh.ics.oop;

import java.util.ArrayList;

public class OptionsParser {
    //korzystam z listarray, ktora potem konwertuje na array
    public static MoveDirection[] parse(String[] options) {
        ArrayList<MoveDirection> directionsList = new ArrayList<>();
        for (String option : options) {
            MoveDirection direction = switch (option) {
                case "f", "forward" -> MoveDirection.FORWARD;
                case "b", "backward" -> MoveDirection.BACKWARD;
                case "r", "right" -> MoveDirection.RIGHT;
                case "l", "left" -> MoveDirection.LEFT;
                default -> null;
            };
            if (direction != null) directionsList.add(direction);
        }
        return directionsList.toArray(new MoveDirection[0]);
    }
}

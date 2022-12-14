package agh.ics.oop;

import java.util.Objects;
import java.util.stream.Stream;

public class OptionsParser {
    public static MoveDirection[] parse(String[] options) {
        return Stream.of(options)
                .map(OptionsParser::getMoveDirection)
                .filter(Objects::nonNull)
                .toArray(MoveDirection[]::new);
    }
    private static MoveDirection getMoveDirection(String option) throws IllegalArgumentException {
        return switch (option) {
            case "f", "forward" -> MoveDirection.FORWARD;
            case "b", "backward" -> MoveDirection.BACKWARD;
            case "r", "right" -> MoveDirection.RIGHT;
            case "l", "left" -> MoveDirection.LEFT;
            default -> throw new IllegalArgumentException(option + " is not legal move specification");
        };
    }

}

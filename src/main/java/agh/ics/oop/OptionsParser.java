package agh.ics.oop;

import java.util.Objects;
import java.util.stream.Stream;

public class OptionsParser {
    // kazda kolekcje mozna zamienic na streamy
    // mpa, filter, reduce
    public static MoveDirection[] parse(String[] options) {
        return Stream.of(options)
                .map(OptionsParser::getMoveDirection)
                .filter(Objects::nonNull)
                .toArray(MoveDirection[]::new);
    }
    private static MoveDirection getMoveDirection(String option) {
        return switch (option) {
            case "f", "forward" -> MoveDirection.FORWARD;
            case "b", "backward" -> MoveDirection.BACKWARD;
            case "r", "right" -> MoveDirection.RIGHT;
            case "l", "left" -> MoveDirection.LEFT;
            default -> null;
        };
    }

}

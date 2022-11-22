package agh.ics.oop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OptionsParserTest {

    @Test
    void parse() {
        String[] options = new String[] {"f", "left", "dsa", "vad", "r"};
        MoveDirection[] directions = new MoveDirection[] {MoveDirection.FORWARD, MoveDirection.LEFT, MoveDirection.RIGHT};
        assertArrayEquals(directions, OptionsParser.parse(options));
    }
}
package agh.ics.oop;

public class OptionsParser {
    //czy tablica wynikowa moze byc dluzsza?
    public static MoveDirection[] parse(String[] options) {
        MoveDirection[] directions = new MoveDirection[options.length];
        //List<MoveDirection> directions = new ArrayList<>();
        for (int i = 0; i < options.length; i++) {
            directions[i] = switch (options[i]) {
                case "f", "forward": yield MoveDirection.FORWARD;
                case "b", "backward": yield MoveDirection.BACKWARD;
                case "r", "right": yield MoveDirection.RIGHT;
                case "l", "left": yield MoveDirection.LEFT;
                default: yield null;
            };
        }
        System.out.println(java.util.Arrays.toString(directions));
        return directions;
    }
}

import java.util.Arrays;
import java.util.List;

public class MarsRover {
    public static final int LEFT_ROTATION = -1;
    public static final int RIGHT_ROTATION = +1;
    private String orientation;
    private final List<String> rotations = Arrays.asList("N", "E", "S", "W");
    private int positionY;

    public MarsRover() {
        orientation = "N";
        positionY = 0;
    }

    public String execute(String commands) {
        for (int i = 0; i < commands.length(); i++) {
            char command = commands.charAt(i);
            if (command == 'M') {
                positionY++;
            }
            if ('R' == command) {
                rotateRight();
            }

            if ('L' == command) {
                rotateLeft();
            }
        }


        return "0:" + positionY + ":" + orientation;
    }

    private void rotateLeft() {
        orientation = rotate(LEFT_ROTATION);
    }

    private void rotateRight() {
        orientation = rotate(RIGHT_ROTATION);
    }

    private String rotate(int direction) {
        return rotations.get((rotations.indexOf(orientation) + direction + 4) % 4);
    }

}

import java.util.Arrays;
import java.util.List;

public class MarsRover {
    public static final int LEFT_ROTATION = -1;
    public static final int RIGHT_ROTATION = +1;
    private int positionX;
    private int positionY;
    private char orientation;
    private final List<Character> rotations = Arrays.asList('N', 'E', 'S', 'W');

    public MarsRover() {
        orientation = 'N';
        positionX = 0;
        positionY = 0;
    }

    public String execute(String commands) {
        for (int i = 0; i < commands.length(); i++) {
            char command = commands.charAt(i);
            if (command == 'M' && orientation == 'N') {
                positionY++;
            }
            if (command == 'M' && orientation == 'E') {
                positionX++;
            }
            if ('R' == command) {
                rotateRight();
            }

            if ('L' == command) {
                rotateLeft();
            }
        }


        return positionX + ":" + positionY + ":" + orientation;
    }

    private void rotateLeft() {
        orientation = rotate(LEFT_ROTATION);
    }

    private void rotateRight() {
        orientation = rotate(RIGHT_ROTATION);
    }

    private Character rotate(int direction) {
        return rotations.get((rotations.indexOf(orientation) + direction + 4) % 4);
    }

}

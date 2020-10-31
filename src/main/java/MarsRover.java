import java.util.Arrays;

public class MarsRover {
    private String orientation;
    private final String[] rotations = new String[]{"N", "E", "S", "W"};

    public MarsRover() {
        orientation = "N";
    }

    public String execute(String commands) {
        int number = 0;
        for (int i = 0; i < commands.length(); i++) {
            char command = commands.charAt(i);
            if (command == 'M') {
                number++;
            }
            if ('R' == command) {
                rotateRight();
            }

            if ('L' == command) {
                rotateLeft();
            }
        }


        return "0:" + number + ":" + orientation;
    }

    private void rotateLeft() {
        int nextOrientation = (Arrays.asList(rotations).indexOf(orientation) - 1 + 4) % 4;
        orientation = rotations[nextOrientation];
    }

    private void rotateRight() {
        int nextOrientation = (Arrays.asList(rotations).indexOf(orientation) + 1 + 4) % 4;
        orientation = rotations[nextOrientation];
    }

}

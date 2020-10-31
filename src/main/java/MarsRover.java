import java.util.Arrays;

public class MarsRover {
    private String orientation;

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
                String[] rotations = {"N", "E", "S", "W"};
                int nextOrientation = (Arrays.asList(rotations).indexOf(orientation) + 1) % 4;
                if ("W".equals(orientation)) {
                    orientation = rotations[nextOrientation];
                } else if ("N".equals(orientation)) {
                    orientation = rotations[nextOrientation];
                } else if ("E".equals(orientation)) {
                    orientation = rotations[nextOrientation];
                } else if ("S".equals(orientation)) {
                    orientation = rotations[nextOrientation];
                }
            }

            if ('L' == command) {
                if ("E".equals(orientation)) {
                    orientation = "N";
                } else if ("W".equals(orientation)) {
                    orientation = "S";
                } else if ("S".equals(orientation)) {
                    orientation = "E";
                } else {
                    orientation = "W";
                }

            }
        }


        return "0:" + number + ":" + orientation;
    }

}

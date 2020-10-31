public class MarsRover {
    private String orientation = "N";

    public MarsRover() {
        orientation = "N";
    }

    public MarsRover(String initialOrientation) {
        this.orientation = initialOrientation;
    }

    public String execute(String commands) {
        int number = 0;
        for (int i = 0; i < commands.length(); i++) {
            char command = commands.charAt(i);
            if (command == 'M') {
                number++;
            }
            if ('R' == command) {
                if ("W".equals(orientation)) {
                    orientation = "N";
                } else if ("N".equals(orientation)) {
                    orientation = "E";
                }
            }

            if ('L' == command) {
                if ("E".equals(orientation)) {
                    orientation = "N";
                } else if ("W".equals(orientation)) {
                    orientation = "S";
                } else {

                    orientation = "W";
                }

            }
        }


        return "0:" + String.valueOf(number) + ":" + orientation;
    }

}

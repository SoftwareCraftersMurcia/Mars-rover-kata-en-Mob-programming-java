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
                if ("W".equals(orientation)) {
                    orientation = "N";
                } else if ("N".equals(orientation)) {
                    orientation = "E";
                } else if ("E".equals(orientation)) {
                    orientation = "S";
                } else if ("S".equals(orientation)) {
                    orientation = "W";
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

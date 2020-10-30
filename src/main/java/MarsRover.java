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
            if ( command == 'M') {
                number++;
            }
        }

        if ("R".equals(commands)) {
            if ("W".equals(orientation)) {
                orientation = "N";
            }
        }

        if ("L".equals(commands)) {
            orientation = "W";
        }



        return "0:" + String.valueOf(number) + ":" + orientation;
    }

}

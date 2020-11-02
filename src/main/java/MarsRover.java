public class MarsRover {
    private String orientation = "N";

    public String execute(String commands) {
        int number = 0;
        for (int i = 0; i < commands.length(); i++) {
            char command = commands.charAt(i);
            if (command == 'M') {
                number++;
            }
            if ('R' == command) {
                if ("N".equals(orientation)) {
                    orientation = "E";
                }else if ("E".equals(orientation)) {
                    orientation = "S";
                }else if ("S".equals(orientation)) {
                    orientation = "W";
                }else  {
                    orientation = "N";
                }
            }

            if ('L' == command) {
                if ("N".equals(orientation)) {
                    orientation = "W";
                }else if ("W".equals(orientation)) {
                    orientation = "S";
                }else if ("S".equals(orientation)) {
                    orientation = "E";
                }else  {
                    orientation = "N";
                }
            }
        }



        return "0:" + String.valueOf(number) + ":" + orientation;
    }
}

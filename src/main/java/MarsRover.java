public class MarsRover {
    private String orientation = "N";

    public String execute(String commands) {
        int number = 0;
        for (int i = 0; i < commands.length(); i++) {
            char command = commands.charAt(i);
            if ( command == 'M') {
                number++;
            }

            if ("R".equals(command)) {
                orientation = "E";
            }

            if ("L".equals(command)) {
                orientation = "W";
            }
        }



        return "0:" + String.valueOf(number) + ":" + orientation;
    }

}
public class MarsRover {
    private String orientation = "N";

    public String execute(String command) {
        int number = 0;
        for (int i = 0; i < command.length(); i++) {
            if (command.charAt(i) == 'M') {
                number++;
            }
        }

        if ("R".equals(command)) {
            orientation = "E";
        }

        if ("L".equals(command)) {
            orientation = "W";
        }

        return "0:" + String.valueOf(number) + ":" + orientation;
    }

}

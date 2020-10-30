public class MarsRover {
    private String orientation = "N";

    public String execute(java.lang.String command) {
        int number = 0;
        for (int i = 0; i < command.length(); i++) {
            if (command.charAt(i) != "M") {
                
            }
            number++;
        }

        if (command == "R") {
            orientation = "E";
        }

        return "0:" + String.valueOf(number) + ":" + orientation;
    }

}

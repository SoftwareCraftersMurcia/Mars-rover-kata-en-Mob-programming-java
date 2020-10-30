public class MarsRover {

    public String execute(java.lang.String command) {
        int number = 0;
        for (int i = 0; i < command.length(); i++) {
           number++;
        }

        if (command == "R")

        return "0:"+ String.valueOf(number)+ ":N";
    }

}

import java.util.Arrays;
import java.util.List;

public class MarsRover {
    private Character orientation = 'N';
    private final List<Character> rotationList = Arrays.asList(new Character[] { 'N', 'E', 'S', 'W' });

    public String execute(String commands) {
        int number = 0;
        for (int i = 0; i < commands.length(); i++) {
            char command = commands.charAt(i);
            if (command == 'M') {
                number++;
            }
            if (command == 'R') {
                orientation = rotationList.get((rotationList.indexOf(orientation) + 1) % 4);
            }
            if (command == 'L') {
                orientation = rotationList.get((rotationList.indexOf(orientation) + 3) % 4);
            }
        }

        return "0:" + String.valueOf(number) + ":" + orientation;
    }
}

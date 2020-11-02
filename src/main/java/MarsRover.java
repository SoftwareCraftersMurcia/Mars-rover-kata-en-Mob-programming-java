import java.util.Arrays;
import java.util.List;

public class MarsRover {
    private final List<Character> rotationList = Arrays.asList(new Character[] { 'N', 'E', 'S', 'W' });
    private final Grid grid;

    public MarsRover(Grid grid){
        this.grid = grid;
    }

    public String execute(String commands) {
        Character orientation = 'N';
        int number = 0;
        for (int i = 0; i < commands.length(); i++) {
            char command = commands.charAt(i);
            if (command == 'M') {
                if (grid == null) {
                    number++;
                }
            }
            else if (command == 'R') {
                orientation = rotationList.get((rotationList.indexOf(orientation) + 1) % 4);
            }
            else if (command == 'L') {
                orientation = rotationList.get((rotationList.indexOf(orientation) + 3) % 4);
            }
        }

        return "0:" + String.valueOf(number) + ":" + orientation;
    }
}

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class MarsRover {
    private final List<Character> rotationList = Arrays.asList(new Character[] { 'N', 'E', 'S', 'W' });
    private final Grid grid;

    public MarsRover(Grid grid){
        Objects.requireNonNull(grid);
        this.grid = grid;
    }

    public String execute(String commands) {
        Character orientation = 'N';
        int positionY = 0;
        int positionX = 0;
        for (int i = 0; i < commands.length(); i++) {
            char command = commands.charAt(i);
            if (command == 'M') {
                if (orientation == 'N') {
                    positionY = (positionY + 1) % grid.getHeight();
                }
                else if (orientation == 'S') {
                    positionY = (positionY - 1) % grid.getHeight();
                }
                else if (orientation == 'E') {
                    positionX = (positionX + 1) % grid.getWidth();
                }
                else if (orientation == 'W') {
                    positionX = (positionX - 1) % grid.getWidth();
                }
            }
            else if (command == 'R') {
                orientation = rotationList.get((rotationList.indexOf(orientation) + 1) % 4);
            }
            else if (command == 'L') {
                orientation = rotationList.get((rotationList.indexOf(orientation) + 3) % 4);
            }
        }

        return positionX + ":" + positionY + ":" + orientation;
    }
}

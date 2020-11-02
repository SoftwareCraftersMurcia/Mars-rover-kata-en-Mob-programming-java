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
        Position position = new Position(0, 0);
        for (int i = 0; i < commands.length(); i++) {
            char command = commands.charAt(i);
            if (command == 'M') {
                position = grid.advanceOne(position, getOrientation(orientation));
            }
            else if (command == 'R') {
                orientation = rotationList.get((rotationList.indexOf(orientation) + 1) % 4);
            }
            else if (command == 'L') {
                orientation = rotationList.get((rotationList.indexOf(orientation) + 3) % 4);
            }
        }

        return position + ":" + orientation;
    }

    private Orientation getOrientation(char charOrientation) {
        switch (charOrientation) {
            case 'N':
                return Orientation.NORTH;
            case 'E':
                return Orientation.EAST;
            case 'S':
                return Orientation.SOUTH;
            case 'W':
                return Orientation.WEST;
            default:
                return null;
        }
    }

}

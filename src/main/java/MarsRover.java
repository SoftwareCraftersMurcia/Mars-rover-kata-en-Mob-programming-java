import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class MarsRover {
    private final List<Orientation> rotationList =
            Arrays.asList(new Orientation[] {
                    Orientation.NORTH,
                    Orientation.EAST,
                    Orientation.SOUTH,
                    Orientation.WEST
            });
    private final Grid grid;

    public MarsRover(Grid grid){
        Objects.requireNonNull(grid);
        this.grid = grid;
    }

    public String execute(String commands) {
        Orientation orientation = Orientation.NORTH;
        Position position = new Position(0, 0);
        for (int i = 0; i < commands.length(); i++) {
            char command = commands.charAt(i);
            if (command == 'M') {
                position = grid.advanceOne(position, orientation);
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

}

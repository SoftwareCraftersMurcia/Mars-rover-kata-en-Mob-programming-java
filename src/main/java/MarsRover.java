import java.util.Objects;

public class MarsRover {

    private final Grid grid;

    public MarsRover(Grid grid){
        Objects.requireNonNull(grid);
        this.grid = grid;
    }

    public String execute(String commands) {
        boolean obstacleFound = false;
        RoverStatus status = new RoverStatus(Orientation.NORTH, 0, 0);

        for(char command : commands.toCharArray()) {
            if (command == 'M') {
                AdvanceResult advanceResult = grid.advanceOne(status.getPosition(), status.getOrientation());
                if (advanceResult.isObstacleDetected()) {
                    obstacleFound = true;
                    break;
                }
                status = new RoverStatus(status.getOrientation(), advanceResult.getPosition());
            }
            else if (command == 'R') {
                status = status.rotateRight();
            }
            else if (command == 'L') {
                status = status.rotateLeft();
            }
        }

        return (obstacleFound ? "O:" : "") + status.toString();
    }
}

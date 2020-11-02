import java.util.ArrayList;
import java.util.List;

public class Grid {
    private int width;
    private int height;
    private boolean[][] obstacleGrid;

    public Grid(int width, int height) {
        this(width, height, new ArrayList());
    }

    public Grid(int width, int height, List<Position> obstacles) {
        this.width = width;
        this.height = height;
        this.obstacleGrid = new boolean[width][height];
        for(Position obstacle : obstacles) {
            obstacleGrid[obstacle.getX()][obstacle.getY()] = true;
        }
    }

    public Position advanceOne(Position position, Orientation orientation) {
        Position nextPosition = null;
        if (orientation == Orientation.NORTH) {
            nextPosition = new Position(position.getX(), (position.getY() + 1) % height);
        }
        else if (orientation == Orientation.SOUTH) {
            nextPosition = new Position(position.getX(), Math.abs((position.getY() + (height - 1)) % height));
        }
        else if (orientation == Orientation.EAST) {
            nextPosition = new Position((position.getX() + 1) % width, position.getY());
        }
        else if (orientation == Orientation.WEST) {
            nextPosition = new Position(Math.abs((position.getX() + (width - 1)) % width), position.getY());
        }

        return isPositionInObstacle(nextPosition) ? null : nextPosition;
    }

    private boolean isPositionInObstacle(Position position){
        return obstacleGrid[position.getX()][position.getY()];
    }
}

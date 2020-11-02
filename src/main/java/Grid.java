import java.util.ArrayList;
import java.util.List;

class Grid {
    List<Position> obstacles = new ArrayList<>();
    int size  = 10;

    Grid(int size){
        this.size = size;
    }

    public Grid(int size, List<Position> obstacles) {
        this.size = size;
        this.obstacles = obstacles;
    }

    public Position wrapAcrossBoundsPosition(Position position){
        Position standardisedPosition = new Position((position.x + size) % size,(position.y+size) % size);
        return standardisedPosition;
    }

    public boolean checkForObstacleAtPosition(Position position) {
        return obstacles.indexOf(position) >=0;
    }
}

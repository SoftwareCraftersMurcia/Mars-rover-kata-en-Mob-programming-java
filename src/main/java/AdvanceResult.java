public class AdvanceResult {
    boolean obstacleDetected;
    Position position;

    public AdvanceResult(Position position, boolean obstacleDetected) {
        this.obstacleDetected = obstacleDetected;
        this.position = position;
    }

    public boolean isObstacleDetected() {
        return obstacleDetected;
    }

    public Position getPosition() {
        return position;
    }
}

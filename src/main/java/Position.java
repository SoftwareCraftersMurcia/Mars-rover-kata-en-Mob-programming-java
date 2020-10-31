public class Position {
    private final Orientation orientation;

    private final int positionX;
    private final int positionY;

    public Position(int positionX, int positionY, Orientation orientation) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.orientation = orientation;
    }

    public Position rotate(RotationCommand rotation) {
        return new Position(positionX, positionY, rotation.rotate(orientation));
    }

    public Position moveForward() {
        return this.move(orientation.movement());
    }

    private Position move(Movement movement) {
        return new Position(
                roundWorld(positionX + movement.getHorizontalMovement()),
                roundWorld(positionY + movement.getVerticalMovement()),
                orientation
        );
    }

    private int roundWorld(int x) {
        return (x + 10) % 10;
    }

    @Override
    public String toString() {
        return positionX + ":" + positionY + ":" + orientation.toString();
    }

    private int moveY(int amount) {
        return (positionY + amount + 10) % 10;
    }

    private int moveX(int amount) {
        return (positionX + amount + 10) % 10;
    }
}
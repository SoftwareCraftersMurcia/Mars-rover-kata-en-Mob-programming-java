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
        switch (orientation) {
            case North:
                return this.move(new Movement(0, 1));
            case South:
                return new Position(positionX, moveY(-1), orientation);
            case East:
                return new Position(moveX(1), positionY, orientation);
            case West:
                return new Position(moveX(-1), positionY, orientation);
        }
        throw new IllegalArgumentException("The orientation " + orientation + " is not valid");
    }

    private Position move(Movement movement) {
        return new Position(
                roundWorld(positionX + movement.getVerticalMovement()),
                roundWorld(positionY + movement.getHorizontalMovement()),
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
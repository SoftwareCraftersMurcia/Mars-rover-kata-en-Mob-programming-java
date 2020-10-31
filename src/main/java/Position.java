public class Position {
    private Orientation orientation;

    private int positionX;
    private int positionY;

    public Position(int positionX, int positionY, Orientation orientation) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.orientation = orientation;
    }

    public Position rotateLeft() {
        this.orientation = orientation.rotateLeft();
        return new Position(positionX, positionY, orientation);
    }

    public Position rotateRight() {
        this.orientation = orientation.rotateRight();
        return new Position(positionX, positionY, orientation);
    }


    public Position moveForward() {
        switch (orientation) {
            case North:
                moveY(+1);
                break;
            case South:
                moveY(-1);
                break;
            case East:
                moveX(+1);
                break;
            case West:
                moveX(-1);
                break;
        }
        return new Position(positionX, positionY, orientation);
    }

    @Override
    public String toString() {
        return positionX + ":" + positionY + ":" + orientation.toString();
    }

    private void moveY(int amount) {
        this.positionY = (positionY + amount + 10) % 10;
    }

    private void moveX(int amount) {
        this.positionX = (positionX + amount + 10) % 10;
    }
}
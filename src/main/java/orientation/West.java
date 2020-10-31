package orientation;

public class West implements Orientation {
    @Override
    public Orientation rotateRight() {
        return new North();
    }

    @Override
    public Orientation rotateLeft() {
        return new South();
    }

    public Movement movement() {
        return new Movement(-1, 0);
    }

    @Override
    public String toString() {
        return "W";
    }
}

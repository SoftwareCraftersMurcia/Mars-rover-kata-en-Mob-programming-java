package orientation;

public class North implements Orientation {
    @Override
    public Orientation rotateRight() {
        return new Est();
    }

    @Override
    public Orientation rotateLeft() {
        return new West();
    }

    @Override
    public Movement movement() {
        return new Movement(0, 1);
    }

    @Override
    public String toString() {
        return "N";
    }
}

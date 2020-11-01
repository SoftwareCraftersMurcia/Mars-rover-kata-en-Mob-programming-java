package mars.orientation;

import mars.Movement;

public class North implements Orientation {
    @Override
    public Orientation rotateRight() {
        return new East();
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

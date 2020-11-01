package mars.orientation;

import mars.Movement;

public class East implements Orientation {
    @Override
    public Orientation rotateRight() {
        return new South();
    }

    @Override
    public Orientation rotateLeft() {
        return new North();
    }

    @Override
    public Movement movement(){
        return new Movement(1, 0);
    }

    @Override
    public String toString() {
        return "E";
    }
}

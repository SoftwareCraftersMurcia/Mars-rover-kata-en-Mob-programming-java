package mars.orientation;

import mars.Movement;

public class South implements Orientation {
    @Override
    public Orientation rotateRight() {
        return new West();
    }

    @Override
    public Orientation rotateLeft() {
        return new Est();
    }

    @Override
    public Movement movement(){
        return new Movement(0, -1);
    }

    @Override
    public String toString() {
        return "S";
    }
}

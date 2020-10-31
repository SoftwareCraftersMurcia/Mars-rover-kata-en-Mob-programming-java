package mars.orientation;

import mars.Movement;

public interface Orientation {
    Orientation rotateRight();

    Orientation rotateLeft();

    Movement movement();
}

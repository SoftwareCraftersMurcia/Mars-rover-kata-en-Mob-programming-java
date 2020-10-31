import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.Arrays;
import java.util.List;

public class Position {
    private final List<Character> rotationsAsCharacter = Arrays.asList('N', 'E', 'S', 'W');
    private final List<Orientation> rotations = Arrays.asList(Orientation.North, Orientation.East, Orientation.South, Orientation.West);
    private Orientation orientation;

    private int positionX;
    private int positionY;
    private char orientationAsChar;

    public Position(int positionX, int positionY, char orientationAsChar, Orientation orientation) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.orientationAsChar = orientationAsChar;
        this.orientation = orientation;
    }

    @Override
    public String toString() {
        return positionX + ":" + positionY + ":" + orientationAsChar;
    }

    void rotate(int direction) {
        this.orientationAsChar = rotationsAsCharacter.get((rotationsAsCharacter.indexOf(orientationAsChar) + direction + 4) % 4);
        this.orientation = rotations.get((rotations.indexOf(orientation) + direction + 4) % 4);
    }

    void moveY(int amount) {
        this.positionY = (positionY + amount + 10) % 10;
    }

    void moveX(int amount) {
        this.positionX = (positionX + amount + 10) % 10;
    }

    void moveForward() {
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
    }
}
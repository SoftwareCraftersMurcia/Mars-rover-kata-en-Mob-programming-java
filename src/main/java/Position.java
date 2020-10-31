import java.util.Arrays;
import java.util.List;

public class Position {
    private final List<Character> rotations = Arrays.asList('N', 'E', 'S', 'W');
    private final Orientation orientation;

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
        this.orientationAsChar = rotations.get((rotations.indexOf(orientationAsChar) + direction + 4) % 4);
    }

    void moveY(int amount) {
        this.positionY = (positionY + amount + 10) % 10;
    }

    void moveX(int amount) {
        this.positionX = (positionX + amount + 10) % 10;
    }

    void moveForward() {
        switch (orientationAsChar) {
            case 'N':
                moveY(+1);
                break;
            case 'S':
                moveY(-1);
                break;
            case 'E':
                moveX(+1);
                break;
            case 'W':
                moveX(-1);
                break;
        }
    }
}
import java.util.Arrays;
import java.util.List;

public class Position {
    private final List<Character> rotations = Arrays.asList('N', 'E', 'S', 'W');

    private int positionX;
    private int positionY;
    private char orientation;

    public Position(int positionX, int positionY, char orientation) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.orientation = orientation;
    }

    @Override
    public String toString() {
        return positionX + ":" + positionY + ":" + getOrientation();
    }

    public char getOrientation() {
        return orientation;
    }

    void rotate(int direction) {
        this.orientation = rotations.get((rotations.indexOf(getOrientation()) + direction + 4) % 4);
    }

    void moveY(int amount) {
        this.positionY = (positionY + amount + 10) % 10;
    }

    void moveX(int amount) {
        this.positionX = (positionX + amount + 10) % 10;
    }
}
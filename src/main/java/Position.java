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

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public char getOrientation() {
        return orientation;
    }

    void rotate(int direction) {
        this.orientation = rotations.get((rotations.indexOf(getOrientation()) + direction + 4) % 4);
    }
}
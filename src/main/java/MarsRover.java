public class MarsRover {
    public static final int LEFT_ROTATION = -1;
    public static final int RIGHT_ROTATION = +1;
    private Position position;

    public MarsRover() {
        position = new Position(0, 0, 'N');
    }

    public String execute(String commands) {
        for (int i = 0; i < commands.length(); i++) {
            char command = commands.charAt(i);
            if (command == 'M') {
                moveForward();
            }
            if ('R' == command) {
                rotateRight();
            }

            if ('L' == command) {
                rotateLeft();
            }
        }


        return position.toString();
    }

    private void moveForward() {
        switch (position.getOrientation()) {
            case 'N':
                position.moveY(+1);
                break;
            case 'S':
                position.setPositionY((position.getPositionY() - 1 + 10) % 10);
                break;
            case 'E':
                position.setPositionX((position.getPositionX() + 1 + 10) % 10);
                break;
            case 'W':
                position.setPositionX((position.getPositionX() - 1 + 10) % 10);
                break;
        }
    }

    private void rotateLeft() {
        position.rotate(LEFT_ROTATION);
    }

    private void rotateRight() {
        position.rotate(RIGHT_ROTATION);
    }

}

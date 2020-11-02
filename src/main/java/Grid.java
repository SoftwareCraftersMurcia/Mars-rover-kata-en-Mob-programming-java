public class Grid {
    private int width;
    private int height;

    public Grid(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public Position advanceOne(Position position, Orientation orientation) {
        if (orientation == Orientation.NORTH) {
            return new Position(position.getX(), (position.getY() + 1) % height);
        }
        else if (orientation == Orientation.SOUTH) {
            return new Position(position.getX(), Math.abs((position.getY() + (height - 1)) % height));
        }
        else if (orientation == Orientation.EAST) {
            return new Position((position.getX() + 1) % width, position.getY());
        }
        else if (orientation == Orientation.WEST) {
            return new Position(Math.abs((position.getX() + (width - 1)) % width), position.getY());
        }

        return position;
    }
}

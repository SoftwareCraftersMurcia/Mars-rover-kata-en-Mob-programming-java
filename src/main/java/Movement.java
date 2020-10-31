public class Movement {
    private final int horizontalMovement;
    private final int verticalMovement;

    public Movement(int verticalMovement, int horizontalMovement) {
        this.horizontalMovement = horizontalMovement;
        this.verticalMovement = verticalMovement;
    }

    public int getHorizontalMovement() {
        return horizontalMovement;
    }

    public int getVerticalMovement() {
        return verticalMovement;
    }
}

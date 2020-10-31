public enum Orientation {
    East("E"), South ("S"), West ("W"), North ("N");

    private final String representation;

    Orientation(String representation) {
        this.representation = representation;
    }

    @Override
    public String toString() {
        return representation;
    }
}

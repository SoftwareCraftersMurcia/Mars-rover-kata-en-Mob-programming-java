public class RotateLeft extends MarsCommand{
    public RotateLeft(Position position) {
        super(position);
    }

    @Override
    void execute() {
        position.rotate(-1);
    }
}

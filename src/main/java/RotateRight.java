public class RotateRight extends MarsCommand{
    public RotateRight(Position position) {
        super(position);
    }

    @Override
    void execute() {
        position.rotate(+1);
    }
}

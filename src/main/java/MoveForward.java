public class MoveForward extends MarsCommand {
    public MoveForward(Position position) {
        super(position);
    }

    @Override
    void execute() {
        position.moveForward();

    }
}

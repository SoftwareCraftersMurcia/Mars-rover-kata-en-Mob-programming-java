abstract class MarsCommand {
    protected final Position position;

    public MarsCommand(Position position) {
        this.position = position;
    }

    abstract void execute();
}

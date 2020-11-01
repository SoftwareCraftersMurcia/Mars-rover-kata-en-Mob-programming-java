package mars.command.rotation;

import mars.RoverSituation;
import mars.command.MarsCommand;
import mars.orientation.Orientation;

public abstract class RotationCommand implements MarsCommand {
    public RoverSituation execute(RoverSituation roverSituation) {
        return roverSituation.rotate(this);
    }

    abstract public Orientation rotate(Orientation orientation);
}

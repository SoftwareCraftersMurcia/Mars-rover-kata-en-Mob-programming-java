package mars.command;

import mars.RoverSituation;

public interface MarsCommand {
    RoverSituation execute(RoverSituation roverSituation);
}

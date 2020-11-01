package mars;

import mars.command.MarsCommand;
import mars.command.move.MoveForward;
import mars.command.rotation.RotateLeft;
import mars.command.rotation.RotateRight;
import mars.orientation.North;

import java.util.Map;

public class MarsRover {
    private final MarsMap marsMap;
    private RoverSituation roverSituation;
    private final Map<Character, MarsCommand> commands;

    public MarsRover() {
        marsMap = new MarsMap();
        roverSituation = new RoverSituation(new Position(0, 0), new North());
        commands = Map.of(
                'M', new MoveForward(),
                'R', new RotateRight(),
                'L', new RotateLeft()
        );
    }

    public String execute(String commands) {
        for (int i = 0; i < commands.length(); i++) {
            MarsCommand command = this.commands.get(commands.charAt(i));
            RoverSituation nextRoverSituation = command.execute(roverSituation);
            roverSituation = marsMap.move(roverSituation, nextRoverSituation);
        }

        return roverSituation.toString();
    }

}

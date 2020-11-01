import mars.MarsRover;
import mars.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MarsRoverWithObstaclesTest {

    @Test
    public void does_not_move_when_an_obstacle_is_in_front_of(){
        MarsRover rover = new MarsRover(List.of(new Position(0,1)));

        String result = rover.execute("M");

        Assertions.assertEquals("O:0:0:N", result);
    }

    @Test
    public void acceptance_test(){
        MarsRover rover = new MarsRover(List.of(new Position(0,3)));

        String result = rover.execute("MMMM");

        Assertions.assertEquals("O:0:2:N", result);
    }
}

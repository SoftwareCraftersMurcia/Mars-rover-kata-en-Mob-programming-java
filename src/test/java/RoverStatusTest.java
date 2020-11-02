import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoverStatusTest {

    @Test
    public void should_rotate_to_north_from_east_turning_left() {
        RoverStatus status = new RoverStatus(Orientation.EAST, 0, 0);

        RoverStatus nextStatus = status.rotateLeft();

        assertEquals("0:0:N", nextStatus.toString());
    }

    @Test
    public void should_rotate_to_north_from_west_turning_right() {
        RoverStatus status = new RoverStatus(Orientation.WEST, 0, 0);

        RoverStatus nextStatus = status.rotateRight();

        assertEquals("0:0:N", nextStatus.toString());
    }

    @Test
    public void should_rotate_to_south_from_east_turning_right() {
        RoverStatus status = new RoverStatus(Orientation.EAST, 0, 0);

        RoverStatus nextStatus = status.rotateRight();

        assertEquals("0:0:S", nextStatus.toString());
    }

    @Test
    public void should_rotate_to_south_from_west_turning_left() {
        RoverStatus status = new RoverStatus(Orientation.WEST, 0, 0);

        RoverStatus nextStatus = status.rotateLeft();

        assertEquals("0:0:S", nextStatus.toString());
    }

    @Test
    public void should_rotate_to_east_from_north_turning_right() {
        RoverStatus status = new RoverStatus(Orientation.NORTH, 0, 0);

        RoverStatus nextStatus = status.rotateRight();

        assertEquals("0:0:E", nextStatus.toString());
    }

    @Test
    public void should_rotate_to_east_from_south_turning_left() {
        RoverStatus status = new RoverStatus(Orientation.SOUTH, 0, 0);

        RoverStatus nextStatus = status.rotateLeft();

        assertEquals("0:0:E", nextStatus.toString());
    }

    @Test
    public void should_rotate_to_west_from_north_turning_left() {
        RoverStatus status = new RoverStatus(Orientation.NORTH, 0, 0);

        RoverStatus nextStatus = status.rotateLeft();

        assertEquals("0:0:W", nextStatus.toString());
    }

    @Test
    public void should_rotate_to_west_from_south_turning_right() {
        RoverStatus status = new RoverStatus(Orientation.SOUTH, 0, 0);

        RoverStatus nextStatus = status.rotateRight();

        assertEquals("0:0:W", nextStatus.toString());
    }
}

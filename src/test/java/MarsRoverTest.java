import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MarsRoverTest {

    private MarsRover rover;

    @BeforeEach
    void setUp() {
        rover = new MarsRover();
    }

    @Test
    public void going_one_step_to_north_should_move_to_0_1_N() {
        String result = rover.execute("M");

        assertEquals("0:1:N", result);
    }

    @Test
    public void going_two_steps_to_north_should_move_to_0_2_N() {
        String result = rover.execute("MM");

        assertEquals("0:2:N", result);
    }

    @Test
    public void from_north_going_right_should_face_east() {
        String result = rover.execute("R");

        assertEquals("0:0:E", result);
    }

    @Test
    public void from_north_going_right_twice_should_face_south() {
        String result = rover.execute("RR");

        assertEquals("0:0:S", result);
    }

    @Test
    public void from_north_going_right_three_times_should_face_west() {
        String result = rover.execute("RRR");

        assertEquals("0:0:W", result);
    }

    @Test
    public void from_north_going_right_four_times_should_face_north() {
        String result = rover.execute("RRRR");

        assertEquals("0:0:N", result);
    }

    @Test
    public void from_north_going_left_should_face_west() {
        String result = rover.execute("L");

        assertEquals("0:0:W", result);
    }

    @Test
    public void from_north_going_left_twice_should_face_south() {
        String result = rover.execute("LL");

        assertEquals("0:0:S", result);
    }

    @Test
    public void from_north_going_left_three_times_should_face_east() {
        String result = rover.execute("LLL");

        assertEquals("0:0:E", result);
    }

    @Test
    public void from_north_going_left_four_times_should_face_north() {
        String result = rover.execute("LLLL");

        assertEquals("0:0:N", result);
    }

/*
	@Test
	public void going_two_times_left_should_face_south() {
		MarsRover rover = new MarsRover();

		String result = rover.execute("LL");

		assertEquals("0:0:S", result);
	}
	*/
}

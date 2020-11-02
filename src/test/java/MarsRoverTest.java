import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MarsRoverTest {

	@Test
	public void should_move_to_0_1_N_when_command_is_M() {
		MarsRover rover = new MarsRover();

		String result = rover.execute("M");

		assertEquals("0:1:N", result);
	}

	@Test
	public void should_move_to_0_2_N_when_command_is_MM() {
		MarsRover rover = new MarsRover();

		String result = rover.execute("MM");

		assertEquals("0:2:N", result);
	}

	@Test
	public void should_face_north_staring_from_west_and_command_is_R() {
		MarsRover rover = new MarsRover("W");

		String result = rover.execute("R");

		assertEquals("0:0:N", result);
	}
	@Test
	public void should_face_north_starting_from_west_and_command_is_L() {
		MarsRover rover = new MarsRover("W");

		String result = rover.execute("L");

		assertEquals("0:0:S", result);
	}

	@Test
	public void should_face_north_when_command_is_LLLL() {
		MarsRover rover = new MarsRover("N");

		String result = rover.execute("LLLL");

		assertEquals("0:0:N", result);
	}

	@Test
	public void should_face_east_when_command_is_LLLLR() {
		MarsRover rover = new MarsRover("N");

		String result = rover.execute("LLLLR");

		assertEquals("0:0:E", result);
	}
}

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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
	public void should_face_north_when_command_is_LLLL() {
		MarsRover rover = new MarsRover();

		String result = rover.execute("LLLL");

		assertEquals("0:0:N", result);
	}

	@Test
	public void should_face_east_when_command_is_LLLLR() {
		MarsRover rover = new MarsRover();

		String result = rover.execute("LLLLR");

		assertEquals("0:0:E", result);
	}

	@ParameterizedTest
	@ValueSource(strings = {"", "LLLL", "RRRR", "LLLLRRRR", "LLLLLLLL"})
	public void should_face_north(String commands) {
		MarsRover rover = new MarsRover();

		String result = rover.execute(commands);

		assertEquals("0:0:N", result);
	}

	@ParameterizedTest
	@ValueSource(strings = {"LL", "RR", "LLRRRR", "RRRRRR"})
	public void should_face_south(String commands) {
		MarsRover rover = new MarsRover();

		String result = rover.execute(commands);

		assertEquals("0:0:S", result);
	}

	@ParameterizedTest
	@ValueSource(strings = {"R", "RRRRR", "LLL"})
	public void should_face_east(String commands) {
		MarsRover rover = new MarsRover();

		String result = rover.execute(commands);

		assertEquals("0:0:E", result);
	}

	@ParameterizedTest
	@ValueSource(strings = {"L", "LLLLL", "RRR"})
	public void should_face_west(String commands) {
		MarsRover rover = new MarsRover();

		String result = rover.execute(commands);

		assertEquals("0:0:W", result);
	}
}

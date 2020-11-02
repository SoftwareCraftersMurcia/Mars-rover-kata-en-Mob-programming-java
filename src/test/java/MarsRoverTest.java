import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MarsRoverTest {

	final Grid bigEmptyGrid = new Grid(100, 100);

	@Test
	public void should_move_to_0_1_N_when_command_is_M() {
		MarsRover rover = new MarsRover(bigEmptyGrid);

		String result = rover.execute("M");

		assertEquals("0:1:N", result);
	}

	@Test
	public void should_move_to_0_2_N_when_command_is_MM() {
		MarsRover rover = new MarsRover(bigEmptyGrid);

		String result = rover.execute("MM");

		assertEquals("0:2:N", result);
	}

	@Test
	public void should_face_north_when_command_is_LLLL() {
		MarsRover rover = new MarsRover(bigEmptyGrid);

		String result = rover.execute("LLLL");

		assertEquals("0:0:N", result);
	}

	@Test
	public void should_face_east_when_command_is_LLLLR() {
		MarsRover rover = new MarsRover(bigEmptyGrid);

		String result = rover.execute("LLLLR");

		assertEquals("0:0:E", result);
	}

	@ParameterizedTest
	@ValueSource(strings = {"", "LLLL", "RRRR", "LLLLRRRR", "LLLLLLLL"})
	public void should_face_north(String commands) {
		MarsRover rover = new MarsRover(bigEmptyGrid);

		String result = rover.execute(commands);

		assertEquals("0:0:N", result);
	}

	@ParameterizedTest
	@ValueSource(strings = {"LL", "RR", "LLRRRR", "RRRRRR"})
	public void should_face_south(String commands) {
		MarsRover rover = new MarsRover(bigEmptyGrid);

		String result = rover.execute(commands);

		assertEquals("0:0:S", result);
	}

	@ParameterizedTest
	@ValueSource(strings = {"R", "RRRRR", "LLL"})
	public void should_face_east(String commands) {
		MarsRover rover = new MarsRover(bigEmptyGrid);

		String result = rover.execute(commands);

		assertEquals("0:0:E", result);
	}

	@ParameterizedTest
	@ValueSource(strings = {"L", "LLLLL", "RRR"})
	public void should_face_west(String commands) {
		MarsRover rover = new MarsRover(bigEmptyGrid);

		String result = rover.execute(commands);

		assertEquals("0:0:W", result);
	}

	@Test
	public void should_keep_in_same_position_with_1x1_grid() {
		MarsRover rover = new MarsRover(new Grid(1, 1));

		String result = rover.execute("MMM");

		assertEquals("0:0:N", result);
	}

	@Test
	public void should_reach_top_advancing_one_with_2x2_grid() {
		MarsRover rover = new MarsRover(new Grid(2, 2));

		String result = rover.execute("M");

		assertEquals("0:1:N", result);
	}

	@Test
	public void should_trow_exception_if_grid_is_null() {
		assertThrows(NullPointerException.class,  () -> new MarsRover(null));
	}

	@Test
	public void should_reach_top_right_corner_moving_MRM_with_2x2_grid() {
		MarsRover rover = new MarsRover(new Grid(2, 2));

		String result = rover.execute("MRM");

		assertEquals("1:1:E", result);
	}

	@Test
	public void should_return_to_initial_position_moving_MRRM_with_2x2_grid() {
		MarsRover rover = new MarsRover(new Grid(2, 2));

		String result = rover.execute("MRRM");

		assertEquals("0:0:S", result);
	}
}

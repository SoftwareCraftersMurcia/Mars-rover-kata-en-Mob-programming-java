import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

	@Test
	public void should_travel_around_grid_clockwise_returning_to_same_position_moving_MRMRMRM_with_2x2_grid() {
		MarsRover rover = new MarsRover(new Grid(2, 2));

		String result = rover.execute("MRMRMRM");

		assertEquals("0:0:W", result);
	}

	@Test
	public void should_travel_around_grid_counterclockwise_returning_to_same_position_moving_LMLMLMLM_with_2x2_grid() {
		MarsRover rover = new MarsRover(new Grid(2, 2));

		String result = rover.execute("RMLMLMLM");

		assertEquals("0:0:S", result);
	}

	@Test
	public void should_go_bottom_right_corner_crossing_grid_horizontally_west_direction() {
		MarsRover rover = new MarsRover(new Grid(2, 2));

		String result = rover.execute("LMMM");

		assertEquals("1:0:W", result);
	}

	@Test
	public void should_go_top_left_corner_crossing_grid_vertically_south_direction() {
		MarsRover rover = new MarsRover(new Grid(2, 2));

		String result = rover.execute("LLM");

		assertEquals("0:1:S", result);
	}

	@ParameterizedTest
	@ValueSource(strings = {"MMRMML", "RMMLMM", "MRMLMRML", "MMMMRMMRMMLL", "RMMMLMMLMR", "MMLMMMR", "RMMRMMMRR"})
	public void should_finish_at_the_grid_center_given_a_5x5_grid(String commands) {
		MarsRover rover = new MarsRover(new Grid(5, 5));

		String result = rover.execute(commands);

		assertEquals("2:2:N", result);
	}

	@Test
	public void should_stop_when_finding_an_obstacle_in_0_3() {
		List<Position> obstacles = new ArrayList<Position>(Arrays.asList(new Position(0, 3)));
		MarsRover rover = new MarsRover(new Grid(4, 4, obstacles));

		String result = rover.execute("MMM");

		assertEquals("O:0:2:N", result);
	}

	@Test
	public void should_stop_when_finding_an_obstacle_with_more_obstacles() {
		List<Position> obstacles = new ArrayList<Position>(Arrays.asList(new Position(0, 3), new Position(3, 0)));
		MarsRover rover = new MarsRover(new Grid(5, 5, obstacles));

		String result = rover.execute("RMMM");

		assertEquals("O:2:0:E", result);
	}

	@Test
	public void should_stop_when_finding_an_obstacle_and_skip_any_movement_or_rotation() {
		List<Position> obstacles = new ArrayList<Position>(Arrays.asList(new Position(0, 3), new Position(3, 0)));
		MarsRover rover = new MarsRover(new Grid(5, 5, obstacles));

		String result = rover.execute("RMMMRMMMR");

		assertEquals("O:2:0:E", result);
	}
}

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MarsRoverTest {

	@Test
	public void from_1_1_going_one_step_north_should_move_to_1_2() {
		MarsRover rover = new MarsRover();

		String result = rover.execute("M");

		assertEquals("1:2:N", result);
	}

	@Test
	public void from_1_1_going_one_step_east_should_move_to_2_1() {
		MarsRover rover = new MarsRover("E");

		String result = rover.execute("M");

		assertEquals("2:1:E", result);
	}

	@Test
	public void from_1_1_going_one_step_south_should_move_to_1_0() {
		MarsRover rover = new MarsRover("S");

		String result = rover.execute("M");

		assertEquals("1:0:S", result);
	}

	@Test
	public void from_1_1_going_one_step_west_should_move_to_0_1() {
		MarsRover rover = new MarsRover("W");

		String result = rover.execute("M");

		assertEquals("0:1:W", result);
	}


}

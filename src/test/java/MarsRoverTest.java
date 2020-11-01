import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MarsRoverTest {

	@Test
	public void going_one_step_to_north_should_move_to_0_1_N() {
		MarsRover rover = new MarsRover();

		String result = rover.execute("M");

		assertEquals("0:1:N", result);
	}

	@Test
	public void going_one_step_to_east_should_move_to_1_0_N() {
		MarsRover rover = new MarsRover("E");

		String result = rover.execute("M");

		assertEquals("1:0:E", result);
	}

	@Test
	public void going_one_step_to_south_should_move_to_0_minus_1_N() {
		MarsRover rover = new MarsRover("S");

		String result = rover.execute("M");

		assertEquals("0:-1:S", result);
	}

	@Test
	public void going_one_step_to_west_should_move_to_minus_1_0_N() {
		MarsRover rover = new MarsRover("S");

		String result = rover.execute("M");

		assertEquals("0:-1:S", result);
	}


}

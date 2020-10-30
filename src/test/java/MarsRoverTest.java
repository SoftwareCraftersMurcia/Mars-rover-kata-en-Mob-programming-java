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
	public void going_two_steps_to_north_should_move_to_0_2_N() {
		MarsRover rover = new MarsRover();

		String result = rover.execute("MM");

		assertEquals("0:2:N", result);
	}

}

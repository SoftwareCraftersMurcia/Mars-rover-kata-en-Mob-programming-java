import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


class MarsRoverTest {

	Grid grid = mock(Grid.class);

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

	@Test
	public void facing_north_turn_left_should_face_west() {
		MarsRover rover = new MarsRover("N");

		String result = rover.execute("L");

		assertEquals("1:1:W", result);
	}

	@Test
	public void facing_north_turn_right_should_face_east() {
		MarsRover rover = new MarsRover("N");

		String result = rover.execute("R");

		assertEquals("1:1:E", result);
	}

	@Test
	public void facing_east_turn_left_should_face_north() {
		MarsRover rover = new MarsRover("E");

		String result = rover.execute("L");

		assertEquals("1:1:N", result);
	}

	@Test
	public void facing_east_turn_right_should_face_south() {
		MarsRover rover = new MarsRover("E");

		String result = rover.execute("R");

		assertEquals("1:1:S", result);
	}


	@Test
	public void facing_south_turn_left_should_face_east() {
		MarsRover rover = new MarsRover("S");

		String result = rover.execute("L");

		assertEquals("1:1:E", result);
	}

	@Test
	public void facing_south_turn_right_should_face_west() {
		MarsRover rover = new MarsRover("S");

		String result = rover.execute("R");

		assertEquals("1:1:W", result);
	}


	@Test
	public void facing_west_turn_left_should_face_south() {
		MarsRover rover = new MarsRover("W");

		String result = rover.execute("L");

		assertEquals("1:1:S", result);
	}

	@Test
	public void facing_west_turn_right_should_face_north() {
		MarsRover rover = new MarsRover("W");

		String result = rover.execute("R");

		assertEquals("1:1:N", result);
	}

	@Test
	public void from_2_2_going_one_step_to_north_should_move_to_2_3_N() {
		MarsRover rover = new MarsRover("N",2,2);

		String result = rover.execute("M");

		assertEquals("2:3:N", result);
	}

	@Test
	public void from_2_2_facing_north_turn_left_should_face_west() {
		MarsRover rover = new MarsRover("N",2,2);

		String result = rover.execute("L");

		assertEquals("2:2:W", result);
	}

	@Test
	public void from_1_1_facing_north_M_M_takes_you_to_1_3() {
		MarsRover rover = new MarsRover("N",1,1);

		String result = rover.execute("MM");

		assertEquals("1:3:N", result);
	}

	@Test
	public void from_1_1_facing_north_M_L_takes_you_to_1_2_facing_west() {
		MarsRover rover = new MarsRover("N",1,1);

		String result = rover.execute("ML");

		assertEquals("1:2:W", result);
	}

	@Test
	public void from_0_9_facing_north_M_takes_you_to_0_0() {

		MarsRover rover = new MarsRover("N",0,9,grid);

		rover.execute("M");

		verify(grid).wrapAcrossBoundsPosition(new Position(0,10));

	}

}

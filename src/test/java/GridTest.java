import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GridTest {

	@Test
	public void position_0_10_is_actually_0_0() {
		Grid grid = new Grid(10);

		Position position = grid.wrapAcrossBoundsPosition(new Position(0,10));

		assertEquals(0, position.x);
		assertEquals(0, position.y);

	}

	@Test
	public void position_10_0_is_actually_0_0() {
		Grid grid = new Grid(10);

		Position position = grid.wrapAcrossBoundsPosition(new Position(10,0));

		assertEquals(0, position.x);
		assertEquals(0, position.y);
	}

	@Test
	public void position_0_minus_1_is_actually_0_9() {
		Grid grid = new Grid(10);

		Position position = grid.wrapAcrossBoundsPosition(new Position(0,-1));

		assertEquals(0, position.x);
		assertEquals(9, position.y);
	}

	@Test
	public void position_minus_1_0_is_actually_9_0() {
		Grid grid = new Grid(10);

		Position position = grid.wrapAcrossBoundsPosition(new Position(-1,0));

		assertEquals(9, position.x);
		assertEquals(0, position.y);
	}

	@Test
	public void correclty_checks_that_there_is_no_obstacle_at_0_0() {
		Grid grid = new Grid(10);

		Position position = grid.wrapAcrossBoundsPosition(new Position(0,0));

		boolean isThereObstacle = grid.checkForObstacleAtPosition(position);

		assertEquals(false, isThereObstacle);

	}


}

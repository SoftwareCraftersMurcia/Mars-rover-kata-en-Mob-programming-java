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


}

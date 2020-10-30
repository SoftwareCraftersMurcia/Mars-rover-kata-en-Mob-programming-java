import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MarsRoverTest {

	@Test
	public void give_me_a_good_name_please() {
		MarsRover rover = new MarsRover();

		String result = rover.execute("M");

		assertEquals(true, result);
		assertThat(result, equalTo(true));
	}
}

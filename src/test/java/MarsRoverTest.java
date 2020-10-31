import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MarsRoverTest {

    private MarsRover rover;

    @BeforeEach
    void setUp() {
        rover = new MarsRover();
    }

    @ParameterizedTest
    @CsvSource({"M,0:1:N", "MM,0:2:N"})
    public void moves_forward_any_amount_of_times(String input, String expected) {
        String result = rover.execute(input);

        assertEquals(expected, result);
    }

    @ParameterizedTest
    @CsvSource({"R,0:0:E", "RR,0:0:S", "RRR,0:0:W", "RRRR,0:0:N"})
    public void rotates_right_any_number_of_times(String command, String expectedPosition) {
        String result = rover.execute(command);

        assertEquals(expectedPosition, result);
    }

    @Test
    public void from_north_going_left_should_face_west() {
        String result = rover.execute("L");

        assertEquals("0:0:W", result);
    }

    @Test
    public void from_north_going_left_twice_should_face_south() {
        String result = rover.execute("LL");

        assertEquals("0:0:S", result);
    }

    @Test
    public void from_north_going_left_three_times_should_face_east() {
        String result = rover.execute("LLL");

        assertEquals("0:0:E", result);
    }

    @Test
    public void from_north_going_left_four_times_should_face_north() {
        String result = rover.execute("LLLL");

        assertEquals("0:0:N", result);
    }

/*
	@Test
	public void going_two_times_left_should_face_south() {
		MarsRover rover = new MarsRover();

		String result = rover.execute("LL");

		assertEquals("0:0:S", result);
	}
	*/
}

import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
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
    public void moves_north_any_number_of_times(String command, String expectedPosition) {
        String result = rover.execute(command);

        assertEquals(expectedPosition, result);
    }

    @ParameterizedTest
    @CsvSource({"RM,1:0:E", "RMM,2:0:E"})
    public void moves_east_any_number_of_times(String command, String expectedPosition) {
        String result = rover.execute(command);

        assertEquals(expectedPosition, result);
    }

    @ParameterizedTest
    @CsvSource({"LM,9:0:W", "LMM,8:0:W"})
    public void moves_west_any_number_of_times(String command, String expectedPosition) {
        String result = rover.execute(command);

        assertEquals(expectedPosition, result);
    }

    @ParameterizedTest
    @CsvSource({"MMMMMMMMMM,0:0:N", "RMMMMMMMMMM,0:0:E", "LMMMMMMMMMM,0:0:W"})
    public void the_world_is_circular(String command, String expectedPosition) {
        String result = rover.execute(command);

        assertEquals(expectedPosition, result);
    }

    @ParameterizedTest
    @CsvSource({"R,0:0:E", "RR,0:0:S", "RRR,0:0:W", "RRRR,0:0:N"})
    public void rotates_right_any_number_of_times(String command, String expectedPosition) {
        String result = rover.execute(command);

        assertEquals(expectedPosition, result);
    }

    @ParameterizedTest
    @CsvSource({"L,0:0:W", "LL,0:0:S", "LLL,0:0:E", "LLLL,0:0:N"})
    public void rotates_left_any_number_of_times(String command, String expectedPosition) {
        String result = rover.execute(command);

        assertEquals(expectedPosition, result);
    }
}

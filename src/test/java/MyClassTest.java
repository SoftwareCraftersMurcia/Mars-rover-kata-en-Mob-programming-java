import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MyClassTest {

	@Test
	public void give_me_a_good_name_please() {
		MyClass myClass = new MyClass();

		boolean result = myClass.theMethod();

		assertEquals(true, result);
		assertThat(result, equalTo(true));
	}
}

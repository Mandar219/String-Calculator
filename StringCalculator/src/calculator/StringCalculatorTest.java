package calculator;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringCalculatorTest {

	@Test
	public void shouldReturnZeroOnEmptyString() {
		StringCalculator sc = new StringCalculator();
		assertEquals(0, sc.Add(""));
	}

}

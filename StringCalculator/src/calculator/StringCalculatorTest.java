package calculator;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringCalculatorTest {

	StringCalculator sc = new StringCalculator();
	
	@Test
	public void shouldReturnZeroOnEmptyString() {
		assertEquals(0, sc.Add(""));
	}
	
	@Test
	public void shouldReturnNumberOnSingleNumberInput() {
		assertEquals(1, sc.Add("1"));
	}

}

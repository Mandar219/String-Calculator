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
	
	@Test
	public void shouldReturnSumOnTwoNumbersInput() {
		assertEquals(3, sc.Add("1,2"));
	}
	
	@Test
	public void shouldReturnSumOnMoreThanTwoNumbersInput() {
		assertEquals(6, sc.Add("1,2,3"));
	}
	
	@Test
	public void shouldAllowNewlineAsDelimiter() {
		assertEquals(6, sc.Add("1\n2,3"));
		assertEquals(3, sc.Add("1\n2"));
	}
}

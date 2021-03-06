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
	
	@Test
	public void shouldAllowCustomDelimiter() {
		assertEquals(3, sc.Add("//;\n1;2"));
	}
	
	@Test
	public void shouldAllowRegexSpecialCharacterAsCustomDelimiter() {
		assertEquals(3, sc.Add("//.\n1.2"));
	}
	
	@Test
	public void shouldNotAllowNegativeNumbers() {
		try {
			sc.Add("-1,2,3");
			fail("Exception Expected");
		} catch(RuntimeException e) {
			//pass
		}
	}
	
	@Test
	public void shouldProvideNegativeNumbersInExceptionMessage() {
		try {
			sc.Add("-1,2,-3");
			fail("Exception Expected");
		} catch(RuntimeException e) {
			assertEquals("Negatives are not allowed but got [-1, -3]", e.getMessage());
		}
	}
	
	@Test
	public void shouldIgnoreNumbersGreaterThanThousand() {
		assertEquals(2, sc.Add("1001,2"));
	}
	
	@Test
	public void shouldAllowDelimiterOfAnyLength() {
		assertEquals(3, sc.Add("//[***]\n1***2"));
	}
	
	@Test
	public void shouldAllowMultipleDelimiters() {
		assertEquals(6, sc.Add("//[*][%]\n1*2%3"));
	}
	
	@Test
	public void shouldAllowMultipleDelimitersOfVariedLength() {
		assertEquals(10, sc.Add("//[***][%%][&]\n1***2%%3&4"));
	}
}

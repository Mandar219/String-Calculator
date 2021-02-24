package calculator;

import java.util.*;
import java.util.regex.*;

public class StringCalculator {

	public int Add(String numbers) {
		if(numbers.isEmpty()) {
			return 0;
		} else {
			String[] numberArray = split(numbers);
			List<Integer> integers = getIntegerValues(numberArray);
			return sum(integers);
		}
	}

	private String[] split(String numbers) {
		if(numbers.startsWith("//")) {
			return splitUsingCustomDelimiter(numbers);
		}
		return numbers.split(",|\n");
	}

	private String[] splitUsingCustomDelimiter(String numbers) {
		Pattern p = Pattern.compile("//(.?)\n(.*)");
		Matcher m = p.matcher(numbers);
		m.matches();
		String customDelimiter = m.group(1);
		String value = m.group(2);
		return value.split(Pattern.quote(customDelimiter));
	}

	private int sum(List<Integer> integers) {
		return integers.stream().mapToInt(Integer::intValue).sum();
	}

	private List<Integer> getIntegerValues(String[] numberArray) {
		List<Integer> integers = new ArrayList<>();
		for(String number : numberArray) {
			integers.add(convertToInt(number));
		}
		return integers;
	}

	private int convertToInt(String number) {
		return Integer.parseInt(number);
	}
	
}

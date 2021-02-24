package calculator;

import java.util.*;
import java.util.regex.*;
import java.util.stream.Collectors;

public class StringCalculator {

	public int Add(String numbers) {
			String[] numberArray = split(numbers);
			List<Integer> integers = getIntegerValues(numberArray);
			checkForNegatives(integers);
			integers = filter(integers);
			return sum(integers);
	}

	private List<Integer> filter(List<Integer> integers) {
		return integers.stream().filter(s -> s <= 1000).collect(Collectors.toList());
	}

	private void checkForNegatives(List<Integer> integers) {
		List<Integer> negatives = integers.stream().filter(s -> s < 0).collect(Collectors.toList());
		if(negatives.size() > 0) {
			throw new RuntimeException("Negatives are not allowed but got " + negatives.toString());
		}
	}

	private String[] split(String numbers) {
		if(numbers.isEmpty()) {
			return new String[0];
		} else if(checkForDelimiterOfAnyLength(numbers)) {
			Pattern p = Pattern.compile("//\\[(.*?)\\]\n(.*)");
			return splitUsingCustomDelimiter(numbers, p);
		} else if(checkForCustomDelimiter(numbers)) {
			Pattern p = Pattern.compile("//(.*?)\n(.*)");
			return splitUsingCustomDelimiter(numbers, p);
		}
		return numbers.split(",|\n");
	}

	private boolean checkForCustomDelimiter(String numbers) {
		return numbers.startsWith("//");
	}

	private boolean checkForDelimiterOfAnyLength(String numbers) {
		return numbers.startsWith("//[");
	}

	private String[] splitUsingCustomDelimiter(String numbers, Pattern pattern) {
		Pattern p = pattern;
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

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
		} else if(checkForVariedOrMultipleDelimiters(numbers)) {
			Pattern p = Pattern.compile("\\[(.*?)\\]");
			return splitUsingMultipleDelimiters(numbers, p);
		} else if(checkForCustomDelimiter(numbers)) {
			Pattern p = Pattern.compile("//(.*?)\n(.*)");
			return splitUsingCustomDelimiter(numbers, p);
		}
		return numbers.split(",|\n");
	}

	private boolean checkForCustomDelimiter(String numbers) {
		return numbers.startsWith("//");
	}

	private boolean checkForVariedOrMultipleDelimiters(String numbers) {
		return numbers.startsWith("//[");
	}
	
	private String[] splitUsingMultipleDelimiters(String numbers, Pattern pattern) {
		Matcher m = pattern.matcher(numbers);
		m.matches();
		String replace = getReplacement(m);
		String value = getNumberstoCalculate(numbers);
		value = modify(replace, value);
		return value.split(",");
	}

	private String modify(String replace, String value) {
		value = value.replaceAll(replace, "");
		value = value.replaceAll("", ",");
		value = value.substring(1, value.length()-1);
		return value;
	}

	private String getNumberstoCalculate(String numbers) {
		int index = numbers.indexOf("\n");
		String value = numbers.substring(index + 1);
		return value;
	}

	private String getReplacement(Matcher m) {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		while(m.find()) {
			sb.append(m.group(1));
			sb.append(",");
		}
		sb.replace(sb.length()-1, sb.length(), "");
		sb.append("]");
		String replace = sb.toString();
		return replace;
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

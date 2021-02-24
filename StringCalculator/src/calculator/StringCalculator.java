package calculator;

import java.util.*;

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
		return numbers.split(",|\n");
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

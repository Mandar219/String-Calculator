package calculator;

import java.util.*;

public class StringCalculator {

	public int Add(String numbers) {
		if(numbers.isEmpty()) {
			return 0;
		} else if(numbers.contains(",")) {
			String[] numberArray = numbers.split(",");
			List<Integer> integers = getIntegerValues(numberArray);
			return integers.stream().mapToInt(Integer::intValue).sum();
		} else {
			return convertToInt(numbers);
		}
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

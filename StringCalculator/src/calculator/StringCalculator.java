package calculator;

public class StringCalculator {

	public int Add(String numbers) {
		if(numbers.isEmpty()) {
			return 0;
		} else if(numbers.contains(",")) {
			String[] integers = numbers.split(",");
			return Integer.parseInt(integers[0]) + Integer.parseInt(integers[1]);
		} else {
			return Integer.parseInt(numbers);
		}
	}
	
}

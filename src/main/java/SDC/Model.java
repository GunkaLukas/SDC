package SDC;

import java.util.ArrayList;

public class Model {
	
	ArrayList<Long> primeNumbers = new ArrayList<Long>();

	public Model(ArrayList<Long> input) {
		findPrimeNumbers(input);
	}
	
	/**
	 * Check if input is prime number
	 */
	private boolean checkIfPrime(long num) {
		for (long x = 2; x < (long) Math.sqrt(num); x++)
			if (num % x == 0)
				return false;
		return true;
	}

	/**
	 * Select prime numbers from "excelContent"list and inserts them to
	 * "primeNumbers" list
	 */
	private void findPrimeNumbers(ArrayList<Long> input) {
		for (long item : input) {
			if (checkIfPrime(item))
				primeNumbers.add(item);
		}
	}

	/**
	 * Write found prime numbers from "primeNumbers" list
	 */
	public void writeFoundPrimeNumbers() {
		for (Long item : primeNumbers) {
			System.out.println(item);
		}
	}

}


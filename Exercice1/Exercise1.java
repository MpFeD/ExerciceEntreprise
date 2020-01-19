package exercise1;

public class Exercise1 {

	private final static String UNDEFINED_MESSAGE_EXCEPTION = "The factorial function is not defined for a negative number";
	
	/**
	 * Iterative way
	 * @param number the natural number input 
	 * @return the factorial of number
	 */
	public static long iterativeFactorial(long number) throws NumberFormatException {
		//factorial function is not defined for a negative number, throw an excetion
		if (number < 0) {
			throw new NumberFormatException(UNDEFINED_MESSAGE_EXCEPTION);
		}
		
		//0 case, to not multiply by 0 in the loop return 1 because 0! = 1
		if (number == 0) {
			return 1;
		}
		
		//looping and multiply incremented index together creating the factorial result
		long result = 1;
		for (long i = 1; i <= number; i++) {
			result *= i;
		}
		return result;
	}
	
	/**
	 * Recursive way
	 * @param number the natural number input 
	 * @return the factorial of number
	 * @deprecated a stack overflow may occurs if the number is too big
	 */
	@Deprecated
	public static long recursiveFactorial(long number) throws NumberFormatException {
		//factorial function is not defined for a negative number, throw an excetion
		if (number < 0) {
			throw new NumberFormatException(UNDEFINED_MESSAGE_EXCEPTION);
		}
		
		//recursion base case 0! = 1 and 1! = 1
		if (number == 1 || number == 0) {
			return 1;
		}
		
		//creating the factorial by multiplying decreased number and number itself until the 1 case
		return number * recursiveFactorial(number - 1);
	}
}

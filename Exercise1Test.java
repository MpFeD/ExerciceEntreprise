package exercise1;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Exercise1Test {
	
	//TODO moves these constants in a constants exclusive file
	private final int FACTORIAL_THREE = 6;
	private final int THREE = 3;
	
	private final int FACTORIAL_SEVEN = 5040;
	private final int SEVEN = 7;
	
	private final int FACTORIAL_TEN = 3628800;
	private final int TEN = 10;
	
	private final int NEGATIVE_ONE = -1;
	private final String EXCEPTION_MESSAGE = "The factorial function is not defined for a negative number";

	@Test
	void testFactorial() {
		assertEquals(FACTORIAL_THREE, Exercise1.iterativeFactorial(THREE));
		assertEquals(FACTORIAL_THREE, Exercise1.recursiveFactorial(THREE));
		
		assertEquals(FACTORIAL_SEVEN, Exercise1.iterativeFactorial(SEVEN));
		assertEquals(FACTORIAL_SEVEN, Exercise1.recursiveFactorial(SEVEN));
		
		assertEquals(FACTORIAL_TEN, Exercise1.iterativeFactorial(TEN));
		assertEquals(FACTORIAL_TEN, Exercise1.recursiveFactorial(TEN));
	}
	
	@Test
	void testNegativeFactorial() {
		//Check if NumberFormatException is thrown with a negative input
		Exception exception = assertThrows(NumberFormatException.class, () -> {
			Exercise1.iterativeFactorial(NEGATIVE_ONE);
	    });
	 
	    //Check if exception message is well defined
	    assertTrue(exception.getMessage().equals(EXCEPTION_MESSAGE));
	}

}

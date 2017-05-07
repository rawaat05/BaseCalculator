/**
 * 
 * This class holds two values, value1 is the one before any symbol eg. +,
 * -,etc. value2 is the one after any symbol
 * 
 * @author Nomaan Khalid
 * @since 2017-04-12
 */
public class BaseCalculatorState {
	private String value1 = new String(); // value of current calculation
	private String value2 = new String();

	/**
	 * Sets value and value2 equal to empty string
	 */
	BaseCalculatorState() {
		value1 = "";
		value2 = "";
	}

	/**
	 * Invoked when the "Clear" button is pressed, clears all values
	 */
	void clear() {
		value1 = "";
		value2 = "";
	}

	/**
	 * 
	 * @return value - the first number in calculator
	 */
	String getValue1() {
		return value1;
	}

	/**
	 * 
	 * @return value - the second number in calculator
	 */
	String getValue2() {
		return value2;
	}

	/**
	 * Appends x to value
	 * 
	 * @param x
	 *            last inputed number
	 */
	public void addToValue1(String x) {
		value1 = value1 + x;
	}

	/**
	 * Appends x to value2
	 * 
	 * @param x
	 *            last inputed number
	 */
	public void addToValue2(String x) {
		value2 = value2 + x;
	}
}

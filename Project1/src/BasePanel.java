import java.lang.Math;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * This is class that contains all the buttons, does all the calculations, and
 * conversions to different number bases for the calculator
 * 
 * @author Nomaan Khalid
 * @since 2017-04-12
 */
public class BasePanel extends JPanel implements ChangeListener {
	private BaseCalculatorState calc;

	JButton zero, one, two, three, four, five, six, seven, eight, nine, A, B, C, D, E, F, plus, minus, multiply, divide,
			clear, equals;

	JTextArea screen;

	ActionListener action;

	String history;
	StringBuilder resultWithBase;

	private int result;
	private int resultChanger;
	private int base = 16;

	// Count for symbol inputs
	private int minusC = 0, multiplyC = 0, divideC = 0, plusC = 0;

	JSlider baseSlider;
	private final int MIN_BASE = 2;
	private final int MAX_BASE = 16;
	private final int INIT_BASE = 16;

	/**
	 * baseSlider - to change the number base of the calculator<p> 
	 * screen - where all the input and output is shown history<p>
	 * history - holds the last calculation<p> 
	 * resultWithBase - changes to new base as baseSlider's value
	 * changes<p>
	 * 
	 * Registers listeners, and adds all components to panel
	 */
	BasePanel() {
		calc = new BaseCalculatorState();

		history = new String();
		resultWithBase = new StringBuilder();

		screen = new JTextArea(5, 13);
		screen.setMargin(new Insets(5, 5, 5, 5));
		screen.setFont(screen.getFont().deriveFont(18f));

		baseSlider = new JSlider(JSlider.HORIZONTAL, MIN_BASE, MAX_BASE, INIT_BASE);
		baseSlider.addChangeListener((ChangeListener) this);
		baseSlider.setMajorTickSpacing(2);
		baseSlider.setPaintTicks(true);
		baseSlider.setPaintLabels(true);
		baseSlider.setBackground(Color.cyan);
		baseSlider.setToolTipText("Slide knob to change number base");

		this.setLayout(new FlowLayout());
		this.setBackground(Color.cyan);

		// Calculator buttons
		zero = new JButton("        0        ");
		one = new JButton("1");
		two = new JButton("2");
		three = new JButton("3");
		four = new JButton("4");
		five = new JButton("5");
		six = new JButton("6");
		seven = new JButton("7");
		eight = new JButton("8");
		nine = new JButton("9");
		A = new JButton("A");
		B = new JButton("B");
		C = new JButton("C");
		D = new JButton("D");
		E = new JButton("E");
		F = new JButton("F");
		plus = new JButton("+");
		minus = new JButton("-");
		multiply = new JButton("x");
		divide = new JButton(" /");
		clear = new JButton("C");
		equals = new JButton("        =        ");

		// Listener for all buttons
		action = new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// All numbers inputs are appended to value1 if all symbol count
				// is 0
				// Otherwise, all number inputs are appended to value2
				if (e.getSource() == zero) {
					if (plusC == 0 && minusC == 0 && multiplyC == 0 && divideC == 0)
						calc.addToValue1("0");
					else
						calc.addToValue2("0");

					screen.append("0");
				}

				if (e.getSource() == one) {
					if (plusC == 0 && minusC == 0 && multiplyC == 0 && divideC == 0)
						calc.addToValue1("1");
					else
						calc.addToValue2("1");

					screen.append("1");
				}

				if (e.getSource() == two) {
					if (plusC == 0 && minusC == 0 && multiplyC == 0 && divideC == 0)
						calc.addToValue1("2");
					else
						calc.addToValue2("2");

					screen.append("2");
				}

				if (e.getSource() == three) {
					if (plusC == 0 && minusC == 0 && multiplyC == 0 && divideC == 0)
						calc.addToValue1("3");
					else
						calc.addToValue2("3");

					screen.append("3");
				}

				if (e.getSource() == four) {
					if (plusC == 0 && minusC == 0 && multiplyC == 0 && divideC == 0)
						calc.addToValue1("4");
					else
						calc.addToValue2("4");

					screen.append("4");
				}

				if (e.getSource() == five) {
					if (plusC == 0 && minusC == 0 && multiplyC == 0 && divideC == 0)
						calc.addToValue1("5");
					else
						calc.addToValue2("5");

					screen.append("5");
				}

				if (e.getSource() == six) {
					if (plusC == 0 && minusC == 0 && multiplyC == 0 && divideC == 0)
						calc.addToValue1("6");
					else
						calc.addToValue2("6");

					screen.append("6");
				}

				if (e.getSource() == seven) {
					if (plusC == 0 && minusC == 0 && multiplyC == 0 && divideC == 0)
						calc.addToValue1("7");
					else
						calc.addToValue2("7");

					screen.append("7");
				}

				if (e.getSource() == eight) {
					if (plusC == 0 && minusC == 0 && multiplyC == 0 && divideC == 0)
						calc.addToValue1("8");
					else
						calc.addToValue2("8");

					screen.append("8");
				}

				if (e.getSource() == nine) {
					if (plusC == 0 && minusC == 0 && multiplyC == 0 && divideC == 0)
						calc.addToValue1("9");
					else
						calc.addToValue2("9");

					screen.append("9");
				}

				if (e.getSource() == A) {
					if (plusC == 0 && minusC == 0 && multiplyC == 0 && divideC == 0)
						calc.addToValue1("A");
					else
						calc.addToValue2("A");

					screen.append("A");
				}

				if (e.getSource() == B) {
					if (plusC == 0 && minusC == 0 && multiplyC == 0 && divideC == 0)
						calc.addToValue1("B");
					else
						calc.addToValue2("B");

					screen.append("B");
				}

				if (e.getSource() == C) {
					if (plusC == 0 && minusC == 0 && multiplyC == 0 && divideC == 0)
						calc.addToValue1("C");
					else
						calc.addToValue2("C");

					screen.append("C");
				}

				if (e.getSource() == D) {
					if (plusC == 0 && minusC == 0 && multiplyC == 0 && divideC == 0)
						calc.addToValue1("D");
					else
						calc.addToValue2("D");

					screen.append("D");
				}

				if (e.getSource() == E) {
					if (plusC == 0 && minusC == 0 && multiplyC == 0 && divideC == 0)
						calc.addToValue1("E");
					else
						calc.addToValue2("E");

					screen.append("E");
				}

				if (e.getSource() == F) {
					if (plusC == 0 && minusC == 0 && multiplyC == 0 && divideC == 0)
						calc.addToValue1("F");
					else
						calc.addToValue2("F");

					screen.append("F");
				}

				if (e.getSource() == plus) {
					if (plusC == 0) {
						plusC = 1;
						screen.append("+");
					}
				}

				// If there is no input, makes value1 a negative number
				// If value1 holds a number, and there is a symbol, makes value2
				// a negative number
				// Otherwise, adds a minus sign
				if (e.getSource() == minus) {
					if (calc.getValue1() == "") {
						calc.addToValue1("-");
						screen.append("-");
					} else if (calc.getValue1() != "" && calc.getValue2() == "" && plusC == 1 || multiplyC == 1
							|| divideC == 1 || minusC == 1) {
						calc.addToValue2("-");
						screen.append("-");
					} else if (minusC == 0) {
						minusC = 1;
						screen.append("-");
					}
				}

				if (e.getSource() == multiply) {
					if (multiplyC == 0) {
						multiplyC = 1;
						screen.append("X");
					}
				}

				if (e.getSource() == divide) {
					if (divideC == 0) {
						divideC = 1;
						screen.append("/");
					}
				}

				// Resets everything if C is pressed
				if (e.getSource() == clear) {
					calc.clear();
					plusC = 0;
					minusC = 0;
					multiplyC = 0;
					divideC = 0;
					result = 0;
					screen.setText("");
				}

				if (e.getSource() == equals) {
					calculateAndDisplay();
				}
			}
		};

		zero.addActionListener(action);
		one.addActionListener(action);
		two.addActionListener(action);
		three.addActionListener(action);
		four.addActionListener(action);
		five.addActionListener(action);
		six.addActionListener(action);
		seven.addActionListener(action);
		eight.addActionListener(action);
		nine.addActionListener(action);
		A.addActionListener(action);
		B.addActionListener(action);
		C.addActionListener(action);
		D.addActionListener(action);
		E.addActionListener(action);
		F.addActionListener(action);
		plus.addActionListener(action);
		minus.addActionListener(action);
		multiply.addActionListener(action);
		divide.addActionListener(action);
		clear.addActionListener(action);
		equals.addActionListener(action);

		add(baseSlider);
		add(screen);

		add(D);
		add(E);
		add(F);
		add(plus);

		add(A);
		add(B);
		add(C);
		add(minus);

		add(seven);
		add(eight);
		add(nine);
		add(multiply);

		add(four);
		add(five);
		add(six);
		add(divide);

		add(one);
		add(two);
		add(three);
		add(clear);

		add(zero);
		add(equals);

	}

	/**
	 * Always called by CalculateAndDisplay()<p> 
	 * Calls Integer.parseInt() to convert value1 and value2 
	 * from any base to decimal<p> 
	 * Checks symbol and calculates accordingly<p> 
	 * Converts back to original base
	 */
	private void baseConverter() {
		char c; // The alphabet representation for numbers in bases > 10

		int val1 = 0;
		int val2 = 0;
		
		try {
			if(calc.getValue1() != "")
				val1 = Integer.parseInt(calc.getValue1(), base);
			if(calc.getValue2() != "")
				val2 = Integer.parseInt(calc.getValue2(), base);
		} catch (NumberFormatException e) {
			// do nothing
		}

		if (plusC == 1) {
			history = calc.getValue1() + "+" + calc.getValue2() + "\n";
			result = val1 + val2;
		}

		if (minusC == 1) {
			history = calc.getValue1() + "-" + calc.getValue2() + "\n";
			result = val1 - val2;
		}

		if (multiplyC == 1) {
			history = calc.getValue1() + "X" + calc.getValue2() + "\n";
			result = val1 * val2;
		}

		if (divideC == 1) {
			history = calc.getValue1() + "/" + calc.getValue2() + "\n";
			result = val1 / val2;
		}

		resultChanger = result; // To convert back to base without modifying
								// result
		while (resultChanger != 0) {
			c = getNumberChar(Math.abs(resultChanger) % base);
			resultWithBase.insert(0, c);
			resultChanger = resultChanger / base;
		}
	}

	/**
	 * 
	 * @param i
	 *            a number at any position of result
	 * @return a character representation of the number i
	 */
	private char getNumberChar(int i) {
		switch (i) {
		case 10:
			return 'A';
		case 11:
			return 'B';
		case 12:
			return 'C';
		case 13:
			return 'D';
		case 14:
			return 'E';
		case 15:
			return 'F';
		default:
			return Character.forDigit(i, 10);
		}
	}

	/**
	 * Calls baseConverter()<p> 
	 * If result is an empty string, sets result equal to 0<p> 
	 * If result is negative, inserts a minus sign at position 0<p>
	 * 
	 * Shows input and result Resets calculator for new calculation
	 */
	private void calculateAndDisplay() {

		baseConverter();

		if (result < 0)
			resultWithBase.insert(0, "-");
		if (result == 0)
			resultWithBase.append("0");

		screen.setText(history + resultWithBase);
		screen.append("\n");

		// Reset calculator
		resultWithBase.delete(0, resultWithBase.length());
		calc.clear();
		plusC = 0;
		minusC = 0;
		multiplyC = 0;
		divideC = 0;
	}

	/**
	 * StateChanged() implementation for baseSlider<p> 
	 * Disables buttons unavailable for a selected base
	 */
	public void stateChanged(ChangeEvent e) {
		base = baseSlider.getValue();

		calculateAndDisplay(); // For updated base

		// Disable buttons according to selected base
		zero.setEnabled(true);
		one.setEnabled(true);
		two.setEnabled(true);
		three.setEnabled(true);
		four.setEnabled(true);
		five.setEnabled(true);
		six.setEnabled(true);
		seven.setEnabled(true);
		eight.setEnabled(true);
		nine.setEnabled(true);
		A.setEnabled(true);
		B.setEnabled(true);
		C.setEnabled(true);
		D.setEnabled(true);
		E.setEnabled(true);
		F.setEnabled(true);

		switch (baseSlider.getValue()) {
		case 15:
			F.setEnabled(false);
			break;
		case 14:
			F.setEnabled(false);
			E.setEnabled(false);
			break;
		case 13:
			F.setEnabled(false);
			E.setEnabled(false);
			D.setEnabled(false);
			break;
		case 12:
			F.setEnabled(false);
			E.setEnabled(false);
			D.setEnabled(false);
			C.setEnabled(false);
			break;
		case 11:
			F.setEnabled(false);
			E.setEnabled(false);
			D.setEnabled(false);
			C.setEnabled(false);
			B.setEnabled(false);
			break;
		case 10:
			F.setEnabled(false);
			E.setEnabled(false);
			D.setEnabled(false);
			C.setEnabled(false);
			B.setEnabled(false);
			A.setEnabled(false);
			break;
		case 9:
			F.setEnabled(false);
			E.setEnabled(false);
			D.setEnabled(false);
			C.setEnabled(false);
			B.setEnabled(false);
			A.setEnabled(false);
			nine.setEnabled(false);
			break;
		case 8:
			F.setEnabled(false);
			E.setEnabled(false);
			D.setEnabled(false);
			C.setEnabled(false);
			B.setEnabled(false);
			A.setEnabled(false);
			nine.setEnabled(false);
			eight.setEnabled(false);
			break;
		case 7:
			F.setEnabled(false);
			E.setEnabled(false);
			D.setEnabled(false);
			C.setEnabled(false);
			B.setEnabled(false);
			A.setEnabled(false);
			nine.setEnabled(false);
			eight.setEnabled(false);
			seven.setEnabled(false);
			break;
		case 6:
			F.setEnabled(false);
			E.setEnabled(false);
			D.setEnabled(false);
			C.setEnabled(false);
			B.setEnabled(false);
			A.setEnabled(false);
			nine.setEnabled(false);
			eight.setEnabled(false);
			seven.setEnabled(false);
			six.setEnabled(false);
			break;
		case 5:
			F.setEnabled(false);
			E.setEnabled(false);
			D.setEnabled(false);
			C.setEnabled(false);
			B.setEnabled(false);
			A.setEnabled(false);
			nine.setEnabled(false);
			eight.setEnabled(false);
			seven.setEnabled(false);
			six.setEnabled(false);
			five.setEnabled(false);
			break;
		case 4:
			F.setEnabled(false);
			E.setEnabled(false);
			D.setEnabled(false);
			C.setEnabled(false);
			B.setEnabled(false);
			A.setEnabled(false);
			nine.setEnabled(false);
			eight.setEnabled(false);
			seven.setEnabled(false);
			six.setEnabled(false);
			five.setEnabled(false);
			four.setEnabled(false);
			break;
		case 3:
			F.setEnabled(false);
			E.setEnabled(false);
			D.setEnabled(false);
			C.setEnabled(false);
			B.setEnabled(false);
			A.setEnabled(false);
			nine.setEnabled(false);
			eight.setEnabled(false);
			seven.setEnabled(false);
			six.setEnabled(false);
			five.setEnabled(false);
			four.setEnabled(false);
			three.setEnabled(false);
			break;
		case 2:
			F.setEnabled(false);
			E.setEnabled(false);
			D.setEnabled(false);
			C.setEnabled(false);
			B.setEnabled(false);
			A.setEnabled(false);
			nine.setEnabled(false);
			eight.setEnabled(false);
			seven.setEnabled(false);
			six.setEnabled(false);
			five.setEnabled(false);
			four.setEnabled(false);
			three.setEnabled(false);
			two.setEnabled(false);
			break;
		default:
			break;
		}

	}
}

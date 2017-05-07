import javax.swing.JFrame;

/**
 * This is the Calculator's driver class, calls createAndShowGUI()
 * 
 * @author Nomaan Khalid
 * @since 2017-04-12
 */
public class BaseCalculator {

	public static void main(String[] args) {
		createAndShowGUI();
	}

	/**
	 * Creates a new JFrame, with fixed dimensions and adds BasePanel to it
	 */
	private static void createAndShowGUI() {
		JFrame frame = new JFrame("Calculator");

		frame.add(new BasePanel());

		// Frame Properties
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(215, 415);
		frame.setResizable(false);
		frame.setVisible(true);

	}
}

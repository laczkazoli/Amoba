package Amoba;


import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * This class is used it when somebody win the game.
 * @author zoli
 *
 */

public class WinnerWindow extends JPanel {

	/**
	 * 
	 * The serialVersionUID is a universal version identifier for a Serializable class.
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * This method open a new window somebody win.
	 * @return an int which contains which button was pushed
	 */
	public static int getWinnerWindow() {
		String s = null;
		if (Window.szamlalo % 2 == 0) {
			s = "0";
		} else {
			s = "X";
		}
		JFrame f1 = new JFrame("Finish");
		Object[] options = { "New game", "Exit" };
		int n = JOptionPane.showOptionDialog(f1, "A(z) " + s + " nyert", "Winner",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
		return n;
	}

}
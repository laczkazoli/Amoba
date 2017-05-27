package Amoba;


import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class EqualWindow {
	
/**
 * This method open a new window if the last pass is equal.
 * @return which button you clicked it
 */
	public static int getEqualWindow() {
		JFrame f1 = new JFrame("Finish");
		Object[] options = { "New game", "Exit" };		
		return JOptionPane.showOptionDialog(f1, "Sajnos dontetlen", "Equal",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);

	}

}

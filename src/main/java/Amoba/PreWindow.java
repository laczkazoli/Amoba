package Amoba;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 * This window can read the size of the table.
 * @author zoli
 *
 */
public class PreWindow extends JPanel {

	/**
	 * The serialVersionUID is a universal version identifier for a Serializable class.
	 */
	private static final long serialVersionUID = 1L;
/**
 * This except contains the exceotion string.
 */
	static String except;

	/**
	 * This method open before a new game and you can set the size of table.
	 */

	void firstdisplay() {
		JFrame f = new JFrame("Palya merete");
		JMenuBar bar = new JMenuBar();
		JLabel jlabel = new JLabel();
		JLabel jlabel2 = new JLabel("Kerem a palya meretet:");
		JButton jbutton = new JButton("Enter");
		JMenu failmenu = new JMenu("File");
		JMenuItem exit = new JMenuItem("Exit");
		JTextField jtext = new JTextField(30);

		failmenu.add(exit);
		bar.add(failmenu);

		f.setJMenuBar(bar);
		exit.addActionListener((ActionEvent event) -> {
			System.exit(0);
		});

		f.add(jtext);
		f.add(jbutton);
		add(jlabel2);
		add(jtext);
		add(jlabel);
		add(jbutton);

		jtext.addActionListener(new ActionListener() {
			/**
			 * This method contains the passes after an enter
			 */
			public void actionPerformed(ActionEvent e) {
				try {
					int numb1 = Integer.valueOf(jtext.getText().toString());
					if (numb1 < 5 && numb1 > 0) {
						Main.logger.warning("the table minimum size is 5");
						f.setVisible(false);
						new ExceptionWindow().firstdisplay();
					} else {
						Main.logger.finest("numb erteke elso: " + numb1);
						jlabel.setText(String.valueOf(numb1));
						f.setVisible(false);
						new Window(numb1);
					}
				} catch (NumberFormatException nfe) {
					Main.logger.warning(nfe.getMessage());
					f.setVisible(false);
					except = "hiba -> NFE";
					new ExceptionWindow().firstdisplay();

				} catch (IllegalArgumentException iae) {
					Main.logger.warning(iae.getMessage());
					except = "hiba -> IAE";;
					new ExceptionWindow().firstdisplay();
				}
			}
		});

		jbutton.addActionListener(new ActionListener() {
			/**
			 * This method contains the passes after a click
			 */
			public void actionPerformed(ActionEvent e) {
				try {
					int numb1 = Integer.valueOf(jtext.getText().toString());
					if (numb1 < 5 && numb1 > 0) {
						Main.logger.warning("the table minimum size is 5");
						f.setVisible(false);
						new ExceptionWindow().firstdisplay();
					} else {
						System.out.println("numb erteke elso: " + numb1);
						jlabel.setText(String.valueOf(numb1));
						f.setVisible(false);
						new Window(numb1);
					}
				} catch (NumberFormatException nfe) {
					Main.logger.warning(nfe.getMessage());
					f.setVisible(false);
					except = "hiba -> NFE";
					new ExceptionWindow().firstdisplay();

				} catch (IllegalArgumentException iae) {
					Main.logger.warning(iae.getMessage());
					except = "hiba -> IAE";
					new ExceptionWindow().firstdisplay();
				}
			}
		});

		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(this);
		f.pack();
		f.setLocationRelativeTo(null);
		f.setSize(400, 200);
		f.setVisible(true);
	}

}
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

public class ExceptionWindow extends JPanel {

	/**
	 * 
	 * The serialVersionUID is a universal version identifier for a Serializable class.
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * This method open a new window it has an exception.
	 * 
	 */
	void firstdisplay() {

		JFrame f1 = new JFrame("HIBA");
		JMenuBar bar = new JMenuBar();
		JLabel lab = new JLabel("A hiba kovetkezo: " + PreWindow.except);
		JButton jbutton = new JButton("Back");
		JMenu failmenu = new JMenu("File");
		JMenuItem exit = new JMenuItem("Exit");
		failmenu.add(exit);
		bar.add(failmenu);
		f1.setJMenuBar(bar);

		exit.addActionListener((ActionEvent event) -> {
			System.exit(0);
		});

		f1.add(jbutton);

		add(lab);
		add(jbutton);

		jbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f1.setVisible(false);
				new PreWindow().firstdisplay();
			}
		});

		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f1.add(this);
		f1.pack();
		f1.setLocationRelativeTo(null);
		f1.setSize(200, 150);
		f1.setVisible(true);
	}

}
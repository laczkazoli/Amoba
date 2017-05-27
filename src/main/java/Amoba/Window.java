package Amoba;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Window extends JPanel {

	/**
	 * The serialVersionUID is a universal version identifier for a Serializable class.
	 */
	private static final long serialVersionUID = 1L;

	private static final int SIZE = 600;
	static int szamlalo = 0;
	static JFrame f;
	static int[][] matrix;

	/**
	 * This method create the window.
	 * 
	 * @param N is the size of the window
	 */
	public Window(int N) {
		super(new GridLayout(N, N));
		this.setPreferredSize(new Dimension(SIZE, SIZE));
		for (int i = 0; i < N * N; i++) {
			this.add(new TicButton(i, N));
		}

		matrix = new int[N][N];
		szamlalo = 0;
		display();
	}

	private static class TicButton extends JButton {

		/**
		 * 
	     * The serialVersionUID is a universal version identifier for a Serializable class.
		 */
		private static final long serialVersionUID = 1L;

		/**
		 * This method read, resize and set the image.
		 * 
		 * @param player get which player is in the line
		 */
		private void setButtonImage(int player) {
			try {
				Image imgx = ImageIO.read(getClass().getResource("/X.PNG"));
				Image img0 = ImageIO.read(getClass().getResource("/0.PNG"));
				Image image = (player == 1) ? imgx : img0;
				setIcon(new ImageIcon(image.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH)));
				setHorizontalTextPosition(AbstractButton.CENTER);
				setText(null);
			} catch (IOException io) {
				Main.logger.warning(io.getMessage());
			}

		}

		/**
		 * This method is containing the passes after a click.
		 * 
		 * @param i get which position you clicked it
		 * @param N is the size of the window
		 */
		public TicButton(int i, int N) {

			super(i / N + "," + i % N);
			this.setOpaque(true);
			this.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));

			setBackground(Color.white);

			this.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Main.logger.info(i / N + "," + i % N);

					if (matrix[i / N][i % N] == 0) {

						if (szamlalo % 2 == 0) {
							setButtonImage(1);
							Main.logger.info("\n\nAz x jatekos lepett");
							Main.logger.finest("ez volt ->" + Integer.toString(matrix[i / N][i % N]));
							matrix[i / N][i % N] = 1;
							Main.logger.finest("ez lett ->" + Integer.toString(matrix[i / N][i % N]));
							szamlalo++;
						} else {
							setButtonImage(2);
							Main.logger.info("\n\nAz 0 jatekos lepett");
							Main.logger.finest("ez volt ->" + Integer.toString(matrix[i / N][i % N]));
							matrix[i / N][i % N] = 2;
							Main.logger.finest("ez lett ->" + Integer.toString(matrix[i / N][i % N]));
							szamlalo++;
						}

						int[] c = Find.matrixszukites(N, i);

						if (Find.vkeres(N, i, c) == true || Find.fkeres(N, i, c) == true
								|| Find.bkeres(N, i, c) == true || Find.jkeres(N, i, c) == true) {
							if (WinnerWindow.getWinnerWindow() == 1) {
								System.exit(0);
							} else {
								Main.logger.finest("epp a vizsgalatnal vagyok");
								f.dispose();
								new PreWindow().firstdisplay();
							}
						}

						else if ((szamlalo == N * N)) {
							if (EqualWindow.getEqualWindow() == 1) {
								System.exit(0);
							} else {
								f.dispose();
								new PreWindow().firstdisplay();
							}
						}

					}
				}
			});

		}

	}

	/**
	 * This method create the window.
	 */
	void display() {
		f = new JFrame("Amoba");
		JMenuBar bar = new JMenuBar();
		JMenu failmenu = new JMenu("File");
		JMenuItem save = new JMenuItem("Save");
		JMenuItem exit = new JMenuItem("Exit");
		failmenu.add(save);
		failmenu.add(exit);
		f.setResizable(false);

		exit.addActionListener((ActionEvent event) -> {
			System.exit(0);
		});

		bar.add(failmenu);
		f.setJMenuBar(bar);

		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(this);
		f.pack();
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	}

}
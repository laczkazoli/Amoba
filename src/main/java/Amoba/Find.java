package Amoba;

public class Find {
	/**
	 * This method can reduce the matrix wherein we are searching.
	 * 
	 * @param N is the size of the table
	 * @param i get which position you clicked it
	 * @return a vector which contains a maximum 9*9 matrix coordinates
	 */
	public static int[] matrixszukites(int N, int i) {
		int[] c = new int[4];
		int x1, x2;
		int y1, y2;
		if (i / N - 4 < 0) {
			x1 = 0;
		} else {
			x1 = i / N - 4;
		}
		if (i / N + 4 > N - 1) {
			x2 = N - 1;
		} else {
			x2 = i / N + 4;
		}
		if (i % N - 4 < 0) {
			y1 = 0;
		} else {
			y1 = i % N - 4;
		}
		if (i % N + 4 > N - 1) {
			y2 = N - 1;
		} else {
			y2 = i % N + 4;

		}
		Main.logger.finest("\nKoordinatak:\nx1: " + x1 + " x2: " + x2 + "\ny1: " + y1 + " y2: " + y2);
		c[0] = x1;
		c[1] = x2;
		c[2] = y1;
		c[3] = y2;

		return c;
	}

	/**
	 * This method search in the matrix vertical.
	 * 
	 * @param N is the size of the table
	 * @param i get which position you clicked it
	 * @param c is containing the value of the shorted matrix
	 * @return a boolean if we want to start again the game
	 */
	public static boolean vkeres(int N, int i, int[] c) {
		int x1 = c[0], x2 = c[1];
		int y1 = c[2], y2 = c[3];

		for (int q = x1; q <= x2; q++) {
			int db = 0;
			for (int w = y1; w <= y2; w++) {
				if (Window.matrix[q][w] != 0 && (w <= N - 1 - 4)) {
					for (int a = 0; a < 4; a++)
						if (Window.matrix[q][w] == Window.matrix[q][w + a + 1] && db < 4) {
							db++;
							Main.logger.finest("vizszintes db: " + db);

							// System.out.print("NYERT");
						} else {

							// w = w + db + 1;
							db = 0;
							break;
						}

				}
				if (db == 4) {
					return true;
				}

			}

		}

		return false;
	}

	/**
	 * This method search in the matrix plumb.
	 * 
	 * @param N is size of the table
	 * @param i get which position you clicked it
	 * @param c is containing the value of the shorted matrix
	 * @return a boolean if we want to start again the game
	 */
	public static boolean fkeres(int N, int i, int c[]) {
		int x1 = c[0], x2 = c[1];
		int y1 = c[2], y2 = c[3];

		for (int t = x1; t <= x2; t++) {
			int db1 = 0;
			for (int r = y1; r <= y2; r++) {
				if (Window.matrix[t][r] != 0 && (t <= N - 1 - 4)) {
					for (int s = 0; s < 4; s++)
						if (Window.matrix[t][r] == Window.matrix[t + s + 1][r] && db1 < 4) {
							db1++;
							Main.logger.finest("fuggoleges db: " + db1);
							// System.out.print("NYERT");
						} else {

							// r = r + db1 + 1;
							db1 = 0;
							break;
						}

				}
				if (db1 == 4) {
					return true;

				}

			}

		}
		return false;
	}

	/**
	 * This method search in the matrix diagonally.
	 * 
	 * @param N is the size of the table
	 * @param i get which position you clicked it
	 * @param c is containing the value of the shorted matrix
	 * @return a boolean if we want to start again the game
	 */

	public static boolean bkeres(int N, int i, int[] c) {
		int x1 = c[0], x2 = c[1];
		int y1 = c[2], y2 = c[3];
		for (int q2 = x1; q2 <= x2; q2++) {
			int db2 = 0;
			for (int w2 = y1; w2 <= y2; w2++) {
				if (Window.matrix[q2][w2] != 0 && (q2 <= N - 1 - 4) && (w2 <= N - 1 - 4)) {
					for (int a2 = 0; a2 < 4; a2++)
						if (Window.matrix[q2][w2] == Window.matrix[q2 + a2 + 1][w2 + a2 + 1] && db2 < 4) {
							db2++;
							Main.logger.finest("balatlo db: " + db2);
						} else {

							// w2 = w2 + db2 + 1;
							// q2 = q2 + db2 + 1;
							db2 = 0;
							break;
						}

				}
				if (db2 == 4) {
					return true;
				}

			}

		}
		return false;
	}

	/**
	 * This method search in the matrix diagonally.
	 * 
	 * @param N is the size of the table
	 * @param i get which position you clicked it
	 * @param c is containing the value of the shorted matrix
	 * @return a boolean if we want to start again the game
	 */

	public static boolean jkeres(int N, int i, int[] c) {
		int x1 = c[0], x2 = c[1];
		int y1 = c[2], y2 = c[3];
		for (int q3 = x1; q3 <= x2; q3++) {
			int db3 = 0;
			for (int w3 = y1; w3 <= y2; w3++) {
				if (Window.matrix[q3][w3] != 0 && (q3 <= N - 1 - 4) && (w3 > 3)) {
					for (int a3 = 0; a3 < 4; a3++)
						if (Window.matrix[q3][w3] == Window.matrix[q3 + a3 + 1][w3 - a3 - 1] && db3 < 4) {
							db3++;
							Main.logger.finest("jobbatlo db: " + db3);
							// System.out.print("NYERT");
						} else {

							// q3 = q3 + db3 + 1;
							// w3 = w3 - db3 - 1;
							db3 = 0;
							break;
						}

				}
			}
			if (db3 == 4) {
				return true;
			}
		}
		return false;
	}

}
package Amoba;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.BeforeClass;
import org.junit.Test;

public class FindTest {
	
	@BeforeClass
	public static void elotte() {
		Main.inicializeLogging();
	}

	@Test
	public void testMatrixszukites() {
		int[] c = Find.matrixszukites(10, 48);
		int x1 = c[0];
		int x2 = c[1];
		int y1 = c[2];
		int y2 = c[3];
		assertEquals(x1, 0);
		assertEquals(x2, 8);
		assertEquals(y1, 4);
		assertEquals(y2, 9);

	}
	@Test
	public void peldanyFind() {
		Find newFind = new Find();
		assertNotNull(newFind);
	}

	public int[] randomszam() {
		int[] c = new int[2];
		int max = 50, min = 5;
		Random randomszam = new Random();
		c[0] = randomszam.nextInt((max - min) + 1) + min;
		c[1] = randomszam.nextInt((c[0] * c[0] - 1) + 1);
		return c;
	};

	@Test
	public void testVkeres() {
		for (int p = 0; p < 100; p++) {
			int[] x = randomszam();
			int n = x[0], click = x[1];
			Window.matrix = new int[n][n];
			int[] c = Find.matrixszukites(n, click);

			if ((click % n) - 4 <= 0) {
				for (int i = 0; i <= 4; i++)
					Window.matrix[click / n][i] = 2;
			} else {
				for (int i = click % n - 4; i <= click % n; i++) {
					Window.matrix[click / n][i] = 2;
				}

			}

			assertEquals(true, Find.vkeres(n, click, c));
		}
		for (int p = 0; p < 100; p++) {
			Random randomszam = new Random();
			int max = 50, min = 5;
			int n = randomszam.nextInt((max - min) + 1) + min;
			int click = randomszam.nextInt((n * n - 1) + 1);
			Window.matrix = new int[n][n];
			Window.matrix[click / n][click % n] = 2;
			int[] c = Find.matrixszukites(n, click);
			assertEquals(false, Find.vkeres(n, click, c));
		}
	}

	@Test
	public void testFkeres() {
		for (int p = 0; p < 100; p++) {
			int[] x = randomszam();
			int n = x[0], click = x[1];
			// System.out.println("ez az click:" + click);
			Window.matrix = new int[n][n];
			int[] c = Find.matrixszukites(n, click);

			if ((click / n) - 4 <= 0) {
				for (int i = 0; i <= 4; i++)
					Window.matrix[i][click % n] = 2;
			} else {
				for (int i = click / n - 4; i <= click / n; i++) {
					Window.matrix[i][click % n] = 2;
				}

			}

			assertEquals(true, Find.fkeres(n, click, c));
		}
		for (int p = 0; p < 100; p++) {
			Random randomszam = new Random();
			int max = 50, min = 5;
			int n = randomszam.nextInt((max - min) + 1) + min;
			int click = randomszam.nextInt((n * n - 1) + 1);
			Window.matrix = new int[n][n];
			Window.matrix[click / n][click % n] = 2;
			int[] c = Find.matrixszukites(n, click);
			assertEquals(false, Find.fkeres(n, click, c));
		}
	}

	@Test
	public void testBkeres() {
		for (int p = 0; p < 100; p++) {
			int[] x = randomszam();
			int n = x[0], click = x[1];
			Window.matrix = new int[n][n];
			int[] c = Find.matrixszukites(n, click);

			if (((click % n) - 4 <= 0) && ((click / n) < n - 4) && ((click / n) - 4 > 0) && ((click % n) + 4 < n)) {
				for (int i = 0; i <= 4; i++)
					Window.matrix[((click / n) - (click % n)) + i][i] = 2;
				assertEquals(true, Find.bkeres(n, click, c));
			} else {
				Window.matrix[click / n][click % n] = 2;
				assertEquals(false, Find.bkeres(n, click, c));
			}
		}
	}

	@Test
	public void testJkeres() {
		for (int p = 0; p < 100; p++) {
			int[] x = randomszam();
			int n = x[0], click = x[1];
			Window.matrix = new int[n][n];
			int[] c = Find.matrixszukites(n, click);

			if (((click % n) - 4 <= 0) && ((click / n) < n - 4) && ((click / n) - 4 > 0) && ((click % n) + 4 < n)) {
				for (int i = 0; i <= 4; i++)
					Window.matrix[((click / n) - i)][(click % n) + i] = 2;
				assertEquals(true, Find.jkeres(n, click, c));
			} else {
				Window.matrix[click / n][click % n] = 2;
				assertEquals(false, Find.jkeres(n, click, c));
			}
		}
	}

}

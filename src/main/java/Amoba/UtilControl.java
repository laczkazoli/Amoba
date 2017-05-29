package Amoba;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.LogManager;
/**
 * This class creating the config folder and file.
 * @author zoli
 *
 */
public class UtilControl {
/**
 * This string contains the config file name.
 */
	private String myConfigFileName;
	
/**
 * This method is creating the config file if it does not exist.
 */
	public void createConfigFile() {
		createLoggerFolder();
		myConfigFileName = System.getProperty("user.home") + "//amoba//" + "logging.properties";
		File myConfigFile = new File(myConfigFileName);
		if (!myConfigFile.exists()) {
			try {
				InputStream configFile = getClass().getClassLoader().getResourceAsStream("logging.properties");
				copyInputStreamToFile(configFile, myConfigFile);
				LogManager.getLogManager().readConfiguration(configFile);
				configFile.close();
			} catch (Exception ex) {
				System.out.println("Konfigurációs állomány létrehozása sikertelen: " + ex);
			}
		} else {
			try {
				FileInputStream configFile = new FileInputStream(myConfigFileName);
				LogManager.getLogManager().readConfiguration(configFile);
			} catch (IOException ex) {
				System.out.println("Beállítások olvasása sikertelen! " + ex.toString());
			}
		}
	}
/**
 * This method is creating the logger folder if it does not exist.
 */
	public void createLoggerFolder() {
		File loggerFolder = new File(System.getProperty("user.home") + "//amoba");
		if (!loggerFolder.exists()) {
			try {
				if (loggerFolder.mkdir()) {
				} else {
					throw new SecurityException("gameFolder.mkdir() visszatérési értéke hamis.");
				}
			} catch (SecurityException se) {
			}
		} else {
		}
	}

	/**
	 * This method is copying the loggmessages to the file.
	 * @param in is the input stream
	 * @param file is the config file
	 */
	private void copyInputStreamToFile(InputStream in, File file) {
		try {
			OutputStream out = new FileOutputStream(file);
			byte[] buf = new byte[1024];
			int len;
			while ((len = in.read(buf)) > 0) {
				out.write(buf, 0, len);
			}
			out.close();
			// in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

package Amoba;


import java.util.logging.Logger;
/**
 * This is the main class.
 * <code> Main </code>
 * @author zoli
 *
 */
public class Main {
	
	/**
	 * A Logger object is used to log messages for a specific system or application component.
	 */
	public static Logger logger;
	/**
	 * This is the main method.
	 * This method instantiation the <code> FileHandler </code> and PreWindow
	 * @param args is the argument
	 */
	public static void main(String[] args) {
		
		
		inicializeLogging();
		logger.info("The program is running ");		
		new PreWindow().firstdisplay();
		
	}
	/**
	 * Inicialize the Logger.
	 */
	public static void inicializeLogging(){
		new UtilControl().createConfigFile();
		logger = Logger.getLogger(Main.class.getName());
	}

}

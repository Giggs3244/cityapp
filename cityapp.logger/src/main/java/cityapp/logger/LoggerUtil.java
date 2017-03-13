package cityapp.logger;

import org.apache.log4j.Logger;

public class LoggerUtil {

	private LoggerUtil() {
	}

	public static void info(String clase, String mensaje) {
		String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
		int lineNumber = Thread.currentThread().getStackTrace()[2].getLineNumber();

		Logger logger = Logger.getLogger(clase);
		logger.info(methodName + ":" + lineNumber + "] " + mensaje);
	}

}

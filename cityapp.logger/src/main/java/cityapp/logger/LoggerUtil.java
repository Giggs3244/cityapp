package cityapp.logger;

import org.apache.log4j.Logger;

public class LoggerUtil {

	private LoggerUtil() {
	}

	public static void info(Class<?> clase, String mensaje) {
		String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
		int lineNumber = Thread.currentThread().getStackTrace()[2].getLineNumber();

		Logger logger = Logger.getLogger(clase.getName());
		logger.info(methodName + ":" + lineNumber + "] " + mensaje);
	}

	public static void error(Class<?> clase, String mensaje, Throwable ex) {
		String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
		int lineNumber = Thread.currentThread().getStackTrace()[2].getLineNumber();

		Logger logger = Logger.getLogger(clase.getName());
		logger.error(methodName + ":" + lineNumber + "] " + mensaje, ex);
	}

	public static void error(Class<?> clase, String mensaje) {
		String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
		int lineNumber = Thread.currentThread().getStackTrace()[2].getLineNumber();

		Logger logger = Logger.getLogger(clase.getName());
		logger.error(methodName + ":" + lineNumber + "] " + mensaje);
	}

}

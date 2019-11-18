package webdriver.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log {
    private static Logger logger = LogManager.getRootLogger();

    public static void info(String message ) {
        logger.info(message);
    }

    public static void debug(String message) {
        logger.debug(message);
    }

    public static void error(Exception exc) {
        logger.error(exc);
    }

    public static void warn(String message) {
        logger.warn(message);
    }
}

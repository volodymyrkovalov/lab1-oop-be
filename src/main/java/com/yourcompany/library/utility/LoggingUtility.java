package com.yourcompany.library.utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Utility class for logging various levels of messages and exceptions.
 */
public class LoggingUtility {
    // You can obtain a logger instance for each class or use a generic logger for the whole application
    private static final Logger logger = LogManager.getLogger(LoggingUtility.class);

    /**
     * Logs debug messages.
     * @param message The message to log.
     */
    public static void logDebug(String message) {
        logger.debug(message);
    }

    /**
     * Logs information messages.
     * @param message The message to log.
     */
    public static void logInfo(String message) {
        logger.info(message);
    }

    /**
     * Logs error messages.
     * @param message The message to log.
     */
    public static void logError(String message) {
        logger.error(message);
    }

    /**
     * Logs error messages with exceptions.
     * @param message The message to log.
     * @param throwable The exception to log.
     */
    public static void logError(String message, Throwable throwable) {
        logger.error(message, throwable);
    }

    /**
     * Logs warning messages.
     * @param message The message to log.
     */
    public static void logWarn(String message) {
        logger.warn(message);
    }

    /**
     * Logs fatal error messages.
     * @param message The message to log.
     */
    public static void logFatal(String message) {
        logger.fatal(message);
    }
}

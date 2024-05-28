package com.example.frealsb.Util;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Utility class for logging operations.
 */
public class LoggingUtils {

    private static final Logger logger = Logger.getLogger(LoggingUtils.class.getName());

    /**
     * Log an informational message.
     * @param message the message to log
     */
    public static void logInfo(String message) {
        logger.log(Level.INFO, message);
    }

    /**
     * Log a warning message.
     * @param message the message to log
     */
    public static void logWarning(String message) {
        logger.log(Level.WARNING, message);
    }

    /**
     * Log an error message.
     * @param message the message to log
     */
    public static void logError(String message) {
        logger.log(Level.SEVERE, message);
    }

    // Add more logging utility methods as needed
}

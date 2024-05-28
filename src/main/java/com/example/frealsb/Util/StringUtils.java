package com.example.frealsb.Util;

/**
 * Utility class for string operations.
 */
public class StringUtils {

    /**
     * Check if a string is null or empty.
     * @param str the string to check
     * @return true if the string is null or empty, false otherwise
     */
    public static boolean isNullOrEmpty(String str) {
        return str == null || str.isEmpty();
    }

    /**
     * Trim leading and trailing whitespace from a string.
     * @param str the string to trim
     * @return the trimmed string
     */
    public static String trim(String str) {
        return str.trim();
    }

    // Add more string utility methods as needed
}

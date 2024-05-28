package com.example.frealsb.Util;

import java.io.File;

/**
 * Utility class for file operations.
 */
public class FileUtils {

    /**
     * Check if a file exists.
     * @param filePath the path to the file
     * @return true if the file exists, false otherwise
     */
    public static boolean exists(String filePath) {
        File file = new File(filePath);
        return file.exists();
    }

    // Add more file utility methods as needed
}

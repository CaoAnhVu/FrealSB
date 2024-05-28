package com.example.frealsb.Util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Utility class for HTTP operations.
 */
public class HttpUtils {

    /**
     * Send a GET request to the specified URL and return the response.
     * @param url the URL to send the request to
     * @return the response string
     * @throws IOException if an I/O error occurs
     */
    public static String sendGetRequest(String url) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setRequestMethod("GET");

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();
        return response.toString();
    }

    // Add more HTTP utility methods as needed
}

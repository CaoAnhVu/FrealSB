package com.example.frealsb.Util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Utility class for date and time operations.
 */
public class DateUtils {

    /**
     * Convert a {@link String} to {@link LocalDate} using the specified pattern.
     * @param dateStr the date string
     * @param pattern the pattern to parse the date string
     * @return the {@link LocalDate} object
     */
    public static LocalDate parseDate(String dateStr, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return LocalDate.parse(dateStr, formatter);
    }

    /**
     * Convert a {@link String} to {@link LocalDateTime} using the specified pattern.
     * @param dateTimeStr the date-time string
     * @param pattern the pattern to parse the date-time string
     * @return the {@link LocalDateTime} object
     */
    public static LocalDateTime parseDateTime(String dateTimeStr, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return LocalDateTime.parse(dateTimeStr, formatter);
    }

    /**
     * Format a {@link LocalDate} object to {@link String} using the specified pattern.
     * @param date the {@link LocalDate} object
     * @param pattern the pattern to format the date
     * @return the formatted date string
     */
    public static String formatDate(LocalDate date, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return date.format(formatter);
    }

    /**
     * Format a {@link LocalDateTime} object to {@link String} using the specified pattern.
     * @param dateTime the {@link LocalDateTime} object
     * @param pattern the pattern to format the date-time
     * @return the formatted date-time string
     */
    public static String formatDateTime(LocalDateTime dateTime, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return dateTime.format(formatter);
    }
}


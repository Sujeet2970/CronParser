package org.deliveroo.formatter;

import lombok.NonNull;

import java.util.List;

import static org.deliveroo.constants.Separator.SPACE;

/**
 * Utility class for formatting cron field data into a specific display format.
 * Provides methods to format field names and corresponding values.
 */
public class CronFieldFormatter {

    /**
     * Formats a list of values associated with a cron field into a formatted string.
     *
     * @param fieldName the name of the cron field.
     * @param values    a list of values associated with the cron field.
     * @return a formatted string representing the cron field and its values.
     */
    public static String getFormattedRowData(@NonNull String fieldName, @NonNull List<String> values) {
        return String.format("%-14s %s%n", fieldName, String.join(SPACE, values));
    }

    /**
     * Formats a single value associated with a cron field into a formatted string.
     *
     * @param fieldName the name of the cron field.
     * @param value     a single value associated with the cron field.
     * @return a formatted string representing the cron field and its value.
     */
    public static String getFormattedRowData(@NonNull String fieldName, @NonNull String value) {
        return String.format("%-14s %s%n", fieldName, value);
    }
}

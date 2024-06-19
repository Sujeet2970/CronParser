package org.deliveroo.formatter;

import lombok.NonNull;

import java.util.List;

import static org.deliveroo.constants.Separator.SPACE;

public class CronFieldFormatter {

    public static String getFormattedRowData(@NonNull String fieldName, @NonNull List<String> values) {
        return String.format("%-14s %s%n", fieldName, String.join(SPACE, values));
    }


    public static String getFormattedRowData(@NonNull String fieldName, @NonNull String value) {
        return String.format("%-14s %s%n", fieldName, value);
    }
}


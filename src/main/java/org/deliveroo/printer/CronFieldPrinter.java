package org.deliveroo.printer;

import lombok.NonNull;

import java.util.List;

import static org.deliveroo.constants.Separator.SPACE;

public class CronFieldPrinter {

    public static void printTable(@NonNull String fieldName, @NonNull List<String> values) {
        System.out.printf("%-14s %s%n", fieldName, String.join(SPACE, values));
    }

    public static void printTable(@NonNull String fieldName, @NonNull String value) {
        System.out.printf("%-14s %s%n", fieldName, value);
    }
}


package org.deliveroo.printer;

import java.util.List;

public class CronFieldPrinter {

    public static void printTable(String fieldName, List<String> values) {
        System.out.printf("%-14s %s%n", fieldName, String.join(" ", values));
    }

    public static void printTable(String fieldName, String value) {
        System.out.printf("%-14s %s%n", fieldName, value);
    }
}


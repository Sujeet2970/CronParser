package org.deliveroo;

import org.deliveroo.segments.*;
import static org.deliveroo.constants.Columns.*;
import static org.deliveroo.printer.CronFieldPrinter.printTable;

public class CronParser {

    public void parseAndPrintCronString(String cronString) {
        String[] parts = cronString.split(" ", 6);
        if (parts.length != 6) {
            throw new IllegalArgumentException("Invalid cron string format.");
        }
        try {
            parseString(parts);
        } catch (Exception ex) {
            System.out.println("Error in parsing the given strings");
        }
    }

    private static void parseString(String[] parts) {
        String minutePart = parts[0];
        String hourPart = parts[1];
        String dayOfMonthPart = parts[2];
        String monthPart = parts[3];
        String dayOfWeekPart = parts[4];
        String command = parts[5];

        printTable(MINUTE, new Minute(minutePart).expandField());
        printTable(HOUR, new Hour(hourPart).expandField());
        printTable(DAY_OF_MONTH, new DaysOfMonth(dayOfMonthPart).expandField());
        printTable(MONTH, new Month(monthPart).expandField());
        printTable(DAY_OF_WEEK, new DaysOfWeek(dayOfWeekPart).expandField());
        printTable(COMMAND, command);
    }
}
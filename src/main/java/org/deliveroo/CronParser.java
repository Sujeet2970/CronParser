package org.deliveroo;

import org.deliveroo.segments.*;
import static org.deliveroo.constants.Columns.*;
import static org.deliveroo.constants.Separator.SPACE;
import static org.deliveroo.printer.CronFieldPrinter.printTable;

public class CronParser {
    private static final Integer MINUTE_PART_INDEX = 0;
    private static final Integer HOUR_PART_INDEX = 1;
    private static final Integer DAY_OF_MONTH_PART_INDEX = 2;
    private static final Integer MONTH_PART_INDEX = 3;
    private static final Integer DAY_OF_WEEK_PART_INDEX = 4;
    private static final Integer COMMAND_PART_INDEX = 5;

    public void parseAndPrintCronString(String cronString) {
        String[] parts = cronString.split(SPACE, 6);
        if (parts.length != 6) {
            throw new IllegalArgumentException("Invalid cron string format.");
        }
        try {
            parseString(parts);
        } catch (Exception ex) {
            System.out.println("Error in parsing the given string");
        }
    }

    private static void parseString(String[] parts) {
        String minutePart = parts[MINUTE_PART_INDEX];
        String hourPart = parts[HOUR_PART_INDEX];
        String dayOfMonthPart = parts[DAY_OF_MONTH_PART_INDEX];
        String monthPart = parts[MONTH_PART_INDEX];
        String dayOfWeekPart = parts[DAY_OF_WEEK_PART_INDEX];
        String command = parts[COMMAND_PART_INDEX];

        printTable(MINUTE, new Minute(minutePart).expandField());
        printTable(HOUR, new Hour(hourPart).expandField());
        printTable(DAY_OF_MONTH, new DaysOfMonth(dayOfMonthPart).expandField());
        printTable(MONTH, new Month(monthPart).expandField());
        printTable(DAY_OF_WEEK, new DaysOfWeek(dayOfWeekPart).expandField());
        printTable(COMMAND, command);
    }
}
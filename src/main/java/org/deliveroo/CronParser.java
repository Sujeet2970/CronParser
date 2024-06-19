package org.deliveroo;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.deliveroo.formatter.CronFieldFormatter;
import org.deliveroo.segments.*;

import java.util.logging.Logger;

import static org.deliveroo.constants.Columns.*;
import static org.deliveroo.constants.Separator.SPACE;
import static org.deliveroo.formatter.CronFieldFormatter.getFormattedRowData;

@RequiredArgsConstructor
public class CronParser {
    private static final Integer MINUTE_PART_INDEX = 0;
    private static final Integer HOUR_PART_INDEX = 1;
    private static final Integer DAY_OF_MONTH_PART_INDEX = 2;
    private static final Integer MONTH_PART_INDEX = 3;
    private static final Integer DAY_OF_WEEK_PART_INDEX = 4;
    private static final Integer COMMAND_PART_INDEX = 5;
    private static final Integer SEGMENT_LIMIT = 6;

    private final String cronString;

    public String parseAndGetCronString() {
        String[] parts = cronString.split(SPACE, SEGMENT_LIMIT);
        if (parts.length != SEGMENT_LIMIT) {
            throw new IllegalArgumentException("Invalid cron string format.");
        }
        try {
            return parseString(parts);
        } catch (Exception ex) {
            System.out.println(ex.toString());

            return "Error in parsing the given string";
        }
    }

    private static String parseString(String[] parts) {
        String minutePart = parts[MINUTE_PART_INDEX];
        String hourPart = parts[HOUR_PART_INDEX];
        String dayOfMonthPart = parts[DAY_OF_MONTH_PART_INDEX];
        String monthPart = parts[MONTH_PART_INDEX];
        String dayOfWeekPart = parts[DAY_OF_WEEK_PART_INDEX];
        String command = parts[COMMAND_PART_INDEX];

        return CronFieldFormatter.getFormattedRowData(MINUTE, new Minute(minutePart).expandField()) +
                CronFieldFormatter.getFormattedRowData(HOUR, new Hour(hourPart).expandField()) +
                CronFieldFormatter.getFormattedRowData(DAY_OF_MONTH, new DaysOfMonth(dayOfMonthPart).expandField()) +
                CronFieldFormatter.getFormattedRowData(MONTH, new Month(monthPart).expandField()) +
                CronFieldFormatter.getFormattedRowData(DAY_OF_WEEK, new DaysOfWeek(dayOfWeekPart).expandField()) +
                getFormattedRowData(COMMAND, command);
    }
}
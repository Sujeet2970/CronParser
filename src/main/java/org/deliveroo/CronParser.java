package org.deliveroo;

import lombok.RequiredArgsConstructor;

import org.deliveroo.cronfields.Month;
import org.deliveroo.cronfields.Hour;
import org.deliveroo.cronfields.Minute;
import org.deliveroo.cronfields.DaysOfWeek;
import org.deliveroo.cronfields.DaysOfMonth;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.deliveroo.constants.Columns.MONTH;
import static org.deliveroo.constants.Columns.DAY_OF_MONTH;
import static org.deliveroo.constants.Columns.MINUTE;
import static org.deliveroo.constants.Columns.DAYS_OF_WEEK;
import static org.deliveroo.constants.Columns.HOUR;
import static org.deliveroo.constants.Columns.COMMAND;
import static org.deliveroo.constants.Separator.SPACE;
import static org.deliveroo.formatter.CronFormatter.getFormattedRowData;

/**
 * The {@code CronParser} class parses a cron expression string into its constituent parts
 * and formats them for display.
 * <p>
 * The cron string is expected to follow the standard cron format with five time fields
 * (minute, hour, day of month, month, day of week) followed by a command.
 * <p>
 * This class uses {@code lombok.RequiredArgsConstructor} to automatically generate a constructor
 * for the {@code cronString} field.
 * <p>
 */

@RequiredArgsConstructor
public class CronParser {
    private static final Integer MINUTE_FIELD_INDEX = 0;
    private static final Integer HOUR_FIELD_INDEX = 1;
    private static final Integer DAY_OF_MONTH_FIELD_INDEX = 2;
    private static final Integer MONTH_FIELD_INDEX = 3;
    private static final Integer DAY_OF_WEEK_FIELD_INDEX = 4;
    private static final Integer COMMAND_FIELD_INDEX = 5;
    private static final Integer SEGMENT_LIMIT = 6;
    private static final Map<String, List<String>> displayString = new HashMap<>();
    private static final List<String> DISPLAY_ORDER = List.of(MINUTE, HOUR, DAY_OF_MONTH, MONTH, DAYS_OF_WEEK);

    private final String cronString;


    /**
     * Parses the cron string and returns a formatted string representing the expanded cron fields.
     * If the cron string is invalid, an error message is returned.
     *
     * @return the formatted string or exception if anything goes wrong.
     */
    public String parse() throws IllegalArgumentException {
        String[] parts = cronString.split(SPACE, SEGMENT_LIMIT);
        if (parts.length != SEGMENT_LIMIT) {
            return new IllegalArgumentException("Invalid cron string format.").toString();
        }

        return parseString(parts);
    }

    private static String parseString(String[] fields) {
        displayString.put(MINUTE, new Minute(fields[MINUTE_FIELD_INDEX]).expandField());
        displayString.put(HOUR, new Hour(fields[HOUR_FIELD_INDEX]).expandField());
        displayString.put(DAY_OF_MONTH, new DaysOfMonth(fields[DAY_OF_MONTH_FIELD_INDEX]).expandField());
        displayString.put(MONTH, new Month(fields[MONTH_FIELD_INDEX]).expandField());
        displayString.put(DAYS_OF_WEEK, new DaysOfWeek(fields[DAY_OF_WEEK_FIELD_INDEX]).expandField());

        StringBuilder displayContent = new StringBuilder();
        for(String field : DISPLAY_ORDER) {
            displayContent.append(getFormattedRowData(field, displayString.get(field)));
        }

        displayContent.append(getFormattedRowData(COMMAND, fields[COMMAND_FIELD_INDEX]));

        return displayContent.toString();
    }
}
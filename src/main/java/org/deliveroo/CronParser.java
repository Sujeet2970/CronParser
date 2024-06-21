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
import static org.deliveroo.constants.Columns.DAY_OF_WEEK;
import static org.deliveroo.constants.Columns.HOUR;
import static org.deliveroo.constants.Columns.COMMAND;
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
    private static final Map<String, List<String>> displayString = new HashMap<>();
    private static final List<String> DISPLAY_ORDER = List.of(MINUTE, HOUR, DAY_OF_MONTH, MONTH, DAY_OF_WEEK);

    private final String cronString;

    public String parse() {
        String[] parts = cronString.split(SPACE, SEGMENT_LIMIT);
        if (parts.length != SEGMENT_LIMIT) {
            return new IllegalArgumentException("Invalid cron string format.").toString();
        }

        try {
            return parseString(parts);
        } catch (Exception ex) {
            System.out.println(ex.toString());

            return String.format("Error in parsing the expression : %s", cronString);
        }
    }

    private static String parseString(String[] parts) {
        String minutePart = parts[MINUTE_PART_INDEX];
        String hourPart = parts[HOUR_PART_INDEX];
        String dayOfMonthPart = parts[DAY_OF_MONTH_PART_INDEX];
        String monthPart = parts[MONTH_PART_INDEX];
        String dayOfWeekPart = parts[DAY_OF_WEEK_PART_INDEX];
        String command = parts[COMMAND_PART_INDEX];

        displayString.put(MINUTE, new Minute(minutePart).expandField());
        displayString.put(HOUR, new Hour(hourPart).expandField());
        displayString.put(DAY_OF_MONTH, new DaysOfMonth(dayOfMonthPart).expandField());
        displayString.put(MONTH, new Month(monthPart).expandField());
        displayString.put(DAY_OF_WEEK, new DaysOfWeek(dayOfWeekPart).expandField());

        StringBuilder displayContent = new StringBuilder();
        for(String field : DISPLAY_ORDER) {
            displayContent.append(getFormattedRowData(field, displayString.get(field)));
        }

        displayContent.append(getFormattedRowData(COMMAND, command));

        return displayContent.toString();
    }
}
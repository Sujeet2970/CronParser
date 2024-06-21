package org.deliveroo;

import lombok.RequiredArgsConstructor;

import org.deliveroo.cronfields.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.deliveroo.constants.Columns.*;
import static org.deliveroo.constants.Separator.SPACE;
import static org.deliveroo.formatter.CronFieldFormatter.getFormattedRowData;

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
    private static final Integer MINUTE_PART_INDEX = 0;
    private static final Integer HOUR_PART_INDEX = 1;
    private static final Integer DAY_OF_MONTH_PART_INDEX = 2;
    private static final Integer MONTH_PART_INDEX = 3;
    private static final Integer DAY_OF_WEEK_PART_INDEX = 4;
    private static final Integer COMMAND_PART_INDEX = 6;
    private static final Integer YEAR_PART_INDEX = 5;
    private static final Integer SEGMENT_LIMIT = 7;
    private static final Map<String, List<String>> displayString = new HashMap<>();
    private static final List<String> DISPLAY_ORDER = List.of(MINUTE, HOUR, DAY_OF_MONTH, MONTH, DAYS_OF_WEEK, YEAR);

    private final String cronString;


    /**
     * Parses the cron string and returns a formatted string representing the expanded cron fields.
     * If the cron string is invalid, an error message is returned.
     *
     * @return the formatted string or an error message if the cron string is invalid.
     */
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
        String yearPart = parts[YEAR_PART_INDEX];
        String command = parts[COMMAND_PART_INDEX];

        displayString.put(MINUTE, new Minute(minutePart).expandField());
        displayString.put(HOUR, new Hour(hourPart).expandField());
        displayString.put(DAY_OF_MONTH, new DaysOfMonth(dayOfMonthPart).expandField());
        displayString.put(MONTH, new Month(monthPart).expandField());
        displayString.put(DAYS_OF_WEEK, new DaysOfWeek(dayOfWeekPart).expandField());
        displayString.put(YEAR, new Year(yearPart).expandField());

        StringBuilder displayContent = new StringBuilder();
        for(String field : DISPLAY_ORDER) {
            displayContent.append(getFormattedRowData(field, displayString.get(field)));
        }

        displayContent.append(getFormattedRowData(COMMAND, command));

        return displayContent.toString();
    }

    public String parseAndGetNthOccurrenceTime(Integer n) {
        System.out.println(this.parse());

        int count = 0;

        for(int i = 0; i < displayString.get(YEAR).size(); i++) {
            for(int j = 0; j < displayString.get(MONTH).size(); j++) {
                for(int k = 0; k < displayString.get(DAY_OF_MONTH).size(); k++) {
                    int p = (Integer.parseInt(displayString.get(DAY_OF_MONTH).get(k)) % 7);
                    if(!displayString.get(DAYS_OF_WEEK).contains(Integer.toString(p))) {
                        continue;
                    }
                    for (int l = 0; l < displayString.get(HOUR).size(); l++) {
                        for (int m = 0; m < displayString.get(MINUTE).size(); m++) {
                            count++;

                            if(count == n) {

                                StringBuilder displayContent = new StringBuilder();
                                String s = displayString.get(YEAR).get(i) + " " + displayString.get(MONTH).get(j) + " "
                                        + displayString.get(DAY_OF_MONTH).get(k) + " " + displayString.get(HOUR).get(l) + " "
                                        + displayString.get(MINUTE).get(m);

                                System.out.println(s);
                            }
                        }
                    }
                }
            }

        }
        return "";
    }
}
package org.deliveroo;

import org.deliveroo.parser.*;
import org.deliveroo.segments.*;

import java.util.List;

import static org.deliveroo.constants.Separator.*;
import static org.deliveroo.constants.Columns.*;
import static org.deliveroo.printer.CronFieldPrinter.printTable;

public class CronParser {
    private static final CronFieldExpander WILDCARD_EXPANDER = new CronFieldWildcardExpander();
    private static final CronFieldExpander RANGE_EXPANDER = new CronFieldRangeExpander();
    private static final CronFieldExpander STEP_EXPANDER = new CronFieldStepExpander();
    private static final CronFieldExpander INDIVIDUAL_EXPANDER = new CronFieldIndividualExpander();

    public void parseAndPrintCronString(String cronString) {
        String[] parts = cronString.split(" ", 6);
        if (parts.length != 6) {
            throw new IllegalArgumentException("Invalid cron string format.");
        }

        String minutePart = parts[0];
        String hourPart = parts[1];
        String dayOfMonthPart = parts[2];
        String monthPart = parts[3];
        String dayOfWeekPart = parts[4];
        String command = parts[5];

        printTable(MINUTE, expandField(new Minute(minutePart)));
        printTable(HOUR, expandField(new Hour(hourPart)));
        printTable(DAY_OF_MONTH, expandField(new DaysOfMonth(dayOfMonthPart)));
        printTable(MONTH, expandField(new Month(monthPart)));
        printTable(DAY_OF_WEEK, expandField(new DaysOfWeek(dayOfWeekPart)));
        printTable(COMMAND, command);
    }

    private List<String> expandField(Base segment) {
        CronFieldExpander expander;

        if (segment.getSegment().equals(WILDCARD)) {
            expander = WILDCARD_EXPANDER;
        } else if (segment.getSegment().contains(STEP)) {
            expander = STEP_EXPANDER;
        } else if (segment.getSegment().contains(COMMA)) {
            expander = INDIVIDUAL_EXPANDER;
        } else if (segment.getSegment().contains(RANGE)) {
            expander = RANGE_EXPANDER;
        } else {
            expander = INDIVIDUAL_EXPANDER;
        }

        return expander.expandField(segment.getSegment(), segment.getMinimumValue(), segment.getMaximumValue());
    }
}
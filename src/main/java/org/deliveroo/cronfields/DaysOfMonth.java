package org.deliveroo.cronfields;

import static org.deliveroo.constants.Columns.DAY_OF_MONTH;

/**
 * Represents the "day of month" field in a cron expression, ranging from 1 to 31.
 */
public class DaysOfMonth extends CronField {
    /**
     * Initializes a {@code DaysOfMonth} with the given segment.
     * Sets the valid range to 1-31 and the segment identity to {@code DAY_OF_MONTH}.
     *
     * @param segment the cron segment for days of the month
     */
    public DaysOfMonth(String segment) {
        super();
        this.minimumValue = 1; // Days of month are from 1 to 31
        this.maximumValue = 31;
        this.segment = segment;
        this.segmentIdentity = DAY_OF_MONTH;
    }
}

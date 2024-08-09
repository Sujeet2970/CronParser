package org.deliveroo.cronfields;

import static org.deliveroo.constants.Columns.DAYS_OF_WEEK;

/**
 * Represents the "day of week" field in a cron expression, ranging from 0 (Sunday) to 6 (Saturday).
 */
public class DaysOfWeek extends CronField {
    /**
     * Constructs a {@code DaysOfWeek} with the specified segment.
     * Sets the valid range to 0-6 and the segment identity to {@code DAYS_OF_WEEK}.
     *
     * @param segment the cron segment for days of the week
     */
    public DaysOfWeek(String segment) {
        super();
        this.minimumValue = 0; // Days of week are from 0 (Sunday) to 6 (Saturday)
        this.maximumValue = 6;
        this.segment = segment;
        this.segmentIdentity = DAYS_OF_WEEK;
    }
}

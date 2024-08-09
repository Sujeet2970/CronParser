package org.deliveroo.cronfields;

import static org.deliveroo.constants.Columns.MONTH;

/**
 * Represents the "month" field in a cron expression, ranging from 1 to 12.
 */
public class Month extends CronField {
    /**
     * Constructs a {@code Month} object with the specified segment.
     * Sets the valid range to 1-12 and the segment identity to {@code MONTH}.
     *
     * @param segment the cron segment for months
     */
    public Month(String segment) {
        super();
        this.minimumValue = 1; // Months are from 1 to 12
        this.maximumValue = 12;
        this.segment = segment;
        this.segmentIdentity = MONTH;
    }
}

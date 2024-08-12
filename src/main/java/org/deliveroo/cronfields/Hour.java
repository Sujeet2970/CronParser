package org.deliveroo.cronfields;

import static org.deliveroo.constants.Columns.HOUR;

/**
 * Represents the "hour" field in a cron expression, ranging from 0 to 23.
 */
public class Hour extends CronField {
    /**
     * Constructs an {@code Hour} object with the specified fieldExpression.
     * Sets the valid range to 0-23 and the field identity to {@code HOUR}.
     *
     * @param fieldExpression the cron fieldExpression for hours
     */
    public Hour(String fieldExpression) {
        super();
        this.minimumValue = 0; // Hours are from 0 to 23
        this.maximumValue = 23;
        this.fieldExpression = fieldExpression;
        this.fieldIdentity = HOUR;
    }
}

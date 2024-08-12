package org.deliveroo.cronfields;

import static org.deliveroo.constants.Columns.MINUTE;

/**
 * Represents the "minute" field in a cron expression, ranging from 0 to 59.
 */
public class Minute extends CronField {
    /**
     * Constructs a {@code Minute} object with the specified fieldExpression.
     * Sets the valid range to 0-59 and the field identity to {@code MINUTE}.
     *
     * @param fieldExpression the cron fieldExpression for minutes
     */
    public Minute(String fieldExpression) {
        super();
        this.minimumValue = 0; // Minutes are from 0 to 59
        this.maximumValue = 59;
        this.fieldExpression = fieldExpression;
        this.fieldIdentity = MINUTE;
    }
}

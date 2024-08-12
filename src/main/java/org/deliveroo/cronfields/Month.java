package org.deliveroo.cronfields;

import static org.deliveroo.constants.Columns.MONTH;

/**
 * Represents the "month" field in a cron expression, ranging from 1 to 12.
 */
public class Month extends CronField {
    /**
     * Constructs a {@code Month} object with the specified fieldExpression.
     * Sets the valid range to 1-12 and the field identity to {@code MONTH}.
     *
     * @param fieldExpression the cron fieldExpression for months
     */
    public Month(String fieldExpression) {
        super();
        this.minimumValue = 1; // Months are from 1 to 12
        this.maximumValue = 12;
        this.fieldExpression = fieldExpression;
        this.fieldIdentity = MONTH;
    }
}

package org.deliveroo.cronfields;

import static org.deliveroo.constants.Columns.DAY_OF_MONTH;

/**
 * Represents the "day of month" field in a cron expression, ranging from 1 to 31.
 */
public class DaysOfMonth extends CronField {
    /**
     * Initializes a {@code DaysOfMonth} with the given fieldExpression.
     * Sets the valid range to 1-31 and the field identity to {@code DAY_OF_MONTH}.
     *
     * @param fieldExpression the cron fieldExpression for days of the month
     */
    public DaysOfMonth(String fieldExpression) {
        super();
        this.minimumValue = 1; // Days of month are from 1 to 31
        this.maximumValue = 31;
        this.fieldExpression = fieldExpression;
        this.fieldIdentity = DAY_OF_MONTH;
    }
}

package org.deliveroo.cronfields;

import static org.deliveroo.constants.Columns.DAYS_OF_WEEK;

/**
 * Represents the "day of week" field in a cron expression, ranging from 0 (Sunday) to 6 (Saturday).
 */
public class DaysOfWeek extends CronField {
    /**
     * Constructs a {@code DaysOfWeek} with the specified fieldExpression.
     * Sets the valid range to 0-6 and the field identity to {@code DAYS_OF_WEEK}.
     *
     * @param fieldExpression the cron fieldExpression for days of the week
     */
    public DaysOfWeek(String fieldExpression) {
        super();
        this.minimumValue = 0; // Days of week are from 0 (Sunday) to 6 (Saturday)
        this.maximumValue = 6;
        this.fieldExpression = fieldExpression;
        this.fieldIdentity = DAYS_OF_WEEK;
    }
}

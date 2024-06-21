package org.deliveroo.cronfields;

import static org.deliveroo.constants.Columns.DAYS_OF_WEEK;

public class DaysOfWeek extends CronField {
    public DaysOfWeek(String segment) {
        super();
        this.minimumValue = 1; // Days of week are from 1 (Monday) to 7 (Sunday)
        this.maximumValue = 7;
        this.segment = segment;
        this.segmentIdentity = DAYS_OF_WEEK;
    }
}

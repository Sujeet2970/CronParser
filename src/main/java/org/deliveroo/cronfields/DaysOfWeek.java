package org.deliveroo.cronfields;

import static org.deliveroo.constants.Columns.DAYS_OF_WEEK;

public class DaysOfWeek extends CronField {
    public DaysOfWeek(String segment) {
        super();
        this.minimumValue = 0; // Days of week are from 0 (Sunday) to 6 (Saturday)
        this.maximumValue = 6;
        this.segment = segment;
        this.segmentIdentity = DAYS_OF_WEEK;
    }
}

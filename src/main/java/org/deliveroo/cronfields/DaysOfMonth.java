package org.deliveroo.cronfields;

import static org.deliveroo.constants.Columns.DAY_OF_MONTH;

public class DaysOfMonth extends CronField {
    public DaysOfMonth(String segment) {
        super();
        this.minimumValue = 1; // Days of month are from 1 to 31
        this.maximumValue = 31;
        this.segment = segment;
        this.segmentIdentity = DAY_OF_MONTH;
    }
}

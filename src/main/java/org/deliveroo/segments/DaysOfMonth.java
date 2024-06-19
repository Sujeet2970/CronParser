package org.deliveroo.segments;

import static org.deliveroo.constants.Columns.DAY_OF_MONTH;

public class DaysOfMonth extends Base {
    public DaysOfMonth(String segment) {
        super();
        this.minimumValue = 0; // Days of month are from 1 to 31
        this.maximumValue = 31;
        this.segment = segment;
        this.segmentIdentity = DAY_OF_MONTH;
    }
}

package org.deliveroo.cronfields;

import static org.deliveroo.constants.Columns.YEAR;

public class Year extends CronField {
    public Year(String segment) {
        super();
        this.minimumValue = 2000; // Months are from 1 to 12
        this.maximumValue = 2100;
        this.segment = segment;
        this.segmentIdentity = YEAR;
    }
}

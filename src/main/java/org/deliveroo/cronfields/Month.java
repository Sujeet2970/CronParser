package org.deliveroo.cronfields;

import static org.deliveroo.constants.Columns.MONTH;

public class Month extends CronField {
    public Month(String segment) {
        super();
        this.minimumValue = 1; // Months are from 1 to 12
        this.maximumValue = 12;
        this.segment = segment;
        this.segmentIdentity = MONTH;
    }
}

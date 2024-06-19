package org.deliveroo.segments;

import static org.deliveroo.constants.Columns.MONTH;

public class Month extends Base {
    public Month(String segment) {
        super();
        this.minimumValue = 1; // Months are from 1 to 12
        this.maximumValue = 12;
        this.segment = segment;
        this.segmentIdentity = MONTH;
    }
}

package org.deliveroo.segments;

import static org.deliveroo.constants.Columns.MINUTE;

public class Minute extends Base {
    public Minute(String segment) {
        super();
        this.minimumValue = 0; // Minutes are from 0 to 59
        this.maximumValue = 59;
        this.segment = segment;
        this.segmentIdentity = MINUTE;
    }
}

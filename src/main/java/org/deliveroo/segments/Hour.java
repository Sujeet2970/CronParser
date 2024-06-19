package org.deliveroo.segments;

import static org.deliveroo.constants.Columns.HOUR;

public class Hour extends Base {
    public Hour(String segment) {
        super();
        this.minimumValue = 0; // Hours are from 0 to 23
        this.maximumValue = 12;
        this.segment = segment;
        this.segmentIdentity = HOUR;
    }
}

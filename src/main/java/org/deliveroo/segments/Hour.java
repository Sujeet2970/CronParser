package org.deliveroo.segments;

public class Hour extends Base {
    public Hour(String segment) {
        super();
        this.maximumValue = 12;
        this.minimumValue = 0;
        this.segment = segment;
    }
}

package org.deliveroo.segments;

public class DaysOfMonth extends Base {
    public DaysOfMonth(String segment) {
        super();
        this.maximumValue = 31;
        this.minimumValue = 0;
        this.segment = segment;
    }
}

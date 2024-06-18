package org.deliveroo.segments;

public class DaysOfMonth extends Base {
    public DaysOfMonth(String segment) {
        super();
        this.minimumValue = 0; // Days of month are from 1 to 31
        this.maximumValue = 31;
        this.segment = segment;
    }
}

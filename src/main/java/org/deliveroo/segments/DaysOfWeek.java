package org.deliveroo.segments;

public class DaysOfWeek extends Base {
    public DaysOfWeek(String segment) {
        super();
        this.minimumValue = 1; // Days of week are from 1 (Monday) to 7 (Sunday)
        this.maximumValue = 7;
        this.segment = segment;
    }
}

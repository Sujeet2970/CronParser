package org.deliveroo.segments;

public class Minute extends Base {
    public Minute(String segment) {
        super();
        this.maximumValue = 59;
        this.minimumValue = 0;
        this.segment = segment;
    }
}

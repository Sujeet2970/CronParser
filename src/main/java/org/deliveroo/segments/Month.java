package org.deliveroo.segments;

public class Month extends Base {
    public Month(String segment) {
        super();
        this.maximumValue = 12;
        this.minimumValue = 0;
        this.segment = segment;
    }
}

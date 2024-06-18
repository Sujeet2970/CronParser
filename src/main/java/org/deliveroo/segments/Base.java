package org.deliveroo.segments;

import lombok.Getter;

@Getter
public abstract class Base {
    protected Integer minimumValue;
    protected Integer maximumValue;
    protected String segment;
}

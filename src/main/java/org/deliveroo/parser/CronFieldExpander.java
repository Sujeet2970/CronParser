package org.deliveroo.parser;

import org.deliveroo.segments.Base;

import java.util.List;

public abstract class CronFieldExpander {
    public List<String> expandField(Base base) {
        throw new UnsupportedOperationException("This method should be overridden in subclass");
    }
}

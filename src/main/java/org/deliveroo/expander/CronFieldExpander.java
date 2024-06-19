package org.deliveroo.expander;

import org.deliveroo.segments.Base;

import java.util.List;

public abstract class CronFieldExpander {
    public List<String> expandField(Base base) {
        throw new UnsupportedOperationException("This method should be overridden in subclass");
    }
}

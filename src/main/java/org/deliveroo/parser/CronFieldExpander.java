package org.deliveroo.parser;

import java.util.List;

public abstract class CronFieldExpander {
    public List<String> expandField(String field, Integer min, Integer max) {
        throw new UnsupportedOperationException("This method should be overridden in subclass");
    }
}

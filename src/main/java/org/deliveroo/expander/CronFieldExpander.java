package org.deliveroo.expander;

import org.deliveroo.cronfields.CronField;

import java.util.List;

public abstract class CronFieldExpander {
    public List<String> expandField(CronField cronField) {
        throw new UnsupportedOperationException("This method should be overridden in subclass");
    }
}

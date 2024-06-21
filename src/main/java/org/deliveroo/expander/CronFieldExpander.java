package org.deliveroo.expander;

import org.deliveroo.cronfields.CronField;

import java.util.List;

/**
 * An abstract class that provides a method to expand cron fields.
 * Subclasses should override the {@link #expandField(CronField)} method to provide specific
 * expansion logic for different types of cron fields.
 */
public abstract class CronFieldExpander {
    /**
     * Expands a given cron field into a list of string representations.
     *
     * @param cronField the {@link CronField} to be expanded
     * @return a list of string representations of the expanded cron field
     * @throws UnsupportedOperationException if the method is not overridden in a subclass
     */
    public List<String> expandField(CronField cronField) {
        throw new UnsupportedOperationException("This method should be overridden in subclass");
    }
}

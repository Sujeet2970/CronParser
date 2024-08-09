package org.deliveroo.expander;

import org.deliveroo.cronfields.CronField;

import java.util.List;

/**
 * Abstract base class for expanding cron fields.
 * Subclasses must override the {@link #expandField(CronField)} method to provide
 * specific expansion logic for different cron field types.
 */
public abstract class CronFieldExpander {
    /**
     * Expands the given cron field into a list of integer values.
     * This method should be implemented by subclasses to define specific expansion logic.
     *
     * @param cronField the {@link CronField} to expand
     * @return a list of integers representing the expanded cron field
     * @throws UnsupportedOperationException if not overridden in a subclass
     */
    public List<Integer> expandField(CronField cronField) {
        throw new UnsupportedOperationException("This method should be overridden in subclass");
    }
}

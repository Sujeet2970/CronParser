package org.deliveroo.expander;

import org.deliveroo.exception.OutOfRangeException;
import org.deliveroo.cronfields.CronField;

import java.util.*;

/**
 * Expands individual cron field segments into a list of integer values.
 * Handles single values by validating them against the field's allowed range.
 */
public class CronFieldIndividualExpander extends CronFieldExpander {

    /**
     * Expands a cron field segment into a list containing a single integer value.
     * Validates the value against the specified range.
     *
     * @param cronField the cron field to expand
     * @return a list containing the expanded integer value
     * @throws OutOfRangeException if the value is out of the allowed range
     */
    @Override
    public List<Integer> expandField(CronField cronField, String segment) {
        int number = Integer.parseInt(segment);
        if(number <= cronField.getMaximumValue() && number >= cronField.getMinimumValue()) {
            List<Integer> array = new ArrayList<>();
            array.add(number);

            return array;
        } else {
            throw new OutOfRangeException(cronField.getFieldIdentity(), number);
        }
    }
}

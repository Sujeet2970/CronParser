package org.deliveroo.expander;

import org.deliveroo.exception.OutOfRangeException;
import org.deliveroo.cronfields.CronField;

import java.util.ArrayList;
import java.util.List;

import static org.deliveroo.util.ValidateValue.isValueInRange;

/**
 * Expands cron fields containing wildcard values, generating a list of all possible
 * values within the specified range.
 * <p>
 * This class extends {@link CronFieldExpander} and implements the {@code expandField}
 * method to handle wildcard expansions, producing every valid value in the cron field's range.
 * </p>
 */
public class CronFieldWildcardExpander extends CronFieldExpander {
    /**
     * Expands a cron field segment containing a wildcard into a list of all possible values
     * within the specified range.
     * <p>
     * Iterates over the range defined by the cron field and validates each value before adding
     * it to the result list. Throws an {@link OutOfRangeException} if any value is outside the allowed range.
     * </p>
     *
     * @param cronField the cron field to expand
     * @return a list of integers representing all possible values within the cron field's range
     * @throws OutOfRangeException if any value is out of the valid range specified by the cron field
     */
    @Override
    public List<Integer> expandField(CronField cronField, String segment) {
        List<Integer> result = new ArrayList<>();

        for (int value = cronField.getMinimumValue(); value <= cronField.getMaximumValue(); value++) {
            if(!isValueInRange(value, cronField.getMinimumValue(), cronField.getMaximumValue())) {
                throw new OutOfRangeException(cronField.getFieldIdentity(), value);
            }

            result.add(value);
        }

        return result;
    }
}

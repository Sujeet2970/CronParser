package org.deliveroo.expander;

import org.deliveroo.exception.OutOfRangeException;
import org.deliveroo.cronfields.CronField;

import java.util.ArrayList;
import java.util.List;

import static org.deliveroo.util.ValidateValue.isValueInRange;

/**
 * The {@code CronFieldWildcardExpander} class is responsible for expanding cron fields
 * that contain wildcard values. It generates a list of all possible values within the
 * specified range for the given cron field.
 *
 * <p>This class extends the {@link CronFieldExpander} and provides an implementation
 * for the {@code expandField} method to handle wildcard expansion.
 *
 * <p>Example usage:
 * <pre>
 *     CronField cronField = new CronField("minute", 0, 59);
 *     CronFieldWildcardExpander expander = new CronFieldWildcardExpander();
 *     List&lt;String&gt; expandedValues = expander.expandField(cronField);
 * </pre>
 *
 * @see CronFieldExpander
 * @see CronField
 */
public class CronFieldWildcardExpander extends CronFieldExpander {
    /**
     * Expands the given cron field containing a wildcard into a list of all possible values
     * within the specified range.
     *
     * @param cronField the cron field to be expanded
     * @return a list of strings representing all possible values for the given cron field
     * @throws OutOfRangeException if any value is out of the valid range specified by the cron field
     */
    @Override
    public List<String> expandField(CronField cronField) {
        List<String> result = new ArrayList<>();

        for (int value = cronField.getMinimumValue(); value <= cronField.getMaximumValue(); value++) {
            if(!isValueInRange(value, cronField.getMinimumValue(), cronField.getMaximumValue())) {
                throw new OutOfRangeException(cronField.getSegmentIdentity(), value);
            }

            result.add(String.valueOf(value));
        }

        return result;
    }
}

package org.deliveroo.expander;

import org.deliveroo.exception.OutOfRangeException;
import org.deliveroo.cronfields.CronField;

import java.util.ArrayList;
import java.util.List;

import static org.deliveroo.constants.Separator.RANGE;
import static org.deliveroo.constants.Separator.STEP;
import static org.deliveroo.constants.Separator.WILDCARD;
import static org.deliveroo.util.ValidateValue.isValueInRange;

/**
 * Expands cron field segments that include step values.
 * <p>
 * This class is responsible for expanding cron expressions with step values,
 * such as "1-10/2", which means "every 2 units between 1 and 10".
 * </p>
 */
public class CronFieldStepExpander extends CronFieldExpander {
    /**
     * Expands the cron field segment with step values.
     * <p>
     * The method parses the step value, expands the range according to the step,
     * and returns a list of all valid values within the range, incremented by the step.
     * </p>
     *
     * @param cronField the cron field containing the segment to expand
     * @return a list of expanded values as strings
     * @throws NumberFormatException if the step value or range values are not valid integers
     * @throws OutOfRangeException if any value in the expanded list is out of the allowed range
     */
    @Override
    public List<String> expandField(CronField cronField) {
        List<String> result = new ArrayList<>();

        String[] parts = cronField.getSegment().split(STEP);
        int step = Integer.parseInt(parts[1]);
        String range = parts[0];
        int rangeStart = range.equals(WILDCARD) ? cronField.getMinimumValue() : Integer.parseInt(range.split(RANGE)[0]);
        int rangeEnd = range.equals(WILDCARD) ? cronField.getMaximumValue() : Integer.parseInt(range.split(RANGE)[1]);

        for (int value = rangeStart; value <= rangeEnd; value += step) {
            if(!isValueInRange(value, cronField.getMinimumValue(), cronField.getMaximumValue())) {
                throw new OutOfRangeException(cronField.getSegmentIdentity(), value);
            }

            result.add(String.valueOf(value));
        }

        return result;
    }
}

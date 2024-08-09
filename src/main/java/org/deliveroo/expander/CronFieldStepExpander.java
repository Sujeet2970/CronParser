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
 * Handles cron expressions like "1-10/2", expanding them to include all valid
 * values within the specified range, incremented by the step value.
 * </p>
 */
public class CronFieldStepExpander extends CronFieldExpander {
    /**
     * Expands a cron field segment that includes a step value.
     * <p>
     * Parses the segment to extract the step value and the range. Expands the
     * range by incrementing with the step value and returns the resulting list
     * of integers. Validates each value to ensure it falls within the allowed
     * range for the cron field.
     * </p>
     *
     * @param cronField the cron field containing the segment to expand
     * @return a list of expanded integer values
     * @throws NumberFormatException if the step value or range values are not valid integers
     * @throws OutOfRangeException if any value in the expanded list is out of the allowed range
     */
    @Override
    public List<Integer> expandField(CronField cronField) {
        List<Integer> result = new ArrayList<>();

        String[] parts = cronField.getSegment().split(STEP);
        int step = Integer.parseInt(parts[1]);
        String range = parts[0];
        int rangeStart = range.equals(WILDCARD) ? cronField.getMinimumValue() : Integer.parseInt(range.split(RANGE)[0]);
        int rangeEnd = range.equals(WILDCARD) ? cronField.getMaximumValue() : Integer.parseInt(range.split(RANGE)[1]);

        for (int value = rangeStart; value <= rangeEnd; value += step) {
            if(!isValueInRange(value, cronField.getMinimumValue(), cronField.getMaximumValue())) {
                throw new OutOfRangeException(cronField.getSegmentIdentity(), value);
            }

            result.add(value);
        }

        return result;
    }
}

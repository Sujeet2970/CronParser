package org.deliveroo.expander;

import org.deliveroo.exception.InvalidInputException;
import org.deliveroo.exception.OutOfRangeException;
import org.deliveroo.cronfields.CronField;

import java.util.ArrayList;
import java.util.List;

import static org.deliveroo.constants.Separator.RANGE;
import static org.deliveroo.util.ValidateValue.isValueInRange;

/**
 * Expands cron field segments that define a range of values.
 * Parses the range, validates each value within the specified range,
 * and returns the expanded list of integers.
 */
public class CronFieldRangeExpander extends CronFieldExpander {

    private static final int START_VALUE_INDEX = 0;
    private static final int END_VALUE_INDEX = 1;

    /**
     * Expands a cron field segment that specifies a range into a list of integer values.
     * The method splits the segment by the range separator, validates each value,
     * and adds them to the result list. Throws an {@link OutOfRangeException} if any value
     * is outside the allowed range for the cron field.
     *
     * @param cronField the cron field to expand
     * @return a list of integers representing the expanded range
     * @throws OutOfRangeException if any value is out of the allowed range
     */
    @Override
    public List<Integer> expandField(CronField cronField, String segment) {
        List<Integer> result = new ArrayList<>();
        String[] range = segment.split(RANGE);
        int startValue = Integer.parseInt(range[START_VALUE_INDEX]);
        int endValue = Integer.parseInt(range[END_VALUE_INDEX]);

        if(endValue < startValue) {
            throw new InvalidInputException(cronField.getFieldExpression(), cronField.getFieldIdentity());
        }

        for (int value = startValue; value <= endValue; value++) {
            if(!isValueInRange(value, cronField.getMinimumValue(), cronField.getMaximumValue())) {
                throw new OutOfRangeException(cronField.getFieldIdentity(), value);
            }

            result.add(value);
        }

        return result;
    }
}

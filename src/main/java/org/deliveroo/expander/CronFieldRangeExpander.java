package org.deliveroo.expander;

import org.deliveroo.exception.OutOfRangeException;
import org.deliveroo.cronfields.CronField;

import java.util.ArrayList;
import java.util.List;

import static org.deliveroo.constants.Separator.RANGE;
import static org.deliveroo.util.ValidateValue.isValueInRange;

/**
 * This class is responsible for expanding cron field ranges into a list of individual values.
 * It extends the {@link CronFieldExpander} class and provides the implementation for expanding ranges.
 */
public class CronFieldRangeExpander extends CronFieldExpander {

    private static final int START_VALUE_INDEX = 0;
    private static final int END_VALUE_INDEX = 1;

    /**
     * Expands the given {@link CronField} if it represents a range of values.
     * For example, the cron field "1-5" would be expanded to ["1", "2", "3", "4", "5"].
     *
     * @param cronField the {@link CronField} to expand.
     * @return a list of strings representing the expanded values.
     * @throws NumberFormatException if the range values cannot be parsed as integers.
     * @throws OutOfRangeException if any value in the range is out of the allowed range for the cron field.
     */
    @Override
    public List<String> expandField(CronField cronField) {
        List<String> result = new ArrayList<>();
        String[] range = cronField.getSegment().split(RANGE);
        int startValue = Integer.parseInt(range[START_VALUE_INDEX]);
        int endValue = Integer.parseInt(range[END_VALUE_INDEX]);

        for (int value = startValue; value <= endValue; value++) {
            if(!isValueInRange(value, cronField.getMinimumValue(), cronField.getMaximumValue())) {
                throw new OutOfRangeException(cronField.getSegmentIdentity(), value);
            }

            result.add(String.valueOf(value));
        }

        return result;
    }
}

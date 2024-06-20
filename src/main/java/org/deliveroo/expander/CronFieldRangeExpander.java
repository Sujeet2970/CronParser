package org.deliveroo.expander;

import org.deliveroo.exception.OutOfRangeException;
import org.deliveroo.cronfields.CronField;

import java.util.ArrayList;
import java.util.List;

import static org.deliveroo.constants.Separator.RANGE;
import static org.deliveroo.util.ValidateValue.isValueInRange;

public class CronFieldRangeExpander extends CronFieldExpander {

    private static final int START_VALUE_INDEX = 0;
    private static final int END_VALUE_INDEX = 1;

    @Override
    public List<String> expandField(CronField cronField) {
        List<String> result = new ArrayList<>();
        String[] range = cronField.getSegment().split(RANGE);
        int startValue = Integer.parseInt(range[START_VALUE_INDEX]);
        int endValue = Integer.parseInt(range[END_VALUE_INDEX]);

        if(startValue < endValue ) {
            getAllPossibleValues(cronField, startValue, endValue, result);
        } else {
            getAllPossibleValues(cronField, startValue, cronField.getMaximumValue(), result);
            getAllPossibleValues(cronField, cronField.getMinimumValue(), endValue, result);
        }

        return result;
    }

    private static void getAllPossibleValues(CronField cronField, int startValue, int endValue, List<String> result) {
        for (int value = startValue; value <= endValue; value++) {
            if(!isValueInRange(value, cronField.getMinimumValue(), cronField.getMaximumValue())) {
                throw new OutOfRangeException(cronField.getSegmentIdentity(), value);
            }

            result.add(String.valueOf(value));
        }
    }
}

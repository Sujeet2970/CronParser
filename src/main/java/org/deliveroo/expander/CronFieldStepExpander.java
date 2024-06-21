package org.deliveroo.expander;

import org.deliveroo.exception.OutOfRangeException;
import org.deliveroo.cronfields.CronField;

import java.util.ArrayList;
import java.util.List;

import static org.deliveroo.constants.Separator.RANGE;
import static org.deliveroo.constants.Separator.STEP;
import static org.deliveroo.constants.Separator.WILDCARD;
import static org.deliveroo.util.ValidateValue.isValueInRange;

public class CronFieldStepExpander extends CronFieldExpander {
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

package org.deliveroo.expander;

import org.deliveroo.exception.OutOfRangeException;
import org.deliveroo.segments.Base;

import java.util.ArrayList;
import java.util.List;

import static org.deliveroo.constants.Separator.*;
import static org.deliveroo.util.ValidateValue.isValueInRange;

public class CronFieldStepExpander extends CronFieldExpander {
    @Override
    public List<String> expandField(Base base) {
        List<String> result = new ArrayList<>();

        String[] parts = base.getSegment().split(STEP);
        int step = Integer.parseInt(parts[1]);
        String range = parts[0];
        int rangeStart = range.equals(WILDCARD) ? base.getMinimumValue() : Integer.parseInt(range.split(RANGE)[0]);
        int rangeEnd = range.equals(WILDCARD) ? base.getMaximumValue() : Integer.parseInt(range.split(RANGE)[1]);

        for (int value = rangeStart; value <= rangeEnd; value += step) {
            if(!isValueInRange(value, base.getMinimumValue(), base.getMaximumValue())) {
                throw new OutOfRangeException(base.getSegmentIdentity(), value);
            }
            result.add(String.valueOf(value));
        }

        return result;
    }
}

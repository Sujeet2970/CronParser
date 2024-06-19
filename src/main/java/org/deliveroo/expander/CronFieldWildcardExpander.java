package org.deliveroo.expander;

import org.deliveroo.exception.OutOfRangeException;
import org.deliveroo.segments.Base;

import java.util.ArrayList;
import java.util.List;

import static org.deliveroo.util.ValidateValue.isValueInRange;

public class CronFieldWildcardExpander extends CronFieldExpander {
    @Override
    public List<String> expandField(Base base) {
        List<String> result = new ArrayList<>();

        for (int value = base.getMinimumValue(); value <= base.getMaximumValue(); value++) {
            if(!isValueInRange(value, base.getMinimumValue(), base.getMaximumValue())) {
                throw new OutOfRangeException(base.getSegmentIdentity(), value);
            }
            result.add(String.valueOf(value));
        }

        return result;
    }
}

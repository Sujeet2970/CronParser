package org.deliveroo.expander;

import org.deliveroo.exception.OutOfRangeException;
import org.deliveroo.cronfields.CronField;

import java.util.ArrayList;
import java.util.List;

import static org.deliveroo.util.ValidateValue.isValueInRange;

public class CronFieldWildcardExpander extends CronFieldExpander {
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

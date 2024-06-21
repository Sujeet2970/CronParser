package org.deliveroo.expander;

import org.deliveroo.exception.OutOfRangeException;
import org.deliveroo.cronfields.CronField;

import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.stream.Collectors;

import static org.deliveroo.constants.Separator.COMMA;
import static org.deliveroo.constants.Separator.RANGE;
import static org.deliveroo.util.ValidateValue.isValueInRange;

public class CronFieldIndividualExpander extends CronFieldExpander {
    @Override
    public List<String> expandField(CronField cronField) {
        Set<Integer> result = new HashSet<>();

        String[] parts = cronField.getSegment().split(COMMA);
        for(String part : parts) {
            if(part.contains(RANGE)) {
                int rangeStart = Integer.parseInt(part.split(RANGE)[0]);
                int rangeEnd = Integer.parseInt(part.split(RANGE)[1]);

                for(int value = rangeStart; value <= rangeEnd; value++) {
                    if(!isValueInRange(value, cronField.getMinimumValue(), cronField.getMaximumValue())) {
                        throw new OutOfRangeException(cronField.getSegmentIdentity(), value);
                    }

                    result.add(value);
                }
            } else {
                if(!isValueInRange(Integer.parseInt(part), cronField.getMinimumValue(), cronField.getMaximumValue())) {
                    throw new OutOfRangeException(cronField.getSegmentIdentity(), Integer.parseInt(part));
                }

                result.add(Integer.parseInt(part));
            }
        }

        return result.stream().map(String::valueOf).collect(Collectors.toList());
    }
}

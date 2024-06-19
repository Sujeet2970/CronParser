package org.deliveroo.expander;

import org.deliveroo.exception.OutOfRangeException;
import org.deliveroo.segments.Base;

import java.util.*;
import java.util.stream.Collectors;

import static org.deliveroo.constants.Separator.*;
import static org.deliveroo.constants.Separator.RANGE;
import static org.deliveroo.util.ValidateValue.isValueInRange;

public class CronFieldIndividualExpander extends CronFieldExpander {
    @Override
    public List<String> expandField(Base base) {
        Set<Integer> result = new HashSet<>();

        String[] parts = base.getSegment().split(COMMA);
        for(String part : parts) {
            if(part.contains(RANGE)) {
                int rangeStart = Integer.parseInt(part.split(RANGE)[0]);
                int rangeEnd = Integer.parseInt(part.split(RANGE)[1]);

                for(int value = rangeStart; value <= rangeEnd; value++) {
                    if(!isValueInRange(value, base.getMinimumValue(), base.getMaximumValue())) {
                        throw new OutOfRangeException(base.getSegmentIdentity(), value);
                    }
                    result.add(value);
                }
            } else {
                if(!isValueInRange(Integer.parseInt(part), base.getMinimumValue(), base.getMaximumValue())) {
                    throw new OutOfRangeException(base.getSegmentIdentity(), Integer.parseInt(part));
                }
                result.add(Integer.parseInt(part));
            }
        }

        return result.stream().map(String::valueOf).collect(Collectors.toList());
    }
}

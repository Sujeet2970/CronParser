package org.deliveroo.expander;

import org.deliveroo.segments.Base;

import java.util.*;
import java.util.stream.Collectors;

import static org.deliveroo.constants.Separator.*;
import static org.deliveroo.constants.Separator.RANGE;

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
                    result.add(value);
                }
            } else {
                result.add(Integer.parseInt(part));
            }
        }

        return result.stream().map(String::valueOf).collect(Collectors.toList());
    }
}

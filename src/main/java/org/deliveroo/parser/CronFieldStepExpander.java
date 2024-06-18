package org.deliveroo.parser;

import org.deliveroo.segments.Base;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.deliveroo.constants.Separator.*;

@Singleton
public class CronFieldStepExpander extends CronFieldExpander {
    @Override
    public List<String> expandField(Base base) {
        List<String> result;

        String[] parts = base.getSegment().split(STEP);
        int step = Integer.parseInt(parts[1]);
        String range = parts[0];
        int rangeStart = range.equals(WILDCARD) ? base.getMinimumValue() : Integer.parseInt(range.split(RANGE)[0]);
        int rangeEnd = range.equals(WILDCARD) ? base.getMaximumValue() : Integer.parseInt(range.split(RANGE)[1]);

        result = IntStream.iterate(rangeStart, i -> i <= rangeEnd, i -> i + step)
                .mapToObj(String::valueOf)
                .collect(Collectors.toList());

        return result;
    }
}

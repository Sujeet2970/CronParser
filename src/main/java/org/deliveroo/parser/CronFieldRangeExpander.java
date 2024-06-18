package org.deliveroo.parser;

import org.deliveroo.segments.Base;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.deliveroo.constants.Separator.RANGE;

@Singleton
public class CronFieldRangeExpander extends CronFieldExpander {
    @Override
    public List<String> expandField(Base base) {
        List<String> result;
        String[] range = base.getSegment().split(RANGE);
        int startValue = Integer.parseInt(range[0]);
        int endValue = Integer.parseInt(range[1]);

        result = IntStream.rangeClosed(startValue, endValue)
                .mapToObj(String::valueOf)
                .collect(Collectors.toList());

        return result;
    }
}

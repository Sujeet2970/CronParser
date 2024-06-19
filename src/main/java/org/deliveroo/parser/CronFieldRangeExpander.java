package org.deliveroo.parser;

import org.deliveroo.segments.Base;

import java.util.ArrayList;
import java.util.List;

import static org.deliveroo.constants.Separator.RANGE;

public class CronFieldRangeExpander extends CronFieldExpander {

    private static final int START_VALUE_INDEX = 0;
    private static final int END_VALUE_INDEX = 1;

    @Override
    public List<String> expandField(Base base) {
        List<String> result = new ArrayList<>();
        String[] range = base.getSegment().split(RANGE);
        int startValue = Integer.parseInt(range[START_VALUE_INDEX]);
        int endValue = Integer.parseInt(range[END_VALUE_INDEX]);

        for (int value = startValue; value <= endValue; value++) {
            result.add(String.valueOf(value));
        }

        return result;
    }
}

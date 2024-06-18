package org.deliveroo.parser;

import java.util.ArrayList;
import java.util.List;

import static org.deliveroo.constants.Separator.RANGE;

public class CronFieldRangeExpander extends CronFieldExpander {
    @Override
    public List<String> expandField(String field, Integer min, Integer max) {
        List<String> result = new ArrayList<>();
        String[] range = field.split(RANGE);
        int start = Integer.parseInt(range[0]);
        int end = Integer.parseInt(range[1]);

        for (int i = start; i <= end; i++) {
            result.add(String.valueOf(i));
        }

        return result;
    }
}

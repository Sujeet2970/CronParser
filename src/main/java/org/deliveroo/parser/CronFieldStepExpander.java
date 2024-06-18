package org.deliveroo.parser;

import java.util.ArrayList;
import java.util.List;

import static org.deliveroo.constants.Separator.*;

public class CronFieldStepExpander extends CronFieldExpander {
    @Override
    public List<String> expandField(String field, Integer min, Integer max) {
        List<String> result = new ArrayList<>();

        String[] parts = field.split(STEP);
        int step = Integer.parseInt(parts[1]);
        String range = parts[0];
        int rangeStart = range.equals(WILDCARD) ? min : Integer.parseInt(range.split(RANGE)[0]);
        int rangeEnd = range.equals(WILDCARD) ? max : Integer.parseInt(range.split(RANGE)[1]);

        for (int i = rangeStart; i <= rangeEnd; i += step) {
            result.add(String.valueOf(i));
        }

        return result;
    }
}

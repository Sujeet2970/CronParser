package org.deliveroo.parser;

import java.util.ArrayList;
import java.util.List;

public class CronFieldWildcardExpander extends CronFieldExpander {
    @Override
    public List<String> expandField(String field, Integer min, Integer max) {
        List<String> result = new ArrayList<>();

        for (int i = min; i <= max; i++) {
            result.add(String.valueOf(i));
        }

        return result;
    }
}

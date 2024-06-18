package org.deliveroo.parser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.deliveroo.constants.Separator.COMMA;

public class CronFieldIndividualExpander extends CronFieldExpander {
    @Override
    public List<String> expandField(String field, Integer min, Integer max) {
        List<String> result = new ArrayList<>();

        String[] values = field.split(COMMA);
        Collections.addAll(result, values);

        return result;
    }
}

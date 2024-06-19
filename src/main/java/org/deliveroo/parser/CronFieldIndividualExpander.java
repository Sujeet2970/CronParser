package org.deliveroo.parser;

import org.deliveroo.segments.Base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.deliveroo.constants.Separator.COMMA;

public class CronFieldIndividualExpander extends CronFieldExpander {
    @Override
    public List<String> expandField(Base base) {
        List<String> result = new ArrayList<>();

        String[] values = base.getSegment().split(COMMA);
        Collections.addAll(result, values);

        return result;
    }
}

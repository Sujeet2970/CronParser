package org.deliveroo.expander;

import org.deliveroo.segments.Base;

import java.util.ArrayList;
import java.util.List;

public class CronFieldWildcardExpander extends CronFieldExpander {
    @Override
    public List<String> expandField(Base base) {
        List<String> result = new ArrayList<>();

        for (int value = base.getMinimumValue(); value <= base.getMaximumValue(); value++) {
            result.add(String.valueOf(value));
        }

        return result;
    }
}

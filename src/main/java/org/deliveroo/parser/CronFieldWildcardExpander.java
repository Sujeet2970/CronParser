package org.deliveroo.parser;

import org.deliveroo.segments.Base;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

@Singleton
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

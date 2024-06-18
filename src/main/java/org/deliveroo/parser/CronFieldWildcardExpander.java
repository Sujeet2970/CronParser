package org.deliveroo.parser;

import org.deliveroo.segments.Base;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CronFieldWildcardExpander extends CronFieldExpander {
    @Override
    public List<String> expandField(Base base) {
        return IntStream.rangeClosed(base.getMinimumValue(), base.getMaximumValue())
                .mapToObj(String::valueOf)
                .collect(Collectors.toList());
    }
}

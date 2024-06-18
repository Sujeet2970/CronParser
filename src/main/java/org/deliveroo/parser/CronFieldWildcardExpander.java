package org.deliveroo.parser;

import com.google.inject.Singleton;
import org.deliveroo.segments.Base;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Singleton
public class CronFieldWildcardExpander extends CronFieldExpander {
    @Override
    public List<String> expandField(Base base) {
        return IntStream.rangeClosed(base.getMinimumValue(), base.getMaximumValue())
                .mapToObj(String::valueOf)
                .collect(Collectors.toList());
    }
}

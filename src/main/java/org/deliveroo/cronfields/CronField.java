package org.deliveroo.cronfields;

import lombok.Getter;
import org.deliveroo.expander.*;

import java.util.*;
import java.util.stream.Collectors;

import static org.deliveroo.constants.Separator.*;

/**
 * Represents an abstract cron field and provides functionality to expand cron expressions
 * into individual values based on the specified segment.
 * <p>
 * The {@code CronField} class determines the appropriate expander to use based on the
 * content of the cron segment, handling wildcards, ranges, steps, and individual values.
 * </p>
 */
@Getter
public abstract class CronField {
    private static final CronFieldExpander WILDCARD_EXPANDER = new CronFieldWildcardExpander();
    private static final CronFieldExpander RANGE_EXPANDER = new CronFieldRangeExpander();
    private static final CronFieldExpander STEP_EXPANDER = new CronFieldStepExpander();
    private static final CronFieldExpander INDIVIDUAL_EXPANDER = new CronFieldIndividualExpander();

    protected String segmentIdentity;
    protected Integer minimumValue;
    protected Integer maximumValue;
    protected String segment;
    /**
     * Expands the cron field segment into a list of individual string values.
     * <p>
     * The method selects the appropriate {@link CronFieldExpander} based on the segment's
     * content. It handles comma-separated segments by expanding each part individually
     * and combines the results into a sorted list of unique values.
     * </p>
     *
     * @return a sorted list of strings representing the expanded cron field values
     */
    public List<String> expandField() {
        CronFieldExpander expander;

        String[] parts = this.getSegment().split(COMMA);
        Set<Integer> results = new HashSet<>();

        for(String part : parts) {
            if (part.equals(WILDCARD)) {
                expander = WILDCARD_EXPANDER;
            } else if (part.contains(STEP)) {
                expander = STEP_EXPANDER;
            }  else if (part.contains(RANGE)) {
                expander = RANGE_EXPANDER;
            } else {
                expander = INDIVIDUAL_EXPANDER;
            }

            this.segment = part;
            results.addAll(expander.expandField(this));
        }

        ArrayList<Integer> arrayList = new ArrayList<>(results);
        Collections.sort(arrayList);

        return arrayList.stream().map(String::valueOf).collect(Collectors.toList());

    }
}

package org.deliveroo.cronfields;

import lombok.Getter;
import org.deliveroo.expander.*;

import java.util.List;

import static org.deliveroo.constants.Separator.*;

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

    public List<String> expandField() {
        CronFieldExpander expander;

        if (this.getSegment().equals(WILDCARD)) {
            expander = WILDCARD_EXPANDER;
        } else if (this.getSegment().contains(STEP)) {
            expander = STEP_EXPANDER;
        } else if (this.getSegment().contains(COMMA)) {
            expander = INDIVIDUAL_EXPANDER;
        } else if (this.getSegment().contains(RANGE)) {
            expander = RANGE_EXPANDER;
        } else {
            expander = INDIVIDUAL_EXPANDER;
        }

        return expander.expandField(this);
    }
}

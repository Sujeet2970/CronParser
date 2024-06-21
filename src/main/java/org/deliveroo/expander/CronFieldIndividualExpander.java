package org.deliveroo.expander;

import org.deliveroo.exception.OutOfRangeException;
import org.deliveroo.cronfields.CronField;

import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.stream.Collectors;

import static org.deliveroo.constants.Separator.COMMA;
import static org.deliveroo.constants.Separator.RANGE;
import static org.deliveroo.util.ValidateValue.isValueInRange;

/**
 * CronFieldIndividualExpander is a class that expands individual cron fields.
 * It extends the CronFieldExpander class and provides functionality to handle
 * ranges and individual values specified in cron expressions.
 *
 * <p>This class handles comma-separated lists and ranges in cron field segments.
 * It validates the values to ensure they are within the allowed range for the
 * specific cron field.</p>
 */
public class CronFieldIndividualExpander extends CronFieldExpander {
    /**
     * Expands the given cron field segment into a list of individual values.
     *
     * <p>The method splits the segment by commas to handle multiple values.
     * It then checks if any of the parts contain a range, and if so, expands the range.
     * Each value is validated to ensure it falls within the specified minimum
     * and maximum values for the cron field. If a value is out of range, an
     * OutOfRangeException is thrown.</p>
     *
     * @param cronField the cron field to expand
     * @return a list of expanded values as strings
     * @throws OutOfRangeException if any value is out of the specified range
     */
    @Override
    public List<String> expandField(CronField cronField) {
        Set<Integer> result = new HashSet<>();

        String[] parts = cronField.getSegment().split(COMMA);
        for(String part : parts) {
            if(part.contains(RANGE)) {
                int rangeStart = Integer.parseInt(part.split(RANGE)[0]);
                int rangeEnd = Integer.parseInt(part.split(RANGE)[1]);

                for(int value = rangeStart; value <= rangeEnd; value++) {
                    if(!isValueInRange(value, cronField.getMinimumValue(), cronField.getMaximumValue())) {
                        throw new OutOfRangeException(cronField.getSegmentIdentity(), value);
                    }

                    result.add(value);
                }
            } else {
                if(!isValueInRange(Integer.parseInt(part), cronField.getMinimumValue(), cronField.getMaximumValue())) {
                    throw new OutOfRangeException(cronField.getSegmentIdentity(), Integer.parseInt(part));
                }

                result.add(Integer.parseInt(part));
            }
        }

        return result.stream().map(String::valueOf).collect(Collectors.toList());
    }
}

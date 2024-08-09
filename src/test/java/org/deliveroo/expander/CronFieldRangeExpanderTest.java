package org.deliveroo.expander;

import org.deliveroo.cronfields.CronField;
import org.deliveroo.cronfields.DaysOfWeek;
import org.deliveroo.exception.OutOfRangeException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CronFieldRangeExpanderTest {
    @Test
    public void sanityTest() {
        CronField daysOfWeekField = new DaysOfWeek("1-4");
        CronFieldRangeExpander expander = new CronFieldRangeExpander();
        List<Integer> expandedResult = expander.expandField(daysOfWeekField);

        assertEquals(4, expandedResult.size());
        assertEquals(Integer.valueOf(1), expandedResult.get(0));
        assertEquals(Integer.valueOf(2), expandedResult.get(1));
        assertEquals(Integer.valueOf(3), expandedResult.get(2));
        assertEquals(Integer.valueOf(4), expandedResult.get(3));
    }

    @Test
    public void testSegmentOutOfRangeException() {
        CronField daysOfWeekField = new DaysOfWeek("25");
        CronFieldIndividualExpander expander = new CronFieldIndividualExpander();

        assertThrows(OutOfRangeException.class, () -> {
            expander.expandField(daysOfWeekField);
        });
    }
}

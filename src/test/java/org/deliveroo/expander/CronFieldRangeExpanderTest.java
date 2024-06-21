package org.deliveroo.expander;

import org.deliveroo.cronfields.CronField;
import org.deliveroo.cronfields.DaysOfWeek;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CronFieldRangeExpanderTest {
    @Test
    public void sanityTest() {
        CronField daysOfWeekField = new DaysOfWeek("1-4");
        CronFieldRangeExpander expander = new CronFieldRangeExpander();
        List<String> expandedResult = expander.expandField(daysOfWeekField);

        assertEquals(4, expandedResult.size());
        assertEquals("1", expandedResult.get(0));
        assertEquals("2", expandedResult.get(1));
        assertEquals("3", expandedResult.get(2));
        assertEquals("4", expandedResult.get(3));
    }
}

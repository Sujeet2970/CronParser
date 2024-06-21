package org.deliveroo.expander;

import org.deliveroo.cronfields.CronField;
import org.deliveroo.cronfields.DaysOfWeek;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CronFieldWildcardExpanderTest {
    @Test
    public void sanityTest() {
        CronField daysOfWeekField = new DaysOfWeek("*");
        CronFieldWildcardExpander expander = new CronFieldWildcardExpander();
        List<String> expandedResult = expander.expandField(daysOfWeekField);

        assertEquals(7, expandedResult.size());
        assertEquals("1", expandedResult.get(0));
        assertEquals("2", expandedResult.get(1));
        assertEquals("3", expandedResult.get(2));
        assertEquals("4", expandedResult.get(3));
        assertEquals("5", expandedResult.get(4));
        assertEquals("6", expandedResult.get(5));
        assertEquals("7", expandedResult.get(6));
    }
}

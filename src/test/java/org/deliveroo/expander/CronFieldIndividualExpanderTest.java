package org.deliveroo.expander;

import org.deliveroo.cronfields.CronField;
import org.deliveroo.cronfields.DaysOfWeek;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CronFieldIndividualExpanderTest {
    @Test
    public void sanityTest() {
        CronField daysOfWeekField = new DaysOfWeek("1,5,6");
        CronFieldIndividualExpander expander = new CronFieldIndividualExpander();
        List<String> expandedResult = expander.expandField(daysOfWeekField);

        assertEquals(3, expandedResult.size());
        assertEquals("1", expandedResult.get(0));
        assertEquals("5", expandedResult.get(1));
        assertEquals("6", expandedResult.get(2));
    }
}

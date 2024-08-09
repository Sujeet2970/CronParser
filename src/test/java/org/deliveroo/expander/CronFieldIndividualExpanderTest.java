package org.deliveroo.expander;

import org.deliveroo.cronfields.CronField;
import org.deliveroo.cronfields.DaysOfWeek;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CronFieldIndividualExpanderTest {
    @Test
    public void sanityTest() {
        CronField daysOfWeekField = new DaysOfWeek("1");
        CronFieldIndividualExpander expander = new CronFieldIndividualExpander();
        List<Integer> expandedResult = expander.expandField(daysOfWeekField);

        assertEquals(1, expandedResult.size());
        assertEquals(Integer.valueOf(1), expandedResult.get(0));
    }

    @Test
    public void testCronExpressionWithInvalidInput() {
        CronField daysOfWeekField = new DaysOfWeek("abc");
        CronFieldIndividualExpander expander = new CronFieldIndividualExpander();

        assertThrows(NumberFormatException.class, () -> {
            expander.expandField(daysOfWeekField);
        });
    }
}

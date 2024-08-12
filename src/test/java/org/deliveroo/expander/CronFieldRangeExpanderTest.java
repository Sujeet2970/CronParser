package org.deliveroo.expander;

import org.deliveroo.cronfields.CronField;
import org.deliveroo.cronfields.DaysOfWeek;
import org.deliveroo.exception.InvalidInputException;
import org.deliveroo.exception.OutOfRangeException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CronFieldRangeExpanderTest {
    @Test
    public void sanityTest() {
        CronField daysOfWeekField = new DaysOfWeek("1,3-6");
        CronFieldRangeExpander expander = new CronFieldRangeExpander();
        List<Integer> expandedResult = expander.expandField(daysOfWeekField, "3-6");

        assertEquals(4, expandedResult.size());
        assertEquals(Integer.valueOf(3), expandedResult.get(0));
        assertEquals(Integer.valueOf(4), expandedResult.get(1));
        assertEquals(Integer.valueOf(5), expandedResult.get(2));
        assertEquals(Integer.valueOf(6), expandedResult.get(3));
    }

    @Test
    public void testSegmentOutOfRangeException() {
        CronField daysOfWeekField = new DaysOfWeek("1,2,6-63");
        CronFieldRangeExpander expander = new CronFieldRangeExpander();

        assertThrows(OutOfRangeException.class, () -> {
            expander.expandField(daysOfWeekField, "6-63");
        });
    }

    @Test
    public void testInvalidInputException() {
        CronField daysOfWeekField = new DaysOfWeek("1,2,6-2");
        CronFieldRangeExpander expander = new CronFieldRangeExpander();

        assertThrows(InvalidInputException.class, () -> {
            expander.expandField(daysOfWeekField, "6-2");
        });
    }

}

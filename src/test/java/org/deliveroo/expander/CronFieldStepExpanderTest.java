package org.deliveroo.expander;

import org.deliveroo.cronfields.CronField;
import org.deliveroo.cronfields.Minute;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CronFieldStepExpanderTest {
    @Test
    public void sanityTest() {
        CronField minutesField = new Minute("0-40/15");
        CronFieldStepExpander expander = new CronFieldStepExpander();
        List<Integer> expandedResult = expander.expandField(minutesField, "0-40/15");

        assertEquals(3, expandedResult.size());
        assertEquals(Integer.valueOf(0), expandedResult.get(0));
        assertEquals(Integer.valueOf(15), expandedResult.get(1));
        assertEquals(Integer.valueOf(30), expandedResult.get(2));
    }
}

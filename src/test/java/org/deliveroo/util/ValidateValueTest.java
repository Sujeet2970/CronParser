package org.deliveroo.util;

import org.junit.jupiter.api.Test;

import static org.deliveroo.util.ValidateValue.isValueInRange;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidateValueTest {
    private static final int minRangeValue = 1;
    private static final int maxRangeValue = 10;
    @Test
    public void testIsValueInRange_withValueInsideRange() {
        int value = 5;

        boolean result = isValueInRange(value, minRangeValue, maxRangeValue);

        assertTrue(result);
    }

    @Test
    public void testIsValueInRange_withValueEqualToMinRange() {
        int value = 1;

        boolean result = isValueInRange(value, minRangeValue, maxRangeValue);

        assertTrue(result);
    }

    @Test
    public void testIsValueInRange_withValueEqualToMaxRange() {
        int value = 10;

        boolean result = isValueInRange(value, minRangeValue, maxRangeValue);

        assertTrue(result);
    }

    @Test
    public void testIsValueInRange_withValueBelowRange() {
        int value = 0;

        boolean result = isValueInRange(value, minRangeValue, maxRangeValue);

        assertFalse(result);
    }

    @Test
    public void testIsValueInRange_withValueAboveRange() {
        int value = 11;

        boolean result = isValueInRange(value, minRangeValue, maxRangeValue);

        assertFalse(result);
    }
}

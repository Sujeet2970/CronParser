package org.deliveroo.util;

import org.junit.jupiter.api.Test;

import static org.deliveroo.util.ValidateValue.isValueInRange;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidateValueTest {
    @Test
    public void sanityTest() {
        assertTrue(isValueInRange(1, 0, 23));
    }

    @Test
    public void testMinutesOutOfRange() {
        assertFalse(isValueInRange(75, 0, 59));
    }
}

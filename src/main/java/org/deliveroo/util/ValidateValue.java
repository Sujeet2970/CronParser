package org.deliveroo.util;

public class ValidateValue {
    public static boolean isValueInRange(int value, int minRangeValue, int maxRangeValue) {
        return value >= minRangeValue && value <= maxRangeValue;
    }
}

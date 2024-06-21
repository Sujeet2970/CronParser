package org.deliveroo.util;

import lombok.NonNull;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.deliveroo.constants.Columns.SEGMENT_LIMIT;
import static org.deliveroo.constants.Separator.SPACE;

public class ValidateCronExpression {
    private static final Set<Character> ALL_POSSIBLE_CHARACTERS = new HashSet<>();
    static {
        Character[] characters = {' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '-', '/', '*', ','};
        ALL_POSSIBLE_CHARACTERS.addAll(Arrays.asList(characters));
    }
    public static boolean validate(@NonNull String cronExpression) {
        String[] parts = cronExpression.split(SPACE, SEGMENT_LIMIT);
        if (parts.length != SEGMENT_LIMIT) {
            return false;
        }

        for(int i = 0; i < cronExpression.length(); i++) {
            if(!ALL_POSSIBLE_CHARACTERS.contains(cronExpression.charAt(i))) {
                return false;
            }
        }

        return true;
    }
}

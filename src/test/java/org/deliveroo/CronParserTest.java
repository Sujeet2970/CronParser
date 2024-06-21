package org.deliveroo;


import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CronParserTest {
    @Test
    public void testSimpleCronExpression() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        assertEquals(new CronParser("0-59/15 0 1,5 * 1-5 /usr/bin/find").parse(),
                """
                        minute         0 15 30 45
                        hour           0
                        day of month   1 5
                        month          1 2 3 4 5 6 7 8 9 10 11 12
                        day of week    1 2 3 4 5
                        command        /usr/bin/find
                        """
        );
    }

    @Test
    public void testCronExpressionWithComplexLists() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        assertEquals(new CronParser("0-59/15 0 1-5,1-15 * 1-5 /usr/bin/find").parse(),
                """
                        minute         0 15 30 45
                        hour           0
                        day of month   1 2 3 4 5 6 7 8 9 10 11 12 13 14 15
                        month          1 2 3 4 5 6 7 8 9 10 11 12
                        day of week    1 2 3 4 5
                        command        /usr/bin/find
                        """
        );
    }

    @Test
    public void testCronExpressionWithInvalidInput() throws InvocationTargetException, NoSuchMethodException,
            InstantiationException, IllegalAccessException {
        assertThrows(NumberFormatException.class, () -> {
            new CronParser("0-59/15 0 1-5,1-15 * abc /usr/bin/find").parse();
        });
    }
}

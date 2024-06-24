package org.deliveroo.formatter;

import org.junit.jupiter.api.Test;

import static org.deliveroo.formatter.CronFieldFormatter.getFormattedRowData;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CronFieldFormatterTest {

    @Test
    public void testGetFormattedRowData_withMultipleValues() {
        String fieldName = "TestFieldName";
        List<String> values = Arrays.asList("Value1", "Value2", "Value3");
        String expected = "TestFieldName Value1 Value2 Value3" + System.lineSeparator();

        String result = getFormattedRowData(fieldName, values);

        assertEquals(expected, result);
    }

    @Test
    public void testGetFormattedRowData_withSingleValue() {
        String fieldName = "TestFieldName";
        List<String> values = Collections.singletonList("Value1");
        String expected = "TestFieldName Value1" + System.lineSeparator();

        String result = getFormattedRowData(fieldName, values);

        assertEquals(expected, result);
    }

    @Test
    public void testGetFormattedRowData_withEmptyValues() {
        String fieldName = "TestFieldName";
        List<String> values = Collections.emptyList();
        String expected = "TestFieldName " + System.lineSeparator();

        String result = getFormattedRowData(fieldName, values);

        assertEquals(expected, result);
    }

    @Test
    public void testGetFormattedRowData_withLongFieldName() {
        String fieldName = "VeryLongFieldName";
        List<String> values = Arrays.asList("Value1", "Value2");
        String expected = "VeryLongFieldName Value1 Value2" + System.lineSeparator();

        String result = getFormattedRowData(fieldName, values);

        assertEquals(expected, result);
    }

    @Test
    public void testGetFormattedRowData_withEmptyFieldName() {
        String fieldName = "";
        List<String> values = Arrays.asList("Value1", "Value2");
        String expected = "              Value1 Value2" + System.lineSeparator();

        String result = getFormattedRowData(fieldName, values);

        assertEquals(expected, result);
    }
}

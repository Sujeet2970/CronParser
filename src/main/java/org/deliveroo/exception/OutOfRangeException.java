package org.deliveroo.exception;

public class OutOfRangeException extends RuntimeException {
    public OutOfRangeException(String message, int value) {
        super(String.format("Provided value is out of range for field %s and the value %d", message, value));
    }

}

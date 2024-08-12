package org.deliveroo.exception;

public class InvalidInputException extends RuntimeException{
    public InvalidInputException(String input, String fieldName) {
        super(String.format("Provided input %s is not valid for field %s ", input, fieldName));
    }
}

package com.tasks.order.producer.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * If order format is not valid then throws InvalidOrderException
 */
@Getter
public class InvalidOrderException extends Throwable {

    private String errorMessage;

    private HttpStatus httpStatus;
    public InvalidOrderException(String invalidOrder, HttpStatus httpStatus) {
        this.errorMessage = invalidOrder;
        this.httpStatus = httpStatus;
    }
}

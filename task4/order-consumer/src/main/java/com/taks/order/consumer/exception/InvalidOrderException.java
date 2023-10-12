package com.taks.order.consumer.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;

/**
 * Exception Handler for Invalid Order
 */
@Getter
public class InvalidOrderException extends Throwable {

    private String errorMessage;
    private HttpStatus httpStatus;
    public InvalidOrderException(String inavlidOrder, HttpStatus httpStatus) {
        this.errorMessage = inavlidOrder;
        this.httpStatus = httpStatus;
    }
}

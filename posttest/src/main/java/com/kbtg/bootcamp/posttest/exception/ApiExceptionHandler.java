package com.kbtg.bootcamp.posttest.exception;

import com.kbtg.bootcamp.posttest.response.ApiErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.ZonedDateTime;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler({TicketNotFoundException.class})
    public ResponseEntity<ApiErrorResponse> handleNotFoundException(TicketNotFoundException e) {
        ApiErrorResponse errorResponse = new ApiErrorResponse(e.getMessage(), HttpStatus.NOT_FOUND,
                ZonedDateTime.now());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({BadRequestException.class})
    public ResponseEntity<ApiErrorResponse> handleNotFoundException(BadRequestException e) {
        ApiErrorResponse errorResponse = new ApiErrorResponse(e.getMessage(), HttpStatus.BAD_REQUEST,
                ZonedDateTime.now());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

}

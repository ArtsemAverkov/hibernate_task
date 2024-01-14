package ru.clevertec.house.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.clevertec.house.utill.ResponseError;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(RuntimeException.class)
    private ResponseError serverErrorRuntime (RuntimeException ex) {
        return new ResponseError("INCORRECT REQUEST", ex.toString());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(NoSuchElementException.class)
    private ResponseError noSuchElement (NoSuchElementException ex) {
        return new ResponseError("NO SUCH ELEMENT", ex.toString());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MissingServletRequestParameterException.class)
    private ResponseError messageNotReadable (MissingServletRequestParameterException ex) {
        return new ResponseError("NO CORRECT REQUEST", ex.toString());
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    protected ResponseError  handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex) {
        return new ResponseError("METHOD NOT ALLOWED", ex.toString());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseError handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        return new ResponseError("VALIDATION ERROR", ex.toString());
    }


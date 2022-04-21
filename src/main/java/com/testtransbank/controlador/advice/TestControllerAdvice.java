package com.testtransbank.controlador.advice;

import com.testtransbank.exception.TestTransbankException;
import com.testtransbank.helper.MessageHelper;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class TestControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity methodArgumentNotValidException(MethodArgumentNotValidException e) {
        Map response = new HashMap();
        response.put(MessageHelper.MESSAGE, getFieldError(e));
        return ResponseEntity.badRequest().body(response);
    }


    @ExceptionHandler(TestTransbankException.class)
    public ResponseEntity testTransbankException(TestTransbankException e) {
        Map response = new HashMap();
        response.put(MessageHelper.MESSAGE, e.getMessage());
        return ResponseEntity.badRequest().body(response);
    }

    private String getFieldError(MethodArgumentNotValidException e) {
        FieldError fieldError = e.getBindingResult().getFieldErrors().stream().findFirst().get();
        return "[" + fieldError.getField() + "] " + fieldError.getDefaultMessage();
    }
}

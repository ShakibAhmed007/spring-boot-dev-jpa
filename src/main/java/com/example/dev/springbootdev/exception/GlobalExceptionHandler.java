package com.example.dev.springbootdev.exception;

import com.example.dev.springbootdev.customresponse.CustomResponse;
import com.example.dev.springbootdev.customresponse.CustomResponseUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<CustomResponse<String>> handleCustomException(CustomException ex){
        CustomResponse<String> response = CustomResponseUtil.createResponse(ex.getStatusCode(), null, null);
        response.setMessage(ex.getMessage());
        return ResponseEntity.status(ex.getStatusCode()).body(response);
    }
}

package com.example.dev.springbootdev.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CustomException extends RuntimeException{

    private int statusCode;
    private String message;
}

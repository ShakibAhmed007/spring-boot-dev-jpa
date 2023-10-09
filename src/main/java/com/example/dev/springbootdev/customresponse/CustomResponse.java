package com.example.dev.springbootdev.customresponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomResponse<T> {

    private int statusCode;
    private String date;
    private String requestedSource;
    private String message;
    private T data;
}

package com.example.dev.springbootdev.customresponse;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CustomResponseUtil {

    public static <T> CustomResponse<T> createResponse(int statusCode, T data, String requestedSource){
        CustomResponse<T> customResponse = new CustomResponse<T>();
        customResponse.setStatusCode(statusCode);
        customResponse.setData(data);
        customResponse.setRequestedSource(requestedSource);
        customResponse.setDate(LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
        return customResponse;
    }
}

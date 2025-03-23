package com.youhogeon.finance.kis_api.exception;

import lombok.Getter;

@Getter
public class InvalidApiRequestException extends KisClientException {

    private String message;
    private int statusCode;

    public InvalidApiRequestException(String message){
        super(message);

        this.message = message;
    }

    public InvalidApiRequestException(String message, int statusCode){
        super(message + "[status code : " + statusCode + "]");

        this.message = message;
        this.statusCode = statusCode;
    }

}

package com.youhogeon.finance.kis_api.exception;

public class InvalidApiRequestException extends RuntimeException{

    public InvalidApiRequestException(String message){
        super(message);
    }

    public InvalidApiRequestException(String message, String errorCode){
        super(errorCode + ": " + message);
    }

}

package com.youhogeon.finance.kis_api.exception;

public class KisClientException extends RuntimeException {

    public KisClientException(String message){
        super(message);
    }

    public KisClientException(String message, Throwable cause){
        super(message, cause);
    }

}

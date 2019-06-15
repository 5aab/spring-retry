package com.aab.retry.exception;

public class UnhealthyResourceException extends RuntimeException {

    public UnhealthyResourceException(Exception e, String msg){
        super(msg,e);
    }

    public UnhealthyResourceException(){
        super();
    }

    public UnhealthyResourceException(String msg){
        super(msg);
    }
}

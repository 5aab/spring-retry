package com.aab.retry.exception;

public class UnhealthyChildResourceException extends UnhealthyResourceException {

    public UnhealthyChildResourceException(Exception e, String msg){
        super(e,msg);
    }

    public UnhealthyChildResourceException(){
        super();
    }

    public UnhealthyChildResourceException(String msg){
        super(msg);
    }
}

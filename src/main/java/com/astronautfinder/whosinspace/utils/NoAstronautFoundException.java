package com.astronautfinder.whosinspace.utils;

public class NoAstronautFoundException extends ArrayStoreException {

    public NoAstronautFoundException(String message){
        super(message);
    }
}

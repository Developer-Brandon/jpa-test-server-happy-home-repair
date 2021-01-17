package com.dkstudio.happyhomerepair.exception;

public class CantFindDataException extends Exception{
    public CantFindDataException() {
        // nothing to do ....
    }
    CantFindDataException(String message) {
        super(message);
    }
}

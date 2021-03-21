package com.dkstudio.happyhomerepair.exception.common;

public class CantFindDataException extends Exception{
    public CantFindDataException() {
    }

    CantFindDataException(String message) {
        super(message);
    }
}

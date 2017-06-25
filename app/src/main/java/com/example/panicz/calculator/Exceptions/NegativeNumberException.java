package com.example.panicz.calculator.Exceptions;

/**
 * Created by Panicz on 25-Jun-17.
 */

public class NegativeNumberException extends Exception {
    private static final long serialVersionUID = -1433615164868074553L;

    public NegativeNumberException(String msg){
        super(msg);
    }
}

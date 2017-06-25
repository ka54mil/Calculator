package com.example.panicz.calculator.Exceptions;

public class NotAWholeNumberException extends Exception{
    private static final long serialVersionUID = -1433615164868074553L;

    public NotAWholeNumberException(String msg){
        super(msg);
    }
}

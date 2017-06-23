package com.example.panicz.calculator.Exceptions;

public class NotAPrimeNumberException extends Exception{
    private static final long serialVersionUID = -1433615164868074553L;

    public NotAPrimeNumberException(String msg){
        super(msg);
    }
}

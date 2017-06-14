package com.example.panicz.calculator.Exceptions;

public class IncorrectEquationFormatException extends Exception{
    private static final long serialVersionUID = -1433615164868074553L;

    public IncorrectEquationFormatException(String msg){
        super(msg);
    }
}
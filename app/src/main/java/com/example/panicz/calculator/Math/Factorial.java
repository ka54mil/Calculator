package com.example.panicz.calculator.Math;

import com.example.panicz.calculator.Exceptions.NegativeNumberException;
import com.example.panicz.calculator.Exceptions.NotAWholeNumberException;

import java.math.BigDecimal;
import java.math.BigInteger;

public final class Factorial {
    private Factorial(){
        super();
    }

    public static BigDecimal factorial(BigDecimal n) throws NotAWholeNumberException,NegativeNumberException{
        try{
            return new BigDecimal(factorial(n.toBigIntegerExact()));
        } catch (ArithmeticException aE){
            throw new NotAWholeNumberException("The given number must be a whole number");
        }
    }

    public static BigInteger factorial(BigInteger n) throws NegativeNumberException{
        int sign = n.signum();
        if(sign==-1){
            throw new NegativeNumberException("Can't calculate negative factorial");
        }else if(sign==0 ){
            return BigInteger.ONE;
        }else{
            return Multiplication.multiply(n,factorial(Subtraction.decrement(n)));
        }
    }
}

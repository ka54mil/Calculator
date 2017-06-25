package com.example.panicz.calculator.Math;

import java.math.BigDecimal;
import java.math.BigInteger;

public final class Multiplication {

    private Multiplication(){
        super();
    }

    public static BigDecimal multiply(BigDecimal first, BigDecimal second, int scale, int roundingMode){
        return first.multiply(second).setScale(scale, roundingMode);
    }

    public static BigInteger multiply(BigInteger first, BigInteger second){
        return first.multiply(second);
    }
}

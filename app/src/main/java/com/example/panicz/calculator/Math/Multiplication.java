package com.example.panicz.calculator.Math;

import java.math.BigDecimal;

public final class Multiplication {

    private Multiplication(){
        super();
    }

    public static BigDecimal multiply(BigDecimal first, BigDecimal second, int scale, int roundingMode){
        return first.multiply(second).setScale(scale, roundingMode);
    }
}

package com.example.panicz.calculator.Math;

import java.math.BigDecimal;

public final class Subtraction {

    private Subtraction(){
        super();
    }

    public static BigDecimal subtract(BigDecimal first, BigDecimal second) {
        return first.subtract(second);
    }
}

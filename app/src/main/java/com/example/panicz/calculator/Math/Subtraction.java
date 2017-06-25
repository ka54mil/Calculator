package com.example.panicz.calculator.Math;

import java.math.BigDecimal;
import java.math.BigInteger;

public final class Subtraction {

    private Subtraction(){
        super();
    }

    public static BigDecimal subtract(BigDecimal first, BigDecimal second) {
        return first.subtract(second);
    }

    public static BigDecimal decrement(BigDecimal number) {
        return number.subtract(BigDecimal.ONE);
    }

    public static BigInteger subtract(BigInteger first, BigInteger second) {
        return first.subtract(second);
    }

    public static BigInteger decrement(BigInteger number) {
        return number.subtract(BigInteger.ONE);
    }
}

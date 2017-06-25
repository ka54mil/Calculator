package com.example.panicz.calculator.Math;

import java.math.BigDecimal;
import java.math.BigInteger;

public final class Addition {

    private Addition(){
        super();
    }

    public static BigDecimal add(BigDecimal first, BigDecimal second) {
        return first.add(second).stripTrailingZeros();
    }

    public static BigDecimal increment(BigDecimal number){
        return add(number,BigDecimal.ONE);
    }

    public static BigInteger add(BigInteger first, BigInteger second) {
        return first.add(second);
    }

    public static BigInteger increment(BigInteger number){
        return add(number,BigInteger.ONE);
    }
}

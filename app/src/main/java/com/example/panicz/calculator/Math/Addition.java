package com.example.panicz.calculator.Math;

import java.math.BigDecimal;

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
}

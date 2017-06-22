package com.example.panicz.calculator.Controllers.Calculations;

import java.math.BigDecimal;

public final class GreatestCommonDivisor {

    private GreatestCommonDivisor(){
        super();
    }

    public static BigDecimal gCD(BigDecimal first, BigDecimal second){
        BigDecimal rest;
        while((rest = first.remainder(second)).compareTo(BigDecimal.ZERO)!=0){
            first = second;
            second = rest;
        }
        return second.abs();
    }
}

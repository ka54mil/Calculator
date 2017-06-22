package com.example.panicz.calculator.Controllers.Calculations;

import java.math.BigDecimal;

public final class Multiplication {

    private Multiplication(){
        super();
    }

    public static BigDecimal multiply(BigDecimal first, BigDecimal second){
        return first.multiply(second);
    }
}

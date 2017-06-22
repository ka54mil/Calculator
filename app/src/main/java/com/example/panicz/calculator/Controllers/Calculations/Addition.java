package com.example.panicz.calculator.Controllers.Calculations;

import java.math.BigDecimal;

public final class Addition {

    private Addition(){
        super();
    }

    public static BigDecimal add(BigDecimal first, BigDecimal second) {
        return first.add(second);
    }

}

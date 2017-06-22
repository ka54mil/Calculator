package com.example.panicz.calculator.Controllers.Calculations;

import java.math.BigDecimal;

public final class Division {

    private Division(){
        super();
    }

    public static BigDecimal divide(BigDecimal dividend, BigDecimal divisor){
        if (divisor.equals(new BigDecimal(0))) {
            throw new ArithmeticException("Dividing by 0");
        }
        return dividend.divide(divisor);
    }

    public static boolean isEven(BigDecimal number){
        return canBeDividedBy(number, new BigDecimal(2));
    }

    public static boolean canBeDividedBy(BigDecimal number, BigDecimal dividor){
        return number.remainder(dividor).compareTo(BigDecimal.ZERO)==0;
    }
}

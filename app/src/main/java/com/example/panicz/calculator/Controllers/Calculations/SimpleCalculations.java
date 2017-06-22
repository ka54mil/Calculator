package com.example.panicz.calculator.Controllers.Calculations;

import java.math.BigDecimal;

public class SimpleCalculations {
    protected int roundingMode;
    protected int precision;

    public SimpleCalculations(){
        roundingMode = BigDecimal.ROUND_HALF_UP;
        precision = 500;
    }

    public SimpleCalculations(int roundingMode, int precision){
        this.roundingMode = roundingMode;
        this.precision = precision;
    }

    public BigDecimal add(BigDecimal first, BigDecimal second) {
        return Addition.add(first, second);
    }

    public BigDecimal subtract(BigDecimal first, BigDecimal second) {
        return Subtraction.subtract(first, second);
    }

    public BigDecimal multiply(BigDecimal first, BigDecimal second) {
        return Multiplication.multiply(first, second);
    }

    public BigDecimal divide(BigDecimal dividend, BigDecimal divisor) throws ArithmeticException {
        dividend = dividend.setScale(precision+50,roundingMode);
        divisor = divisor.setScale(precision+50,roundingMode);
        return Division.divide(dividend, divisor).setScale(precision,roundingMode);
    }
}

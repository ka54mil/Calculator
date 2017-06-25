package com.example.panicz.calculator.Math;

import java.math.BigDecimal;

public class SimpleCalculations {
    protected int roundingMode;
    protected int scale;

    public SimpleCalculations() {
        scale = 500;
        roundingMode = BigDecimal.ROUND_HALF_UP;
    }

    public SimpleCalculations(int roundingMode, int scale) {
        this.roundingMode = roundingMode;
        this.scale = scale;
    }

    public BigDecimal add(BigDecimal first, BigDecimal second) {
        return Addition.add(first, second);
    }

    public BigDecimal subtract(BigDecimal first, BigDecimal second) {
        return Subtraction.subtract(first, second);
    }

    public BigDecimal multiply(BigDecimal first, BigDecimal second) {
        return Multiplication.multiply(first, second, this.scale, this.roundingMode);
    }

    public BigDecimal divide(BigDecimal dividend, BigDecimal divisor) throws ArithmeticException {
        return Division.divide(dividend, divisor, this.scale, this.roundingMode);
    }
}

package com.example.panicz.calculator.Controllers;

import java.math.BigDecimal;

public class Calculations {

    public BigDecimal add(BigDecimal first, BigDecimal second) {
        return first.add(second).stripTrailingZeros();
    }

    public BigDecimal subtract(BigDecimal first, BigDecimal second) {
        return first.subtract(second).stripTrailingZeros();
    }

    public BigDecimal multiply(BigDecimal first, BigDecimal second) {
        return first.multiply(second).stripTrailingZeros();
    }

    public BigDecimal divide(BigDecimal first, BigDecimal second) throws ArithmeticException {
        if (second.equals(new BigDecimal(0))) {
            throw new ArithmeticException("Dividing by 0");
        }
        return first.divide(second, 350, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
    }

//    public BigDecimal pow(BigDecimal first, BigDecimal n){
//        BigDecimal bigDecimalToN = n.stripTrailingZeros().remainder(BigDecimal.ONE).movePointRight(first.scale()); //Muszę zamienic np. 22312.4312 na ulamek i dodac potege i pierwiastek
//        int powPart = n.intValue();
//        if (n.subtract(n.int).compareTo(powPart))
//        return first.pow().add(root(first,)).stripTrailingZeros();
//    }

    public BigDecimal pow(BigDecimal first, int n) {
        return first.pow(n).stripTrailingZeros();
    }

    public BigDecimal root(BigDecimal first, int n) {

        BigDecimal result = new BigDecimal(10).setScale(300, BigDecimal.ROUND_HALF_UP);


        return result.stripTrailingZeros();
    }
}

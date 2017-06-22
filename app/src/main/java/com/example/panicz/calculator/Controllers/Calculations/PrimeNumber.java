package com.example.panicz.calculator.Controllers.Calculations;

import java.math.BigDecimal;
import java.util.Deque;
import java.util.LinkedList;

public final class PrimeNumber {


    public Deque<BigDecimal> toPrimeNumbers(BigDecimal number){
        Deque<BigDecimal> result = new LinkedList();
        BigDecimal primeNumber = new BigDecimal(2);
        while(Division.canBeDividedBy(number, primeNumber)){
            number = Division.divide(number, primeNumber);
            result.push(primeNumber);
        }

        primeNumber = new BigDecimal(3);
        while(primeNumber.compareTo(number.abs())==-1){
            if (Division.canBeDividedBy(number, primeNumber)){
                number = Division.divide(number, primeNumber);
                result.push(primeNumber);
            } else {
                result.push(getPrimeNumberBetween(primeNumber,number));
            }
        }

        result.push(number);
        return result;
    }

    public BigDecimal getPrimeNumberBetween(BigDecimal first, BigDecimal second){
        if(Division.isEven(first)){
            first = Addition.add(first,BigDecimal.ONE);
        }
        while(second.compareTo(first)==1){
            if(Division.canBeDividedBy(second, first)){
                return first;
            } else {

            }
        }
        return first;
    }
}

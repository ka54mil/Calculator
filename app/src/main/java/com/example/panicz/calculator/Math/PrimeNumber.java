package com.example.panicz.calculator.Math;

import com.example.panicz.calculator.Exceptions.NotAPrimeNumberException;

import java.math.BigDecimal;
import java.util.Deque;
import java.util.LinkedList;

public final class PrimeNumber {

    private PrimeNumber(){
        super();
    }

    public static Deque<BigDecimal> toPrimeNumbers(BigDecimal number){
        Deque<BigDecimal> result = new LinkedList();
        BigDecimal primeNumber = new BigDecimal(2);
        while(Division.canBeDividedBy(number, primeNumber)){
            number = Division.divide(number, primeNumber,0,BigDecimal.ROUND_HALF_UP);
            result.push(primeNumber);
        }

        primeNumber = new BigDecimal(3);
        while(primeNumber.compareTo(number.abs())==-1){
            if (Division.canBeDividedBy(number, primeNumber)){
                number = Division.divide(number, primeNumber, 0,BigDecimal.ROUND_HALF_UP);
                result.push(primeNumber);
            } else {
                result.push(getPrimeNumberBetween(primeNumber,number));
            }
        }

        result.push(number);
        return result;
    }

    public static BigDecimal getPrimeNumberBetween(BigDecimal first, BigDecimal second){
        if(Division.isEven(first)){
            first = Addition.increment(first);
        }
        while(second.compareTo(first)==1){
            if(Division.canBeDividedBy(second, first)){
                return first;
            } else {

            }
        }
        return first;
    }

    public static BigDecimal getLowestPrimeNumber(BigDecimal number) throws NotAPrimeNumberException{
        if(!Division.canBeDividedBy(number, BigDecimal.ONE) || number.abs().compareTo(BigDecimal.ONE)!=1){
            throw new NotAPrimeNumberException("Given number is 0, 1 or is not an integer");
        }

        BigDecimal sqrt = Roots.root(number,2);
        System.out.println("sqrt"+sqrt);
        BigDecimal result = new BigDecimal(2);
        BigDecimal two = result;
        if (Division.canBeDividedBy(number, two)){
            return two;
        }
        result = Addition.increment(result);

        while(!Division.canBeDividedBy(number,result) && sqrt.compareTo(result)==1){
            result = Addition.add(result, two);
        }
        return result;
    }

    public static BigDecimal getPrimeNumber(BigDecimal number, BigDecimal initialPrimeNumber){

        return initialPrimeNumber;
    }
}

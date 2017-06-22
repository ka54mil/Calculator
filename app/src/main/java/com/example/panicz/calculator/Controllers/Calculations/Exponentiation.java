package com.example.panicz.calculator.Controllers.Calculations;


import com.example.panicz.calculator.Interfaces.ICalculations;

import java.math.BigDecimal;

public final class Exponentiation extends Roots{

    private Exponentiation(){
        super();
    }

    public static BigDecimal pow(BigDecimal number, BigDecimal n){
        int scale = n.scale();
        BigDecimal fractPart = n.stripTrailingZeros().remainder(BigDecimal.ONE).abs();
        BigDecimal intVal =n.signum()==1?Subtraction.subtract(n, fractPart):Addition.add(n, fractPart);
        fractPart = fractPart.movePointRight(scale);

        BigDecimal powScale = pow(BigDecimal.TEN, scale);
        BigDecimal gCD = GreatestCommonDivisor.gCD(fractPart, powScale);

        fractPart = Division.divide(fractPart, gCD);
        powScale = Division.divide(powScale, gCD);

        number = pow(number, powScale, (a, power)-> root(a,power));
        number = pow(number, fractPart, (a, power)-> pow(a,power));

        return number;
    }

    private static BigDecimal pow(BigDecimal number, BigDecimal n, ICalculations method) {
        BigDecimal maxIntVal = new BigDecimal(999);
        BigDecimal result = new BigDecimal(1);
        if(n.compareTo(maxIntVal)==1){
            BigDecimal powResult = method.calculate(number, maxIntVal.intValue());
            BigDecimal maxIntValSquare = pow(maxIntVal,2);
            if(n.compareTo(maxIntValSquare)==1){
                BigDecimal powResultSquare = pow(pow(number,2),maxIntVal.intValue());
                while(n.compareTo(maxIntValSquare)==1){
                    result = Multiplication.multiply(powResultSquare,result);
                    n = Subtraction.subtract(n,maxIntValSquare);
                }
            }
            while (n.compareTo(maxIntVal)==1){
                result = Multiplication.multiply(powResult,result);
                n = Subtraction.subtract(n,maxIntVal);
            }
        }
        result = Multiplication.multiply(method.calculate(number , n.intValue()), result);
        return result;
    }

    public static BigDecimal pow(BigDecimal number, int n) {
        if(n>999999999){
            return Multiplication.multiply(
                    pow(
                            number,
                            Subtraction.subtract(
                                    new BigDecimal(n),
                                    new BigDecimal(
                                            999999999
                                    )
                            ).intValue()
                    ),
                    pow(
                            number,
                            new BigDecimal(999999999).intValue()
                    )
            );
        }
        return number.pow(n);
    }
}

package com.example.panicz.calculator;

import com.example.panicz.calculator.Controllers.Calculations;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class CalculationsUnitTest {
    private Calculations test = new Calculations();
    private BigDecimal jeden = new BigDecimal("1");
    private BigDecimal dwa = new BigDecimal("2");
    private BigDecimal dwa34 = new BigDecimal("2.34");
    private BigDecimal trzy = new BigDecimal("3");
    private BigDecimal cztery = new BigDecimal("4");
    private BigDecimal osiem = new BigDecimal("8");
    private BigDecimal jedenZero = new BigDecimal("10");
    private BigDecimal jedenSzesc = new BigDecimal("16");
    private BigDecimal dwaJeden06 = new BigDecimal("21.06");
    private BigDecimal dwaTrzy4 = new BigDecimal("23.4");
    private BigDecimal trzyDwa = new BigDecimal("32");
    private BigDecimal szescCztery = new BigDecimal("64");

    @Test
    public void addTest(){
        Assert.assertEquals(cztery, test.add(dwa,dwa));
        Assert.assertEquals(dwaTrzy4,test.add(dwaJeden06,dwa34));
    }

    @Test
    public void rootTest(){
        BigDecimal x0 = szescCztery;
        int n = 2;
        BigDecimal x1 = x0.divide(jedenZero);
        BigDecimal x2 = x1;
        BigDecimal x3 = x2.pow(n).setScale(300, BigDecimal.ROUND_HALF_UP);

        while(!x0.setScale(300, BigDecimal.ROUND_HALF_UP).equals(x3)){
            if(x3.compareTo(x0)==1){
                x2 = x2.subtract(x1);
                x1 = x1.divide(jedenZero, 350, BigDecimal.ROUND_HALF_UP);
            } else {
                x2 = x2.add(x1);
            }
            x3 = x2.pow(n).setScale(300, BigDecimal.ROUND_HALF_UP);
        }

        Assert.assertEquals(osiem.toPlainString(), x2.stripTrailingZeros().toPlainString());

    }
}

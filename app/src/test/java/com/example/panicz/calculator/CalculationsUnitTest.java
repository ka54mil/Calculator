package com.example.panicz.calculator;

import com.example.panicz.calculator.Controllers.Calculations;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class CalculationsUnitTest {
    private Calculations test = new Calculations();
    BigDecimal cztery = new BigDecimal("4").setScale(100, BigDecimal.ROUND_HALF_UP);
    BigDecimal dwa = new BigDecimal("2").setScale(100, BigDecimal.ROUND_HALF_UP);
    BigDecimal dwa34 = new BigDecimal("2.34").setScale(100, BigDecimal.ROUND_HALF_UP);
    BigDecimal dwaTrzy4 = new BigDecimal("23.4").setScale(100, BigDecimal.ROUND_HALF_UP);
    BigDecimal dwaJeden06 = new BigDecimal("21.06").setScale(100, BigDecimal.ROUND_HALF_UP);

    @Test
    public void addTest(){
        Assert.assertEquals(cztery, test.add(dwa,dwa));
        Assert.assertEquals(dwaTrzy4,test.add(dwaJeden06,dwa34));
    }
}

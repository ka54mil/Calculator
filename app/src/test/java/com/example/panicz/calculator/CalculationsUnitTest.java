package com.example.panicz.calculator;

import com.example.panicz.calculator.Controllers.Calculations;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class CalculationsUnitTest {
    private Calculations test = new Calculations();
    private BigDecimal minusJedenTrzyPiecSiedemPiecSzescSiedemOsiemDziewiecZeroPiecDZiewiecZeroZeroOsiemDziewiecPiecJedenJedenDziewiecZeroZeroOsiemSzesc = new BigDecimal("-246456789104008951190086");
    private BigDecimal minusJedenDwaTrzyCzteryPiecSzescSiedemOsiemDziewiecZeroPiecCzteryZeroZeroZeroDziewiecPiecJedenJedenZeroZeroZeroJedenOsiemSzesc = new BigDecimal("-123456789054000951100086");
    private BigDecimal minusJedenDwaTrzyZeroZeroZeroZeroZeroZeroZeroPiecZeroZeroZeroOsiemZeroZeroZeroZeroDziewiecZeroZeroZeroZero = new BigDecimal("-123000000050008000090000");
    private BigDecimal minusSzescCztery = new BigDecimal("-64");
    private BigDecimal minusCztery = new BigDecimal("-4");
    private BigDecimal minusZero00000000000000000001 = new BigDecimal("-0.00000000000000000001");
    private BigDecimal zero = new BigDecimal("0");
    private BigDecimal zero21474836595 = new BigDecimal("2147483595");
    private BigDecimal zero00000000000000000001 = new BigDecimal("0.00000000000000000001");
    private BigDecimal zero01 = new BigDecimal("0.01");
    private BigDecimal zero5 = new BigDecimal("0.5");
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
    private BigDecimal jedenSzescDziewiecSiedemSiedemPiecCzteryZeroOsiemSzescTrzyDwaJedenCzteryDiewiecPiecTrzyOsiemOsiemDziewiecJeden = new BigDecimal("169775408632149538891");
    private BigDecimal jedenPiecCzteryOsiemDwaJedenDziewiecSzescSiedemSzescDziewiecTrzyTrzyZeroDziwecCzteryPiecZeroZeroJedenOsiemSiedemJeden = new BigDecimal("15482196769330945001871");
    private BigDecimal jedenPiecSzescPiecJedenDziewiecSiedemDwaJedenSiedemSiedemDziewiecSzescTrzyZeroDziewiecCzteryPiecCzteryZeroSiedemSzescDwa = new BigDecimal("15651972177963094540762");

    @Test
    public void addTest(){
        Assert.assertEquals(cztery, test.add(dwa,dwa).stripTrailingZeros());
        Assert.assertEquals(dwaTrzy4,test.add(dwaJeden06,dwa34).stripTrailingZeros());
        Assert.assertEquals(jedenPiecSzescPiecJedenDziewiecSiedemDwaJedenSiedemSiedemDziewiecSzescTrzyZeroDziewiecCzteryPiecCzteryZeroSiedemSzescDwa, test.add(jedenPiecCzteryOsiemDwaJedenDziewiecSzescSiedemSzescDziewiecTrzyTrzyZeroDziwecCzteryPiecZeroZeroJedenOsiemSiedemJeden, jedenSzescDziewiecSiedemSiedemPiecCzteryZeroOsiemSzescTrzyDwaJedenCzteryDiewiecPiecTrzyOsiemOsiemDziewiecJeden).stripTrailingZeros());
        Assert.assertEquals(zero, test.add(zero00000000000000000001,minusZero00000000000000000001).stripTrailingZeros());
        Assert.assertEquals(minusJedenTrzyPiecSiedemPiecSzescSiedemOsiemDziewiecZeroPiecDZiewiecZeroZeroOsiemDziewiecPiecJedenJedenDziewiecZeroZeroOsiemSzesc, test.add(minusJedenDwaTrzyCzteryPiecSzescSiedemOsiemDziewiecZeroPiecCzteryZeroZeroZeroDziewiecPiecJedenJedenZeroZeroZeroJedenOsiemSzesc,minusJedenDwaTrzyZeroZeroZeroZeroZeroZeroZeroPiecZeroZeroZeroOsiemZeroZeroZeroZeroDziewiecZeroZeroZeroZero).stripTrailingZeros());
    }

    @Test
    public void rootTest(){
        BigDecimal X=test.pow(cztery, test.divide(BigDecimal.ONE,szescCztery));
        System.out.println(X.toString());
        System.out.println(test.pow(X, szescCztery.intValue()).toString());
        Assert.assertEquals(osiem, test.root(szescCztery, 2).stripTrailingZeros());
        Assert.assertEquals(cztery, test.root(szescCztery, 3).stripTrailingZeros());
        Assert.assertEquals(minusCztery, test.root(minusSzescCztery, 3).stripTrailingZeros());
        Assert.assertEquals(dwa, test.root(szescCztery, 6).stripTrailingZeros());
    }

    @Test
    public void gCDTest(){
        Assert.assertEquals(osiem, test.gCD(szescCztery, osiem).stripTrailingZeros());
        Assert.assertEquals(cztery, test.gCD(szescCztery, minusCztery).stripTrailingZeros());
        Assert.assertEquals(dwa, test.gCD(minusSzescCztery, dwa).stripTrailingZeros());
        Assert.assertEquals(cztery, test.gCD(cztery, minusCztery).stripTrailingZeros());
    }
}
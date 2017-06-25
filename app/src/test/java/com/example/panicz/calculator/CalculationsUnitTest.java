package com.example.panicz.calculator;

import com.example.panicz.calculator.Controllers.Calculations;
import com.example.panicz.calculator.Math.Factorial;
import com.example.panicz.calculator.Math.PrimeNumber;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class CalculationsUnitTest {
    private Calculations test = new Calculations();
    private BigDecimal minusJedenTrzyPiecSiedemPiecSzescSiedemOsiemDziewiecZeroPiecDZiewiecZeroZeroOsiemDziewiecPiecJedenJedenDziewiecZeroZeroOsiemSzesc = new BigDecimal("-246456789104008951190086");
    private BigDecimal minusJedenDwaTrzyCzteryPiecSzescSiedemOsiemDziewiecZeroPiecCzteryZeroZeroZeroDziewiecPiecJedenJedenZeroZeroZeroJedenOsiemSzesc = new BigDecimal("-123456789054000951100086");
    private BigDecimal minusJedenDwaTrzyZeroZeroZeroZeroZeroZeroZeroPiecZeroZeroZeroOsiemZeroZeroZeroZeroDziewiecZeroZeroZeroZero = new BigDecimal("-123000000050008000090000");
    private BigDecimal minusSzescCztery = new BigDecimal(-64);
    private BigDecimal minusCztery = new BigDecimal(-4);
    private BigDecimal minusDwa = new BigDecimal(-2);
    private BigDecimal minusZero00000000000000000001 = new BigDecimal("-0.00000000000000000001");
    private BigDecimal zero = new BigDecimal(0);
    private BigDecimal zero00000000000000000001 = new BigDecimal("0.00000000000000000001");
    private BigDecimal zero21474836595 = new BigDecimal(0.2147483595);
    private BigDecimal zero01 = new BigDecimal(0.01);
    private BigDecimal zero5 = new BigDecimal(0.5);
    private BigDecimal jeden = new BigDecimal(1);
    private BigDecimal dwa = new BigDecimal(2);
    private BigDecimal dwa34 = new BigDecimal(2.34);
    private BigDecimal trzy = new BigDecimal(3);
    private BigDecimal cztery = new BigDecimal(4);
    private BigDecimal piec = new BigDecimal(5);
    private BigDecimal szesc = new BigDecimal(6);
    private BigDecimal jedenJeden = new BigDecimal(11);
    private BigDecimal osiem = new BigDecimal(8);
    private BigDecimal jedenZero = new BigDecimal(10);
    private BigDecimal jedenSzesc = new BigDecimal(16);
    private BigDecimal dwaJeden06 = new BigDecimal(21.06);
    private BigDecimal dwaTrzy4 = new BigDecimal(23.4);
    private BigDecimal trzyDwa = new BigDecimal(32);
    private BigDecimal szescCztery = new BigDecimal(64);
    private BigDecimal siedemJeden = new BigDecimal(71);
    private BigDecimal dziewiecSiedem = new BigDecimal(97);
    private BigDecimal dziewiecDziewiec = new BigDecimal(99);
    private BigDecimal siedemDwaZero = new BigDecimal(720);
    private BigDecimal dziewiecCzteryZeroDziewiec = new BigDecimal(9409);
    private BigDecimal dziewiecSzescZeroTrzy = new BigDecimal(9603);
    private BigDecimal jedenSzescDziewiecSiedemSiedemPiecCzteryZeroOsiemSzescTrzyDwaJedenCzteryDiewiecPiecTrzyOsiemOsiemDziewiecJeden = new BigDecimal("169775408632149538891");
    private BigDecimal jedenPiecCzteryOsiemDwaJedenDziewiecSzescSiedemSzescDziewiecTrzyTrzyZeroDziwecCzteryPiecZeroZeroJedenOsiemSiedemJeden = new BigDecimal("15482196769330945001871");
    private BigDecimal jedenPiecSzescPiecJedenDziewiecSiedemDwaJedenSiedemSiedemDziewiecSzescTrzyZeroDziewiecCzteryPiecCzteryZeroSiedemSzescDwa = new BigDecimal("15651972177963094540762");
    private BigDecimal jedenPiecSzescPiecJedenDziewiecSiedemDwaJedenSiedemSiedemDziewiecSzescTrzyZeroDziewiecCzteryPiecCzteryZeroSiedemSzescjeden = new BigDecimal("15651972177963094540783").setScale(500,BigDecimal.ROUND_HALF_UP);

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
        System.out.println(test.pow(jeden,dwa).toPlainString());
    }

    @Test
    public void gCDTest(){
        Assert.assertEquals(osiem, test.gCD(szescCztery, osiem).stripTrailingZeros());
        Assert.assertEquals(cztery, test.gCD(szescCztery, minusCztery).stripTrailingZeros());
        Assert.assertEquals(dwa, test.gCD(minusSzescCztery, dwa).stripTrailingZeros());
        Assert.assertEquals(cztery, test.gCD(cztery, minusCztery).stripTrailingZeros());
    }

    @Test
    public void getLowestPrimeNumberTest(){
        try{
            Assert.assertEquals(dwa, PrimeNumber.getLowestPrimeNumber(osiem).stripTrailingZeros());
            Assert.assertEquals(dwa, PrimeNumber.getLowestPrimeNumber(minusCztery).stripTrailingZeros());
            Assert.assertEquals(trzy, PrimeNumber.getLowestPrimeNumber(trzy).stripTrailingZeros());
            Assert.assertEquals(dwa, PrimeNumber.getLowestPrimeNumber(minusDwa).stripTrailingZeros());
            Assert.assertEquals(dziewiecSiedem, PrimeNumber.getLowestPrimeNumber(dziewiecSiedem).stripTrailingZeros());
            Assert.assertEquals(dziewiecSiedem, PrimeNumber.getLowestPrimeNumber(dziewiecCzteryZeroDziewiec).stripTrailingZeros());
            Assert.assertEquals(trzy, PrimeNumber.getLowestPrimeNumber(dziewiecSzescZeroTrzy).stripTrailingZeros());
            Assert.assertEquals(dwa, PrimeNumber.getLowestPrimeNumber(minusJedenTrzyPiecSiedemPiecSzescSiedemOsiemDziewiecZeroPiecDZiewiecZeroZeroOsiemDziewiecPiecJedenJedenDziewiecZeroZeroOsiemSzesc).stripTrailingZeros());
            Assert.assertEquals(siedemJeden, PrimeNumber.getLowestPrimeNumber(jedenSzescDziewiecSiedemSiedemPiecCzteryZeroOsiemSzescTrzyDwaJedenCzteryDiewiecPiecTrzyOsiemOsiemDziewiecJeden).stripTrailingZeros());
//            Assert.assertEquals(jedenPiecSzescPiecJedenDziewiecSiedemDwaJedenSiedemSiedemDziewiecSzescTrzyZeroDziewiecCzteryPiecCzteryZeroSiedemSzescjeden, Exponentiation.pow(dwa,jedenPiecSzescPiecJedenDziewiecSiedemDwaJedenSiedemSiedemDziewiecSzescTrzyZeroDziewiecCzteryPiecCzteryZeroSiedemSzescjeden,500, BigDecimal.ROUND_HALF_UP).stripTrailingZeros());

        } catch (Exception e){
            e.printStackTrace();
        }

    }

    @Test
    public void FactorialTest(){
        try {
            Assert.assertEquals(dwa, Factorial.factorial(dwa));
            Assert.assertEquals(szesc, Factorial.factorial(trzy));
            Assert.assertEquals(siedemDwaZero, Factorial.factorial(szesc));
            Assert.assertEquals(new BigDecimal(
                    "126886932185884164103433389335161480802865516174545192198801"+
                    "894375214704230400000000000000"), Factorial.factorial(szescCztery));
            Assert.assertEquals(new BigDecimal(
                    "260121894356579510020490322708104361119152187501694578572754" +
                    "183785083563115694738224067857795813045708261992057589224725" +
                    "953664156516205201587379198458774083252910524469038881188412" +
                    "376434119195104550534665861624327194019711390984553672727853" +
                    "709934562985558671936977407000370043078375899742067678401696" +
                    "720784628062922903210716166986726054898844551425719398549944" +
                    "893959449606404513236214026598619307324936977047760606768067" +
                    "017649166940303481996188145562519559256691883082551494294759" +
                    "653727484562462882423452659778973774089646655399243592878621" +
                    "251596748322097602950569669992728467056374713753301924831358" +
                    "707612541268341586012944756601145542074958995256354306828863" +
                    "463108496565068277155299625679084523570255218622235813001670" +
                    "083452344323682193579318470195651072978180435417389056072742" +
                    "804858399591972902172661229129842051606757903623233769945396" +
                    "419147517556755769539223380305682530859997744167578435281591" +
                    "346134039460490126954202883834710136373382448450666009334848" +
                    "444071193129253769465735433737572477223018153403264717753198" +
                    "453734147867432704845798378661870325740593892421570969599463" +
                    "055752106320326349320922073832092335630992326750440170176057" +
                    "202601082928804233560664308988871029738079757801305604957634" +
                    "283868305719066220529117482251053669775660302957404338798347" +
                    "151855260280533386635713910104633641976909739743228599421983" +
                    "704697910995630338960467588986579571117656667003915674815311" +
                    "594398004362539939973120306649060132531130471902889849185620" +
                    "376666916446879112524919375442584589500031156168297430464114" +
                    "253807489728172337595538066171980140467793561479363526626568" +
                    "333950976000000000000000000000000000000000000000000000000000" +
                    "000000000000000000000000000000000000000000000000000000000000" +
                    "000000000000000000000000000000000000000000000000000000000000" +
                    "0000000"),Factorial.factorial(siedemDwaZero));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getLowestPrimeNumberExceptionTest(){
        try{
            PrimeNumber.getLowestPrimeNumber(zero);
            Assert.fail();
        } catch (Exception e){

        }

        try{
            PrimeNumber.getLowestPrimeNumber(jeden);
            Assert.fail();
        } catch (Exception e){

        }

        try{
            PrimeNumber.getLowestPrimeNumber(zero01);
            Assert.fail();
        } catch (Exception e){

        }

        try{
            PrimeNumber.getLowestPrimeNumber(zero00000000000000000001);
            Assert.fail();
        } catch (Exception e){

        }

        try{
            PrimeNumber.getLowestPrimeNumber(zero21474836595);
            Assert.fail();
        } catch (Exception e){

        }

        try{
            PrimeNumber.getLowestPrimeNumber(dwaJeden06);
            Assert.fail();
        } catch (Exception e){

        }


        try{
            PrimeNumber.getLowestPrimeNumber(minusZero00000000000000000001);
            Assert.fail();
        } catch (Exception e){

        }
    }
}
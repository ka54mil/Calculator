package com.example.panicz.calculator;

import com.example.panicz.calculator.Math.Calculations;
import com.example.panicz.calculator.Math.Constants;
import com.example.panicz.calculator.Math.Factorial;
import com.example.panicz.calculator.Math.PrimeNumber;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class CalculationsUnitTest {
    private Calculations test = new Calculations();
    private BigDecimal minusOneThreeFiveSevenFiveSixSevenEightNineZeroFiveDZiewiecZeroZeroEightNineFiveOneOneNineZeroZeroEightSix = new BigDecimal("-246456789104008951190086");
    private BigDecimal minusOneTwoThreeFourFiveSixSevenEightNineZeroFiveFourZeroZeroZeroNineFiveOneOneZeroZeroZeroOneEightSix = new BigDecimal("-123456789054000951100086");
    private BigDecimal minusOneTwoThreeZeroZeroZeroZeroZeroZeroZeroFiveZeroZeroZeroEightZeroZeroZeroZeroNineZeroZeroZeroZero = new BigDecimal("-123000000050008000090000");
    private BigDecimal minusSixFour = new BigDecimal(-64);
    private BigDecimal minusFour = new BigDecimal(-4);
    private BigDecimal minusTwo = new BigDecimal(-2);
    private BigDecimal minusZero00000000000000000001 = new BigDecimal("-0.00000000000000000001");
    private BigDecimal zero = new BigDecimal(0);
    private BigDecimal zero00000000000000000001 = new BigDecimal("0.00000000000000000001");
    private BigDecimal zero21474836595 = new BigDecimal("0.2147483595");
    private BigDecimal zero01 = new BigDecimal("0.01");
    private BigDecimal zero5 = new BigDecimal("0.5");
    private BigDecimal one = new BigDecimal(1);
    private BigDecimal two = new BigDecimal(2);
    private BigDecimal two34 = new BigDecimal("2.34");
    private BigDecimal two5 = new BigDecimal("2.5");
    private BigDecimal three = new BigDecimal(3);
    private BigDecimal four = new BigDecimal(4);
    private BigDecimal five = new BigDecimal(5);
    private BigDecimal six = new BigDecimal(6);
    private BigDecimal oneOne = new BigDecimal(11);
    private BigDecimal eight = new BigDecimal(8);
    private BigDecimal oneZero = new BigDecimal(10);
    private BigDecimal oneSix = new BigDecimal(16);
    private BigDecimal twoOne06 = new BigDecimal("21.06");
    private BigDecimal twoThree4 = new BigDecimal("23.4");
    private BigDecimal threeTwo = new BigDecimal(32);
    private BigDecimal sixFour = new BigDecimal(64);
    private BigDecimal sevenOne = new BigDecimal(71);
    private BigDecimal nineSeven = new BigDecimal(97);
    private BigDecimal nineNine = new BigDecimal(99);
    private BigDecimal sevenTwoZero = new BigDecimal(720);
    private BigDecimal nineFourZeroNine = new BigDecimal(9409);
    private BigDecimal nineSixZeroThree = new BigDecimal(9603);
    private BigDecimal oneSixNineSevenSevenFiveFourZeroEightSixThreeTwoOneFourDiewiecFiveThreeEightEightNineOne = new BigDecimal("169775408632149538891");
    private BigDecimal oneFiveFourEightTwoOneNineSixSevenSixNineThreeThreeZeroDziwecFourFiveZeroZeroOneEightSevenOne = new BigDecimal("15482196769330945001871");
    private BigDecimal oneFiveSixFiveOneNineSevenTwoOneSevenSevenNineSixThreeZeroNineFourFiveFourZeroSevenSixTwo = new BigDecimal("15651972177963094540762");
    private BigDecimal oneFiveSixFiveOneNineSevenTwoOneSevenSevenNineSixThreeZeroNineFourFiveFourZeroSevenSixone = new BigDecimal("15651972177963094540783").setScale(500,BigDecimal.ROUND_HALF_UP);

    @Test
    public void addTest(){
        Assert.assertEquals(four, test.add(two,two).stripTrailingZeros());
        Assert.assertEquals(twoThree4,test.add(twoOne06,two34).stripTrailingZeros());
        Assert.assertEquals(oneFiveSixFiveOneNineSevenTwoOneSevenSevenNineSixThreeZeroNineFourFiveFourZeroSevenSixTwo, test.add(oneFiveFourEightTwoOneNineSixSevenSixNineThreeThreeZeroDziwecFourFiveZeroZeroOneEightSevenOne, oneSixNineSevenSevenFiveFourZeroEightSixThreeTwoOneFourDiewiecFiveThreeEightEightNineOne).stripTrailingZeros());
        Assert.assertEquals(zero, test.add(zero00000000000000000001,minusZero00000000000000000001).stripTrailingZeros());
        Assert.assertEquals(minusOneThreeFiveSevenFiveSixSevenEightNineZeroFiveDZiewiecZeroZeroEightNineFiveOneOneNineZeroZeroEightSix, test.add(minusOneTwoThreeFourFiveSixSevenEightNineZeroFiveFourZeroZeroZeroNineFiveOneOneZeroZeroZeroOneEightSix,minusOneTwoThreeZeroZeroZeroZeroZeroZeroZeroFiveZeroZeroZeroEightZeroZeroZeroZeroNineZeroZeroZeroZero).stripTrailingZeros());
    }

    @Test
    public void rootTest(){
        BigDecimal X=test.pow(four, test.divide(BigDecimal.ONE,sixFour));
        System.out.println(X.toString());
        System.out.println(test.pow(X, sixFour.intValue()).toString());
        Assert.assertEquals(eight, test.root(sixFour, 2).stripTrailingZeros());
        Assert.assertEquals(four, test.root(sixFour, 3).stripTrailingZeros());
        Assert.assertEquals(minusFour, test.root(minusSixFour, 3).stripTrailingZeros());
        Assert.assertEquals(two, test.root(sixFour, 6).stripTrailingZeros());
        System.out.println(test.pow(one,two).toPlainString());
    }

    @Test
    public void gCDTest(){
        Assert.assertEquals(eight, test.gCD(sixFour, eight).stripTrailingZeros());
        Assert.assertEquals(four, test.gCD(sixFour, minusFour).stripTrailingZeros());
        Assert.assertEquals(two, test.gCD(minusSixFour, two).stripTrailingZeros());
        Assert.assertEquals(four, test.gCD(four, minusFour).stripTrailingZeros());
    }

    @Test
    public void getLowestPrimeNumberTest(){
        try{
            Assert.assertEquals(two, PrimeNumber.getLowestPrimeNumber(eight).stripTrailingZeros());
            Assert.assertEquals(two, PrimeNumber.getLowestPrimeNumber(minusFour).stripTrailingZeros());
            Assert.assertEquals(three, PrimeNumber.getLowestPrimeNumber(three).stripTrailingZeros());
            Assert.assertEquals(two, PrimeNumber.getLowestPrimeNumber(minusTwo).stripTrailingZeros());
            Assert.assertEquals(nineSeven, PrimeNumber.getLowestPrimeNumber(nineSeven).stripTrailingZeros());
            Assert.assertEquals(nineSeven, PrimeNumber.getLowestPrimeNumber(nineFourZeroNine).stripTrailingZeros());
            Assert.assertEquals(three, PrimeNumber.getLowestPrimeNumber(nineSixZeroThree).stripTrailingZeros());
            Assert.assertEquals(two, PrimeNumber.getLowestPrimeNumber(minusOneThreeFiveSevenFiveSixSevenEightNineZeroFiveDZiewiecZeroZeroEightNineFiveOneOneNineZeroZeroEightSix).stripTrailingZeros());
            Assert.assertEquals(sevenOne, PrimeNumber.getLowestPrimeNumber(oneSixNineSevenSevenFiveFourZeroEightSixThreeTwoOneFourDiewiecFiveThreeEightEightNineOne).stripTrailingZeros());
//            Assert.assertEquals(oneFiveSixFiveOneNineSevenTwoOneSevenSevenNineSixThreeZeroNineFourFiveFourZeroSevenSixone, Exponentiation.pow(two,oneFiveSixFiveOneNineSevenTwoOneSevenSevenNineSixThreeZeroNineFourFiveFourZeroSevenSixone,500, BigDecimal.ROUND_HALF_UP).stripTrailingZeros());

        } catch (Exception e){
            e.printStackTrace();
        }

    }

    @Test
    public void factorialTest(){
        try {
            Assert.assertEquals(two, Factorial.factorial(two));
            Assert.assertEquals(six, Factorial.factorial(three));
            Assert.assertEquals(sevenTwoZero, Factorial.factorial(six));
            Assert.assertEquals(new BigDecimal(
                    "126886932185884164103433389335161480802865516174545192198801"+
                    "894375214704230400000000000000"), Factorial.factorial(sixFour));
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
                    "0000000"),Factorial.factorial(sevenTwoZero));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void sumInvertedFactorialTest(){
        try {
            Assert.assertEquals(two, Factorial.sumInvertedFactorial(1));
            Assert.assertEquals(one, Factorial.sumInvertedFactorial(0));
            Assert.assertEquals(two5, Factorial.sumInvertedFactorial(2));
            Assert.assertEquals(new BigDecimal("2.718281527"), Factorial.sumInvertedFactorial(9));
            Constants.getE(7000);
            Constants.getE(20000);
            Assert.assertEquals(new BigDecimal(
                    "2.7182818284590452353602874713526624977572470936999595749669" +
                    "676277240766303535475945713821785251664274274663919320030599" +
                    "218174135966290435729003342952605956307381323286279434907632" +
                    "338298807531952510190115738341879307021540891499348841675092" +
                    "447614606680822648001684774118537423454424371075390777449920" +
                    "695517027618386062613313845830007520449338265602976067371132" +
                    "007093287091274437470472306969772093101416928368190255151086" +
                    "574637721112523897844250569536967707854499699679468644549059" +
                    "879316368892300987931277361782154249992295763514822082698951" +
                    "936680331825288693984964651058209392398294887933203625094431" +
                    "173012381970684161403970198376793206832823764648042953118023" +
                    "287825098194558153017567173613320698112509961818815930416903" +
                    "515988885193458072738667385894228792284998920868058257492796" +
                    "104841984443634632449684875602336248270419786232090021609902" +
                    "353043699418491463140934317381436405462531520961836908887070" +
                    "167683964243781405927145635490613031072085103837505101157477" +
                    "041718986106873969655212671546889570350354"),Constants.getE(1000));
            Assert.assertEquals(new BigDecimal(
                    "2.7182818284590452353602874713526624977572470936999595749669" +
                            "676277240766303535475945713821785251664274274663919320030599" +
                            "218174135966290435729003342952605956307381323286279434907632" +
                            "338298807531952510190115738341879307021540891499348841675092" +
                            "447614606680822648001684774118537423454424371075390777449920" +
                            "695517027618386062613313845830007520449338265602976067371132" +
                            "007093287091274437470472306969772093101416928368190255151086" +
                            "574637721112523897844250569536967707854499699679468644549059" +
                            "879316368892300987931277361782154249992295763514822082698951" +
                            "936680331825288693984964651058209392398294887933203625094431" +
                            "173012381970684161403970198376793206832823764648042953118023" +
                            "287825098194558153017567173613320698112509961818815930416903" +
                            "515988885193458072738667385894228792284998920868058257492796" +
                            "104841984443634632449684875602336248270419786232090021609902" +
                            "353043699418491463140934317381436405462531520961836908887070" +
                            "167683964243781405927145635490613031072085103837505101157477" +
                            "0417189861068739696552126715468895703504"),Constants.getE(998));
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
            PrimeNumber.getLowestPrimeNumber(one);
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
            PrimeNumber.getLowestPrimeNumber(twoOne06);
            Assert.fail();
        } catch (Exception e){

        }


        try{
            PrimeNumber.getLowestPrimeNumber(minusZero00000000000000000001);
            Assert.fail();
        } catch (Exception e){

        }
    }

    @Test
    public void sumInvertedFactorialExceptionTest(){
        try{
            Factorial.sumInvertedFactorial(-3);
            Assert.fail();
        } catch (Exception e){

        }

    }
}
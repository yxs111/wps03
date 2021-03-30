package com.company;

import java.math.BigDecimal;

public class BigDecimalUtil {


    public BigDecimal addThree(BigDecimal one, BigDecimal two, BigDecimal three){
        BigDecimal textOne = one.add(two);

        BigDecimal max =  textOne.add(three);

        return max.setScale(2, BigDecimal.ROUND_HALF_UP);
    }
    public BigDecimal addFour(BigDecimal one,BigDecimal two,BigDecimal three,BigDecimal four){
        BigDecimal textOne = one.add(two);
        BigDecimal textTwo = three.add(four);
        BigDecimal max =  textOne.add(textTwo);

        return max.setScale(2, BigDecimal.ROUND_HALF_UP);
    }
    public BigDecimal addTen(BigDecimal bigDecimal1,BigDecimal bigDecimal2,BigDecimal bigDecimal3,BigDecimal bigDecimal4,BigDecimal bigDecimal5,
                             BigDecimal bigDecimal6,BigDecimal bigDecimal7,BigDecimal bigDecimal8,BigDecimal bigDecimal9,BigDecimal bigDecimal10){
        BigDecimal textOneAndTwo = bigDecimal1.add(bigDecimal2);
        BigDecimal textThreeAndFour = bigDecimal3.add(bigDecimal4);
        BigDecimal textFiveAndSix = bigDecimal5.add(bigDecimal6);
        BigDecimal textSevenAndEight = bigDecimal7.add(bigDecimal8);
        BigDecimal textNineAndTen = bigDecimal9.add(bigDecimal10);
        BigDecimal OneTwoThreeFour = textOneAndTwo.add(textThreeAndFour);
        BigDecimal FiveSixSevenEight = textFiveAndSix.add(textSevenAndEight);

        BigDecimal max1 = OneTwoThreeFour.add(textNineAndTen);
        BigDecimal max = max1.add(FiveSixSevenEight);
        return max.setScale(2, BigDecimal.ROUND_HALF_UP);
    }
}

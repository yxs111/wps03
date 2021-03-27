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
}

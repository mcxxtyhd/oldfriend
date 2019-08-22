package com.feng.oldfriend.Utils;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author ：yangchenxiao
 * @date ：Created in 2019/8/11 16:26
 * @description：
 */
public class test {

    public static void main(String[] args) throws Exception{
        List<Integer> newList=new ArrayList<>();



        System.out.println(MathUtils.convertToStar(newList));

        System.out.println(MathUtils.getAgeByBirth(MathUtils.convertToDate("1914-08-17")));
    }
}

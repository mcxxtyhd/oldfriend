package com.feng.oldfriend.Utils;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author ：yangchenxiao
 * @date ：Created in 2019/8/20 20:33
 * @description：
 */
public class MathUtils {

    public static String convertToStar(List<Integer> allDatas){
        Double result=0.0;

        for(Integer single:allDatas){
            result+=single;
        }
        if(allDatas.size()!=0)result/=allDatas.size();

        if(result!=0){
            DecimalFormat df = new DecimalFormat("#.0");
            return df.format(result);
        }else{
            DecimalFormat df = new DecimalFormat("#");
            return df.format(result);
        }
    }

    public static int getAgeByBirth(Date birthDay) throws ParseException {
        int age = 0;
        if(null!=birthDay){
            Calendar cal = Calendar.getInstance();
            if (cal.before(birthDay)) { //出生日期晚于当前时间，无法计算
                throw new IllegalArgumentException(
                        "The birthDay is before Now.It's unbelievable!");
            }
            int yearNow = cal.get(Calendar.YEAR);  //当前年份
            int monthNow = cal.get(Calendar.MONTH);  //当前月份
            int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH); //当前日期
            cal.setTime(birthDay);
            int yearBirth = cal.get(Calendar.YEAR);
            int monthBirth = cal.get(Calendar.MONTH);
            int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);
            age = yearNow - yearBirth;   //计算整岁数
            if (monthNow <= monthBirth) {
                if (monthNow == monthBirth) {
                    if (dayOfMonthNow < dayOfMonthBirth) age--;//当前日期在生日之前，年龄减一
                } else {
                    age--;//当前月份在生日之前，年龄减一
                }
            }
        }

        return age;
    }

    public static Date convertToDate(String strDate) throws Exception{
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.parse(strDate);
    }


}

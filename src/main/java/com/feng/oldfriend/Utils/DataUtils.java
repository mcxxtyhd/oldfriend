package com.feng.oldfriend.Utils;

import io.swagger.models.auth.In;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author ：yangchenxiao
 * @date ：Created in 2019/9/10 22:25
 * @description：
 */
public class DataUtils {

    public static Integer getMinutes(String beginDate,String endDate) throws Exception{
        SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        Date d1 = simpleFormat.parse(beginDate);
        Date d2 = simpleFormat.parse(endDate);
        long diff = d2.getTime() - d1.getTime();//这样得到的差值是微秒级别
        long minutes = diff / (1000 * 60);

        return (int) minutes;
    }

    public static Integer getMinutes(Date beginDate,Date endDate) throws Exception{
        long diff = endDate.getTime() - beginDate.getTime();//这样得到的差值是微秒级别
        long minutes = diff / (1000*60);

        return (int) minutes;
    }
}

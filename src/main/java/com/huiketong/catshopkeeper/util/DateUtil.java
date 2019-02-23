package com.huiketong.catshopkeeper.util;



import com.huiketong.catshopkeeper.exception.DateException;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *    处理日期   工具类
 */
public class DateUtil {

    /**
     * 字符串日期转日期格式日期
     * @param strDate 字符串日期
     * @param dateFormat 字符串日期格式
     * @return
     */
    public static Date strToDate(String strDate,String dateFormat) throws DateException {
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        Date date = null;
        try {
            date = sdf.parse(strDate);
        } catch (Exception e) {
            e.printStackTrace();
            throw new DateException("日期格式转换出错");
        }

        return date;
    }

    /**
     * 将日期转换为字符串日期
     * @param date 日期
     * @param tarDateFormat 日期格式
     * @return
     */
    public static String dateToStr(Date date,String tarDateFormat){

        return new SimpleDateFormat(tarDateFormat).format(date);
    }

    /**
     * date2比date1多的天数
     * @param date1
     * @param date2
     * @return
     */
    public static int differentDays(Date date1,Date date2)
    {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        int day1= cal1.get(Calendar.DAY_OF_YEAR);
        int day2 = cal2.get(Calendar.DAY_OF_YEAR);

        int year1 = cal1.get(Calendar.YEAR);
        int year2 = cal2.get(Calendar.YEAR);
        if(year1 != year2)   //同一年
        {
            int timeDistance = 0 ;
            for(int i = year1 ; i < year2 ; i ++)
            {
                if(i%4==0 && i%100!=0 || i%400==0)    //闰年
                {
                    timeDistance += 366;
                }
                else    //不是闰年
                {
                    timeDistance += 365;
                }
            }

            return timeDistance + (day2-day1) ;
        }
        else    //不同年
        {
            return day2-day1;
        }
    }

}

package com.yxl.magicbox.utils;

import com.yxl.magicbox.exceptions.YRunTimeException;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 封装对日期处理的常用方法
 */
public class DateUtils {

    /**
     * 判断字符串能否转为日期yyyyMMdd
     * @param str
     * @return
     */
    public static boolean isDate(String str) {
        return RegexCheckUtils.checkDate1(str);
    }
    /**
     * 判断字符串能否转为日期yyyy-MM-dd
     * @param str
     * @return
     */
    public static boolean isDateWithDash(String str) {
        return RegexCheckUtils.checkDate2(str);
    }
    /**
     * 判断字符串能否转为日期yyyy-MM-dd
     * @param str
     * @return
     */
    public static boolean isDateWithSlash(String str) {
        return RegexCheckUtils.checkDate3(str);
    }

    /**
     * 例子：
     * 传入{ date:new Date(),months: 24 } 得到指定日期往后24个月的日期
     * 传入{ date:new Date(),months: -18 } 得到指定日期往前18个月的日期
     *
     * @param date   日期
     * @param months 月份数
     * @return
     */
    public static Date monthsAfterNow(Date date, int months) {

        return calculate(date,months,Calendar.MONTH);
    }

    /**
     * 例子：
     * 传入{ date:new Date(),months: 24 } 得到指定日期往前24个月的日期
     * 传入{ date:new Date(),months: -18 } 得到指定日期往后18个月的日期
     *
     * @param date   日期
     * @param months 月份数
     * @return
     */
    public static Date monthsBeforeNow(Date date, int months) {
        return monthsAfterNow(date, -months);
    }

    public static Date calculate(Date date, int count, int field) {
        boolean b;
        switch (field) {
            case Calendar.YEAR:
            case Calendar.MONTH:
            case Calendar.DATE:
                b = true;
                break;
            default:
                b = false;
                break;
        }
        if(!b){
            //TODO
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(field, count);
        return calendar.getTime();
    }

    public static Date yearsAfterNow(Date date, int years) {
        return calculate(date,years,Calendar.YEAR);
    }
    public static Date yearsBeforeNow(Date date, int years) {
        return yearsAfterNow(date,-years);
    }
    public static Date daysAfterNow(Date date, int days) {
        return calculate(date,days,Calendar.DATE);
    }
    public static Date daysBeforeNow(Date date, int days) {
        return daysAfterNow(date,-days);
    }
    public static Date tomorrow(Date date){
        return daysAfterNow(date,1);
    }
    public static Date theDayAfterTomorrow(Date date){
        return daysAfterNow(date,2);
    }
    public static Date yesterday(Date date){
        return daysBeforeNow(date,1);
    }


    /**
     * 字符串转为日期
     * 例如：将"20200101"按照yyyyMMdd格式转为Date类型
     * @param str 8位数字字符串
     * @return
     */
    public static Date str2Date(String str){
        if(isDate(str)){
            SimpleDateFormat str2Date = new SimpleDateFormat("yyyyMMdd");
            try{
                return str2Date.parse(str);
            }catch (Exception e){
                e.printStackTrace();
            }
        }else{
            throw new YRunTimeException("此字符串不能转为"+Date.class+"类型");
        }
        return null;
    }

    /**
     * 日期字符串增加分隔符
     * 例如：将日期字符串"20200101"增加分隔符"2020-01-01"
     * @param str 8位数字字符串
     * @return
     */
    public static String formatDateStr(String str,String separator){
        if(isDate(str)){
            SimpleDateFormat str2Date = new SimpleDateFormat("yyyyMMdd");
            String patternChar = separator==null?"-":separator;
            String pattern = new StringBuffer("yyyy").append(patternChar).append("MM").append(patternChar).append("dd").toString();
            SimpleDateFormat date2DateWithPattern = new SimpleDateFormat(pattern);
            try{
                return date2DateWithPattern.format(str2Date.parse(str));
            }catch (Exception e){
                e.printStackTrace();
            }
        }else{
            throw new YRunTimeException("err");
        }
        return null;
    }


}

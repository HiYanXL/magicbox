package com.yxl.magicbox.utils;

import com.yxl.magicbox.constants.RegexPattern;

import java.util.regex.Pattern;

public class RegexCheckUtils {
    /**
     * 校验字符串是否可转为日期
     *
     * @param pattern 日期的正则表达式
     * @param dateStr 字符串
     * @return true 能 false 否
     */
    private static Boolean checkDate(String pattern, String dateStr) {
        if (dateStr != null) {
            return Pattern.matches(pattern, dateStr);
        }
        return Boolean.FALSE;
    }

    /**
     * 校验字符串是否为日期格式: yyyyMMdd 或 yyyy-MM-dd 或 yyyy/MM/dd
     * 例如："20191221" "2019-12-21" "2019/12/21"
     *
     * @param dateStr
     * @return
     */
    public static Boolean checkDatePlus(String dateStr) {
        return checkDate1(dateStr) || checkDate2(dateStr) || checkDate3(dateStr);
    }

    /**
     * 校验字符串是否为日期格式: yyyyMMdd
     * 例如："20191221"
     *
     * @param dateStr
     * @return
     */
    public static Boolean checkDate1(String dateStr) {
        return checkDate(RegexPattern.DatePattern.DateStyle1, dateStr);
    }

    /**
     * 校验字符串是否为日期格式: yyyy-MM-dd
     * 例如："2019-12-21"
     *
     * @param dateStr
     * @return
     */
    public static Boolean checkDate2(String dateStr) {
        return checkDate(RegexPattern.DatePattern.DateStyle2, dateStr);
    }

    /**
     * 校验字符串是否为日期格式: yyyy/MM/dd
     * 例如："2019/12/21"
     *
     * @param dateStr
     * @return
     */
    public static Boolean checkDate3(String dateStr) {
        return checkDate(RegexPattern.DatePattern.DateStyle3, dateStr);
    }
}

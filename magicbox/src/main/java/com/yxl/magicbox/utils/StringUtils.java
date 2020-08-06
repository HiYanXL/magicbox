package com.yxl.magicbox.utils;

import com.yxl.magicbox.constants.RegexPattern;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * 自己开发的SpringUtils
 * 基于org.apache.commons.lang3.StringUtils
 */
public class StringUtils extends org.apache.commons.lang3.StringUtils {

    public static boolean isSingleLowerLetter(String str) {
        if (str != null) {
            return Pattern.matches(RegexPattern.StringPattern.SingleLowerLetter, str);
        }
        return false;
    }

    public static boolean isSingleUpperLetter(String str) {
        if (str != null) {
            return Pattern.matches(RegexPattern.StringPattern.SingleUpperLetter, str);
        }
        return false;
    }

    public static boolean isSingleLetter(String str) {

        return isSingleLowerLetter(str) || isSingleUpperLetter(str);
        
    }


    public static String dealUnderscore(String str) {
        if (StringUtils.isNotEmpty(str) && str.indexOf("_") != -1) {
            String[] strings = str.toLowerCase().split("_");
            StringBuffer sb = new StringBuffer(strings[0]);
            for (int i = 1; i < strings.length; i++) {
                sb.append(firstCharUpper(strings[i]));
            }
            return sb.toString();
        }
        //TODO log
        return str;
    }

    public static String firstCharUpper(String str) {
        if (StringUtils.isEmpty(str)) {
            //TODO log
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    public static String firstCharLower(String str) {
        if (StringUtils.isEmpty(str)) {
            //TODO log
            return str;
        }
        return str.substring(0, 1).toLowerCase() + str.substring(1);
    }

    /**
     * 计算字符串中的不同字符的个数
     *
     * @param str
     * @return
     */
    public static Map<Object, Object> getRepeatCharAndNum(String str) {
        if (isNotEmpty(str)) {
            char[] chars = str.toCharArray();
            Map<Object, Object> map = new HashMap<>();
            for (int i = 0; i < chars.length; i++) {
                String key = String.valueOf(chars[i]);
                if (map.containsKey(key)) {
                    int value = (int) map.get(key);
                    map.put(key, value + 1);
                } else {
                    map.put(key, 1);
                }
            }
            return map;
        }
        return null;
    }

}

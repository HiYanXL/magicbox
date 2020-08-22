package com.yxl.magicbox.utils;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.text.DecimalFormat;

public class NumberFormatUtils {
    private static final String defaultPattern = "#,###,##0.00";

    /**
     * 对数字进行格式化
     * 先判断str是否为Numeric
     *
     * @param str
     * @return
     */
    public static String format(String str) {
        return format(str, true);
    }

    /**
     * 对数字进行格式化
     *
     * @param str
     * @param b   默认true,对str格式化之前先判断是否为Numeric；若为false,直接格式化str,对于0.或者.0或者.这些值也能格式化
     * @return
     */
    public static String format(@NotNull String str, boolean b) {
        if (b) {
            if (isNotNumber(str)) {
                return null;
            }
        }
        // 增加对.的兼容
        if (".".equals(str)) {
            str = "0";
        }
        DecimalFormat decimalFormat = new DecimalFormat(defaultPattern);
        try {
            BigDecimal bigDecimal = new BigDecimal(str);
            return decimalFormat.format(bigDecimal);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 判断字符串是否可转为数字
     *
     * @param number
     * @return 可转为数字，即可成为new BigDecimal()的参数
     */
    public static boolean isNumber(@NotNull String number) {
        if (number == null) {
            return false;
        }
        int index = number.indexOf(".");
        if (index < 0) {
            return StringUtils.isNumeric(number);
        } else {
            String num1 = number.substring(0, index);
            String num2 = number.substring(index + 1);
            return StringUtils.isNumeric(num1) && StringUtils.isNumeric(num2);
        }
    }

    public static boolean isNotNumber(@NotNull String number) {
        return !isNumber(number);
    }
}

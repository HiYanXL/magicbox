package com.yxl.magicbox.utils;

/**
 * 测试类打印输出时使用分割线隔开方便看输出结果
 */
public class PrintSeparatorUtils {

    /**
     * 默认字符串长度
     */
    private static final int defaultLength = 32;
    /**
     * 字符串最大长度
     */
    private static final int maxLength = 1024;
    /**
     * 默认字符串：用于拼接分割线
     */
    private static final String defaultSeparator = "-";


    public static String get32Dash() {
        return montage(defaultLength, defaultSeparator);
    }

    /**
     * 根据输入的字符串和字符串个数拼接分割线
     *
     * @param num
     * @param str
     * @return
     */
    private static String montage(int num, String str) {
        String separator = (str == null || str.trim() == "") ? defaultSeparator : str;
        StringBuffer sb = new StringBuffer();
        int length = (num > 0) ? (num < maxLength) ? num : maxLength : defaultLength;
        for (int i = 0; i < length; i++) {
            sb.append(separator);
        }
        return sb.toString();
    }

    /**
     * 根据输入的字符串和字符串个数打印分割线
     *
     * @param num
     * @param str
     */
    public static void print(int num, String str) {
        System.out.println(montage(num, str));
    }

    /**
     * 打印默认分割线
     */
    public static void print() {
        print(defaultLength, defaultSeparator);
    }

    /**
     * 根据输入的字符串个数打印分割线
     *
     * @param num
     */
    public static void print(int num) {
        print(num, defaultSeparator);
    }

    /**
     * 根据输入的字符串打印分割线
     *
     * @param str
     */
    public static void print(String str) {
        print(defaultLength, str);
    }
}

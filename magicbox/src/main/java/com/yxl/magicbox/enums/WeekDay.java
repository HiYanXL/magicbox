package com.yxl.magicbox.enums;

public enum WeekDay {
    /**
     * 星期日
     */
    Sunday,
    /**
     * 星期一
     */
    Monday,
    /**
     * 星期二
     */
    Tuesday,
    /**
     * 星期三
     */
    Wednesday,
    /**
     * 星期四
     */
    Thursday,
    /**
     * 星期五
     */
    Friday,
    /**
     * 星期六
     */
    Saturday;

    private static WeekDay[] weekDays = WeekDay.values();

    public static String showWeekDays() {
        StringBuffer sb = new StringBuffer();
        sb.append("WeekDays:");
        int size = weekDays.length;
        for (int i = 0; i < size; i++) {
            sb.append(" ").append(weekDays[i]);
        }
        return sb.toString();
    }

    private static Boolean include(String str, Boolean ignoreCaseFlag) {
        if (str == null) {
            return false;
        }
        if (ignoreCaseFlag) {
            for (int i = 0; i < weekDays.length; i++) {
                if (str.equalsIgnoreCase(weekDays[i].toString())) {
                    return true;
                }
            }
        } else {
            for (int i = 0; i < weekDays.length; i++) {
                if (str.equals(weekDays[i].toString())) {
                    return true;
                }
            }
        }
        return false;
    }
    public static Boolean contains(String str){
        return include(str,Boolean.FALSE);
    }
    public static Boolean containsIgnoreCase(String str){
        return include(str,Boolean.TRUE);
    }
}

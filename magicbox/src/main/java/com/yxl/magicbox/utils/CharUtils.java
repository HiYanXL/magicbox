package com.yxl.magicbox.utils;

public class CharUtils {
    public static boolean isLetter(char c) {
        return isLowerLetter(c) || isUpperLetter(c);
    }

    public static boolean isUpperLetter(char c) {
        int i = (int) c;
        return (i >= 65 && i <= 90);
    }

    public static boolean isLowerLetter(char c) {
        int i = (int) c;
        return (i >= 97 && i <= 122);
    }
}

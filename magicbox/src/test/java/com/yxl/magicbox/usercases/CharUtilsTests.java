package com.yxl.magicbox.usercases;

import com.yxl.magicbox.MagicboxApplicationTests;
import com.yxl.magicbox.utils.CharUtils;
import com.yxl.magicbox.utils.PrintSeparatorUtils;
import org.junit.Test;

public class CharUtilsTests extends MagicboxApplicationTests {
    @Test
    public void testIsLetter() {
        String str = "Hello world! I am a zooKeeper.";
        for (int i = 0; i < str.length(); i++) {
            char c = str.toCharArray()[i];
            System.out.println(c);
            System.out.println(CharUtils.isLetter(c));
            System.out.println(CharUtils.isLowerLetter(c));
            System.out.println(CharUtils.isUpperLetter(c));

            PrintSeparatorUtils.print();
        }
    }

}

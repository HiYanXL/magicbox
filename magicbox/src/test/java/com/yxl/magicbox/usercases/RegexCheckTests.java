package com.yxl.magicbox.usercases;

import com.yxl.magicbox.MagicboxApplicationTests;
import com.yxl.magicbox.enums.WeekDay;
import com.yxl.magicbox.utils.PrintSeparatorUtils;
import com.yxl.magicbox.utils.RegexCheckUtils;
import org.junit.Test;

import java.util.Arrays;

public class RegexCheckTests extends MagicboxApplicationTests {
    @Test
    public void testCheckDatePlus() {
        String[] str = {
                "20200101",
                "2020-01-01",
                "2020/21/01",
                "2021/02/29",
                "2020/01/01",
                null
        };
        for (int i = 0; i < str.length; i++) {
            System.out.println(str[i]+": "+RegexCheckUtils.checkDatePlus(str[i]));
        }
    }

    @Test
    public void testCheckDate1() {
        String[] str = {
                "20200101",
                "2020-01-01",
                "20202101",
                "20210229",
                "2020/01/01"
        };
        for (int i = 0; i < str.length; i++) {
            System.out.println(str[i]+": "+RegexCheckUtils.checkDate1(str[i]));
        }
    }

    @Test
    public void testCheckDate2() {
        String[] str = {
                "20200101",
                "2020-01-01",
                "2020-21-01",
                "2021-02-29",
                "2020/01/01"
        };
        for (int i = 0; i < str.length; i++) {
            System.out.println(str[i]+": "+RegexCheckUtils.checkDate2(str[i]));
        }
    }

    @Test
    public void testCheckDate3() {
        String[] str = {
                "20200101",
                "2020-01-01",
                "2020/21/01",
                "2021/02/29",
                "2020/01/01"
        };
        for (int i = 0; i < str.length; i++) {
            System.out.println(str[i]+": "+RegexCheckUtils.checkDate3(str[i]));
        }
    }

}

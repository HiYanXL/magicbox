package com.yxl.magicbox.usercases;

import com.yxl.magicbox.MagicboxApplicationTests;
import com.yxl.magicbox.enums.WeekDay;
import com.yxl.magicbox.utils.PrintSeparatorUtils;
import org.junit.Test;

import java.util.Arrays;

public class WeekDayTests extends MagicboxApplicationTests {
    @Test
    public void testWeekDay(){
        System.out.println(WeekDay.Monday);
        System.out.println(WeekDay.showWeekDays());
        System.out.println(Arrays.toString(WeekDay.values()));
    }
    @Test
    public void testContains(){

        System.out.println(WeekDay.contains(null));
        System.out.println(WeekDay.contains(""));

        System.out.println(WeekDay.contains("Friday"));
        System.out.println(WeekDay.contains("friday"));

        PrintSeparatorUtils.print();

        System.out.println(WeekDay.containsIgnoreCase(null));
        System.out.println(WeekDay.containsIgnoreCase(""));

        System.out.println(WeekDay.containsIgnoreCase("Friday"));
        System.out.println(WeekDay.containsIgnoreCase("friday"));

    }
}

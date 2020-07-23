package com.yxl.magicbox.usercases;

import com.yxl.magicbox.MagicboxApplicationTests;
import com.yxl.magicbox.utils.NumberFormatUtils;
import com.yxl.magicbox.utils.PrintSeparatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

public class NumberFormatUtilsTests extends MagicboxApplicationTests {

    @Test
    public void testFormat() {

        System.out.println(StringUtils.isNumeric(".0"));

        PrintSeparatorUtils.print();

        System.out.println(NumberFormatUtils.isNotNumber(""));
        System.out.println(NumberFormatUtils.isNotNumber(null));

        PrintSeparatorUtils.print();

        System.out.println(NumberFormatUtils.format(""));
        System.out.println(NumberFormatUtils.format("0."));
        System.out.println(NumberFormatUtils.format("0"));
        System.out.println(NumberFormatUtils.format("."));
        System.out.println(NumberFormatUtils.format(".0"));

        PrintSeparatorUtils.print();

        System.out.println(NumberFormatUtils.format("100"));
        System.out.println(NumberFormatUtils.format("1000.1"));
        System.out.println(NumberFormatUtils.format("10000.1"));
        System.out.println(NumberFormatUtils.format("1000000"));

        PrintSeparatorUtils.print();
        System.out.println(NumberFormatUtils.format("0.001"));
        System.out.println(NumberFormatUtils.format("0.00000099"));
        System.out.println(NumberFormatUtils.format("0.00999999"));
    }

    @Test
    public void testFormatPlus() {

        PrintSeparatorUtils.print();

        System.out.println(NumberFormatUtils.format("0.", false));
        System.out.println(NumberFormatUtils.format("0.", true));

        PrintSeparatorUtils.print();

        System.out.println(NumberFormatUtils.format(".",false));
        System.out.println(NumberFormatUtils.format("."));

        PrintSeparatorUtils.print();

        System.out.println(NumberFormatUtils.format(".0",false));
        System.out.println(NumberFormatUtils.format(".0"));

        PrintSeparatorUtils.print();

        System.out.println(NumberFormatUtils.format(null,false));
        System.out.println(NumberFormatUtils.format(null));
    }

}

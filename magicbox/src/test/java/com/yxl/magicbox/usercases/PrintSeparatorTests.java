package com.yxl.magicbox.usercases;

import com.yxl.magicbox.MagicboxApplicationTests;
import com.yxl.magicbox.utils.PrintSeparatorUtils;
import org.junit.Test;

public class PrintSeparatorTests extends MagicboxApplicationTests {

    @Test
    public void testPrintSeparator(){

        PrintSeparatorUtils.print();
        PrintSeparatorUtils.print(-1);
        PrintSeparatorUtils.print(12);
        PrintSeparatorUtils.print(-1,null);
        PrintSeparatorUtils.print(12,null);
        PrintSeparatorUtils.print(12,"=");
        PrintSeparatorUtils.print(12,"++");
        PrintSeparatorUtils.print("++");
        PrintSeparatorUtils.print(null);
        PrintSeparatorUtils.print("\n");


    }
}

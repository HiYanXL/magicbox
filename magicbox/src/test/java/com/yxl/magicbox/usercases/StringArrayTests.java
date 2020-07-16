package com.yxl.magicbox.usercases;

import com.yxl.magicbox.MagicboxApplicationTests;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.Arrays;

public class StringArrayTests extends MagicboxApplicationTests {
    @Test
    public void testStringArray(){
        String str = "Hello world!";
        String[] strArr = {str};
        System.out.println(Arrays.toString(strArr));
    }
}

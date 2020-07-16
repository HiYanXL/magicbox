package com.yxl.magicbox.usercases;

import com.yxl.magicbox.MagicboxApplicationTests;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

public class StringUtilsTests extends MagicboxApplicationTests {
    @Test
    public void testNotBlank(){
        String str = "hello world!";
        Boolean b = StringUtils.isNotBlank(str);
        System.out.println(b);
    }
}

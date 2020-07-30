package com.yxl.magicbox.usercases;

import com.yxl.magicbox.MagicboxApplicationTests;
import com.yxl.magicbox.utils.PrintCollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.Map;

public class StringUtilsTests extends MagicboxApplicationTests {
    @Test
    public void testNotBlank(){
        String str = "hello world!";
        Boolean b = StringUtils.isNotBlank(str);
        System.out.println(b);
    }
    @Test
    public void testGetRepeatCharAndNum(){
        String str = "hello world!I am a man.I like singing very much.Every weekend,i would go to my uncle,who is major in violin,for training";

        Map<Object,Object> map = com.yxl.magicbox.utils.StringUtils.getRepeatCharAndNum(str);
        PrintCollectionUtils.print(map);
    }
}

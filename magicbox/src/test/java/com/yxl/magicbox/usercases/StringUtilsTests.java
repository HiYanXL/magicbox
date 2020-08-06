package com.yxl.magicbox.usercases;

import com.yxl.magicbox.MagicboxApplicationTests;
import com.yxl.magicbox.utils.PrintCollectionUtils;
import com.yxl.magicbox.utils.StringUtils;
import org.junit.Test;

import java.util.Map;

public class StringUtilsTests extends MagicboxApplicationTests {
    @Test
    public void testIsSingleLetter() {
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        for (int i = 0; i <= 127; i++) {
            char c = (char) i;
            String str = String.valueOf(c);
            if (StringUtils.isSingleLetter(str)) {
                count1++;
            }
            if (StringUtils.isSingleLowerLetter(str)) {
                count2++;
            }
            if (StringUtils.isSingleUpperLetter(str)) {
                count3++;
            }
        }
        System.out.println(count1);
        System.out.println(count2);
        System.out.println(count3);
    }

    @Test
    public void testDealUnderscore() {
        String str = "PRD_NAME";
        String result = StringUtils.dealUnderscore(str);
        System.out.println(result);
    }

    @Test
    public void testNotBlank() {
        String str = "hello world!";
        Boolean b = StringUtils.isNotBlank(str);
        System.out.println(b);
    }

    @Test
    public void testGetRepeatCharAndNum() {
        String str = "hello world!I am a man.I like singing very much.Every weekend,i would go to my uncle,who is major in violin,for training";

        Map<Object, Object> map = com.yxl.magicbox.utils.StringUtils.getRepeatCharAndNum(str);
        PrintCollectionUtils.print(map);
    }
}

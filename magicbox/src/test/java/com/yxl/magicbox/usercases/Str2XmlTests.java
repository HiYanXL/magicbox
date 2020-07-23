package com.yxl.magicbox.usercases;

import com.yxl.magicbox.MagicboxApplicationTests;
import com.yxl.magicbox.utils.Str2XmlUtils;
import org.junit.Test;

public class Str2XmlTests extends MagicboxApplicationTests {
    @Test
    public void testStr2Xml(){
        String str = "<?xml version=\"1.0\" encoding=\"utf-8\" ?><bookstore>1</bookstore>";
        Str2XmlUtils.transform(str);
    }

}

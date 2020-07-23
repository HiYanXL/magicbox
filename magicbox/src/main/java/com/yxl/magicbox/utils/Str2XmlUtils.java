package com.yxl.magicbox.utils;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.ByteArrayInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class Str2XmlUtils {

    public static void transform(String str){

        SAXReader saxReader = new SAXReader();
        try {
            Document document = saxReader.read(new ByteArrayInputStream(str.getBytes("UTF-8")));
            OutputFormat format = OutputFormat.createPrettyPrint();
            XMLWriter writer = new XMLWriter(new FileWriter("./src/test/java/com/yxl/magicbox/usercases/files/result.xml"));
            writer.write(document);
            writer.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

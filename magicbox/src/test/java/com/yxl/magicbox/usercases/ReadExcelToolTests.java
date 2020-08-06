package com.yxl.magicbox.usercases;

import com.yxl.magicbox.MagicboxApplicationTests;
import com.yxl.magicbox.tools.XLS2BeanFieldsTool;
import org.junit.Test;

public class ReadExcelToolTests extends MagicboxApplicationTests {
    @Test
    public void testXLS2BeanFieldsTool() {
        String path = "./src/test/java/com/yxl/magicbox/usercases/files/excel.xls";
        // 读取req、res页签
        String[] sheetNames = {"req", "res"};
        // 读取req页签的第1列和第2列、res页签的第3列和第4列
        int[] columnIndexes = {1, 2, 3, 4};
        // 变量名为全大写下划线分隔
        int fieldType = 3;
        XLS2BeanFieldsTool.execute2(path, sheetNames, columnIndexes, fieldType);

    }

    @Test
    public void testXLS2BeanFieldsTool2() {
        // ./ 代表当前项目目录下（magicbox下） 可以删掉
        String path = "./src/test/java/com/yxl/magicbox/usercases/files/excel.xls";
        // 读取res页签
        String[] sheetNames = {"res"};
        // 读取res页签的第3列和第4列
        int[] columnIndexes = {3, 4};
        // 从第2行到第4行
        int rowStartIndex = 2, rowEndIndex = 4;
        // 变量名为全大写下划线分隔
        int fieldType = 3;
        XLS2BeanFieldsTool.execute(path, sheetNames, rowStartIndex, rowEndIndex, columnIndexes, fieldType);

    }

}

package com.yxl.magicbox.tools;

import com.yxl.magicbox.utils.*;

import java.util.ArrayList;
import java.util.List;

public class XLS2BeanFieldsTool {
    private static List<String> getAttr(String[] fieldNames, String[] descriptions) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < fieldNames.length; i++) {
            String str = null;
            try {
                str = descriptions[i];
            } catch (Exception e) {
                e.printStackTrace();
                str = "";
            }
            list.add("@ApiModelProperty(\"" + str + "\")");
            list.add("private String " + fieldNames[i] + ";");
        }
        return list;
    }

    /**
     * 处理两个页签 四列数据
     * @param path
     * @param sheetNames
     * @param columnIndexes
     * @param fieldType
     */
    public static void execute2(String path, String[] sheetNames, int[] columnIndexes, int fieldType) {
        if (sheetNames == null || sheetNames.length != 2 || columnIndexes == null || columnIndexes.length != 4) {
            return;
        }
        String[] fields1 = ReadExcelUtils.readXLS2Array(path, sheetNames[0], columnIndexes[0]);
        String[] desc1 = ReadExcelUtils.readXLS2Array(path, sheetNames[0], columnIndexes[1]);
        String[] fields2 = ReadExcelUtils.readXLS2Array(path, sheetNames[1], columnIndexes[2]);
        String[] desc2 = ReadExcelUtils.readXLS2Array(path, sheetNames[1], columnIndexes[3]);

        formatField(fieldType, fields1);
        formatField(fieldType, fields2);

        List<String> list1 = getAttr(fields1, desc1);
        List<String> list2 = getAttr(fields2, desc2);

        PrintSeparatorUtils.print();
        PrintCollectionUtils.print(list1);
        PrintSeparatorUtils.print();
        PrintCollectionUtils.print(list2);
        PrintSeparatorUtils.print();

    }

    /**
     * 处理一个页签两列数据
     * @param path
     * @param sheetNames
     * @param rowStartIndex
     * @param rowEndIndex
     * @param columnIndexes
     * @param fieldType
     */
    public static void execute(String path, String[] sheetNames, int rowStartIndex, int rowEndIndex, int[] columnIndexes, int fieldType) {
        if (sheetNames == null || sheetNames.length != 1 || columnIndexes == null || columnIndexes.length != 2) {
            return;
        }
        String[] fields1 = ReadExcelUtils.readXLS2Array(path, sheetNames[0], rowStartIndex, rowEndIndex, columnIndexes[0]);
        String[] desc1 = ReadExcelUtils.readXLS2Array(path, sheetNames[0], rowStartIndex, rowEndIndex, columnIndexes[1]);

        formatField(fieldType, fields1);

        List<String> list1 = getAttr(fields1, desc1);

        PrintSeparatorUtils.print();
        PrintCollectionUtils.print(list1);
        PrintSeparatorUtils.print();

    }

    /**
     * 将String数组元素格式化为小驼峰
     * fieldType值含义：
     * 0默认 不变
     * 1小驼峰 如: prdNo 不变
     * 2大驼峰 如: PrdNo 转换为小驼峰
     * 3全大写下划线分隔，如: PRD_NO 转换为小驼峰
     *
     * @param fieldType
     * @param fields    String数组
     * @return
     */
    private static String[] formatField(int fieldType, String[] fields) {
        if (fields == null || fields.length == 0) {
            return fields;
        }
        switch (fieldType) {
            case 2:
                for (int i = 0; i < fields.length; i++) {
                    fields[i] = StringUtils.firstCharLower(fields[i]);
                }
                break;
            case 3:
                for (int i = 0; i < fields.length; i++) {
                    fields[i] = StringUtils.dealUnderscore(fields[i]);
                }
                break;
            case 0:
            case 1:
            default:
                break;
        }
        return fields;
    }
}

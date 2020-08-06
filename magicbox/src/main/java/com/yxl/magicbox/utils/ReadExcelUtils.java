package com.yxl.magicbox.utils;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadExcelUtils {

    /**
     * 默认取.xls文件的sheetName页签的第1列
     *
     * @param path      文件路径
     * @param sheetName 页签名称
     * @return
     */
    public static String[] readXLS2Array(String path, String sheetName) {
        return readXLS2Array(path, sheetName, 0);
    }

    /**
     * 取.xls文件的sheetName页签的第columnIndex列
     *
     * @param path        文件路径
     * @param sheetName   页签名称
     * @param columnIndex 第几列：大于或等于1的整数
     * @return
     */
    public static String[] readXLS2Array(String path, String sheetName, int columnIndex) {
        return readXLS2Array(path, sheetName, -1, -1, columnIndex);
    }

    /**
     * 取.xls文件的sheetName页签的第columnIndex列的第rowStartIndex行到第rowEndIndex行
     *
     * @param path          文件路径
     * @param sheetName     页签名称
     * @param rowStartIndex 开始行：大于或等于1的整数。否则默认所有行
     * @param rowEndIndex   结束行：大于或等于1的整数 且 大于或等于开始行。否则默认所有行
     * @param columnIndex   第几列：大于或等于1的整数
     * @return
     */
    public static String[] readXLS2Array(String path, String sheetName, int rowStartIndex, int rowEndIndex, int columnIndex) {
        List<String> sheetList = null;
        try {
            sheetList = readExcelXLS(path, sheetName, rowStartIndex, rowEndIndex, columnIndex);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String[] array = {};
        return sheetList.toArray(array);
    }


    private static List<String> readExcelXLS(String path, String sheetName, int rowStartIndex, int rowEndIndex, int columnIndex) throws IOException {

        if (StringUtils.isEmpty(path) || StringUtils.isEmpty(sheetName) || columnIndex < 1) {
            return null;
        }
        FileInputStream fileInputStream = new FileInputStream(path);
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(fileInputStream);
        HSSFSheet hssfSheet = hssfWorkbook.getSheet(sheetName);
        if (hssfSheet == null || hssfSheet.getLastRowNum() == 0) {
            hssfWorkbook.close();
            //throw new YRunTimeException("no data");
            return null;
        }

        List<String> list = new ArrayList<>();
        int startIndex;
        int endIndex;
        if (rowStartIndex < 1 || rowEndIndex < 1 || rowEndIndex < rowStartIndex) {
            startIndex = 0;
            endIndex = hssfSheet.getLastRowNum();
        } else {
            startIndex = rowStartIndex - 1;
            endIndex = rowEndIndex - 1;
        }
        for (int rowNum = startIndex; rowNum <= endIndex; rowNum++) {
            HSSFRow hssfRow = hssfSheet.getRow(rowNum);
            if (hssfRow == null || hssfRow.getLastCellNum() == 0) {
                continue;
            }
            // 只获取第columnIndex列
            HSSFCell hssfCell = hssfRow.getCell(columnIndex - 1);
            if (hssfCell == null) {
                continue;
            }
            CellType cellType = hssfCell.getCellTypeEnum();
            if (cellType == CellType.STRING) {
                list.add(hssfCell.getStringCellValue());
            } else if (cellType == CellType.NUMERIC) {
                list.add(hssfCell.getStringCellValue() + "");
            }
        }
        hssfWorkbook.close();
        return list;
    }
}
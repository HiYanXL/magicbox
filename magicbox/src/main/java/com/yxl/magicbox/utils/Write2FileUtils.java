package com.yxl.magicbox.utils;

import org.springframework.util.CollectionUtils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;

public class Write2FileUtils {
    public static void write(String path, List<String> dataList) {
        if (CollectionUtils.isEmpty(dataList)) {
            return;
        }
        try {
            FileWriter fileWriter = new FileWriter(path);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("----begin----");
            for (String str : dataList) {
                bufferedWriter.write(str);
            }
            bufferedWriter.write("----end----");
            bufferedWriter.close();
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

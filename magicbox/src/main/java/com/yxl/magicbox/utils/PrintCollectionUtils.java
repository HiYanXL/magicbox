package com.yxl.magicbox.utils;

import com.alibaba.fastjson.JSON;
import org.springframework.util.CollectionUtils;

import java.util.*;

public class PrintCollectionUtils {
    //TODO 此处应写成泛型
    public static void print(List list) {
        if (!CollectionUtils.isEmpty(list)) {
            Iterator iterator = list.iterator();
            while (iterator.hasNext())
                System.out.println(iterator.next());
        }
    }
    //TODO 此处应写成泛型
    public static void print(Map<Object,Object> map) {
        if (!CollectionUtils.isEmpty(map)) {
            //使用alibaba的fastjson包
            System.out.println(JSON.toJSONString(map));

            //自定义的输出
            /*for (Map.Entry entry : map.entrySet()){
                System.out.println("{"+entry.getKey()+":"+entry.getValue()+"}");
            }*/
        }
    }
}

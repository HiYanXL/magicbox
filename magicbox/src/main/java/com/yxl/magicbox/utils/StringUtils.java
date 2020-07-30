package com.yxl.magicbox.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * 自己开发的SpringUtils
 * 基于org.apache.commons.lang3.StringUtils
 */
public class StringUtils extends org.apache.commons.lang3.StringUtils{
    /**
     * 计算字符串中的不同字符的个数
     * @param str
     * @return
     */
    public static Map<Object,Object> getRepeatCharAndNum(String str){
        if(isNotEmpty(str)){
            char[] chars = str.toCharArray();
            Map<Object,Object> map = new HashMap<>();
            for(int i = 0;i<chars.length;i++){
                String key = String.valueOf(chars[i]);
                if(map.containsKey(key)){
                    int value = (int)map.get(key);
                    map.put(key,value+1);
                }else{
                    map.put(key,1);
                }
            }
            return map;
        }
        return null;
    }

}

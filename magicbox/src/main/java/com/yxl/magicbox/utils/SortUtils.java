package com.yxl.magicbox.utils;

import com.yxl.magicbox.constants.UtilConstants;
import org.thymeleaf.util.StringUtils;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 对list进行排序
 */
public class SortUtils {

    /**
     * 根据String属性将list排序、默认升序、支持降序
     * 例子：
     * list的元素item有个String类型的属性dateStr
     * item1.dateStr为"2020"
     * item2.dateStr为"2019"
     * 可根据此dateStr将list排序为: item2 item1
     *
     * @param list
     * @param field    list元素item的属性名
     * @param sortFlag "asc" 升序  "desc" 降序
     */
    public static void sortListByField(List list, final String field, final String sortFlag) {
        if (field == null || "".equals(field.trim())) {
            //TODO 此处应改为抛异常
            return;
        }
        String[] fields = {field};
        sortListByFields(list, fields, sortFlag);
    }

    /**
     * 根据String属性将list排序、默认升序
     * 例子：
     * list的元素item有个String类型的属性dateStr
     * item1.dateStr为"2020"
     * item2.dateStr为"2019"
     * 可根据此dateStr将list排序为: item2 item1
     *
     * @param list
     * @param field
     */
    public static void sortListByField(List list, final String field) {
        sortListByField(list, field, UtilConstants.ASC);
    }

    /**
     * 根据String多个属性将list排序、默认升序、支持降序
     * 例子：
     * list的元素item有个String类型的两属性[dateStr,str]
     * item1.dateStr为"2020"
     * item2.dateStr为"2020"
     * 当第一个属性相同、取下一个属性进行比较
     * item1.str为"b"
     * item2.str为"a"
     * 可根据此dateStr将list排序为: item2 item1
     *
     * @param list
     * @param fields   list元素item的多个属性名组成的数组
     * @param sortFlag "asc" 升序  "desc" 降序
     */
    public static void sortListByFields(List list, final String[] fields, final String sortFlag) {
        if (fields == null || fields.length <= 0) {
            //TODO 此处应改为抛异常
            return;
        }
        Collections.sort(list, new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
                int ret = 0;

                try {
                    for (String field : fields) {
                        Field f1 = o1.getClass().getDeclaredField(field);
                        Field f2 = o2.getClass().getDeclaredField(field);
                        f1.setAccessible(true);
                        f2.setAccessible(true);
                        //两对象的同一属性的属性值都不为null才进行值比较
                        if (f1.get(o1) != null && f2.get(o2) != null) {
                            //如果启用了排序标志
                            if (!StringUtils.isEmpty(sortFlag) && UtilConstants.DESC.equals(sortFlag)) {
                                //降序
                                if (f1.get(o1) != null && f2.get(o2) != null) {
                                    ret = f2.get(o2).toString().compareTo(f1.get(o1).toString());
                                }

                            } else {
                                //默认升序
                                if (f1.get(o1) != null && f2.get(o2) != null) {
                                    ret = f1.get(o1).toString().compareTo(f2.get(o2).toString());
                                }

                            }
                        } else if (f1.get(o1) == null && f2.get(o2) != null) {
                            //null值后置
                            ret = 1;
                        } else if (f1.get(o1) != null && f2.get(o2) == null) {
                            //null值后置
                            ret = -1;
                        } else {
                            //都为null值表示该属性相等、保留原顺序。
                            ret = 0;
                        }
                        if (ret == 0) {
                            continue;
                        } else {
                            break;
                        }
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
                return ret;
            }
        });
    }

    /**
     * 根据String多个属性将list排序、默认升序
     * 例子：
     * list的元素item有个String类型的两属性[dateStr,str]
     * item1.dateStr为"2020"
     * item2.dateStr为"2020"
     * 当第一个属性相同、取下一个属性进行比较
     * item1.str为"b"
     * item2.str为"a"
     * 可根据此dateStr将list排序为: item2 item1
     *
     * @param list
     * @param fields list元素item的多个属性名组成的数组
     */
    public static void sortListByFields(List list, final String[] fields) {
        sortListByFields(list, fields, UtilConstants.ASC);
    }
}

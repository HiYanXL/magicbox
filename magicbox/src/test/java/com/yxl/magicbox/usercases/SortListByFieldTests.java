package com.yxl.magicbox.usercases;

import com.yxl.magicbox.MagicboxApplicationTests;
import com.yxl.magicbox.utils.PrintCollectionUtils;
import com.yxl.magicbox.utils.SortUtils;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class SortListByFieldTests extends MagicboxApplicationTests {

    @Test
    public void testSortListByField() {
        class Item {
            String year;
            String month;
            String day;
            String time;
            String minutes;
            String seconds;

            Item(String year, String month, String day, String time, String minutes, String seconds) {
                this.year = year;
                this.month = month;
                this.day = day;
                this.time = time;
                this.minutes = minutes;
                this.seconds = seconds;
            }

            @Override
            public String toString() {
                return "Item{" +
                        "year='" + year + '\'' +
                        ", month='" + month + '\'' +
                        ", day='" + day + '\'' +
                        ", time='" + time + '\'' +
                        ", minutes='" + minutes + '\'' +
                        ", seconds='" + seconds + '\'' +
                        '}';
            }
        }
        Item item0 = new Item("2020","06","07","20","30","00");
        Item item1 = new Item("2020","06","07","20","30","00");
        Item item2 = new Item("2020","06","07","20","30","15");
        Item item3 = new Item("2020","06","07","20","45","30");
        Item item4 = new Item("2020","06",null,"15","15","45");
        Item item5 = new Item("2020","","12","20","30","00");
        Item item6 = new Item("2020","05","07","10","45","15");
        Item item7 = new Item("2019","05","08","20","30","00");
        Item item8 = new Item("2010","12","06","20","30","00");
        Item item9 = new Item("2030","12","07","20","30","00");

        List<Item> list = new ArrayList<>();
        list.add(item0);
        list.add(item1);
        list.add(item2);
        list.add(item3);
        list.add(item4);
        list.add(item5);
        list.add(item6);
        list.add(item7);
        list.add(item8);
        list.add(item9);

        PrintCollectionUtils.print(list);
        Field[] tmpFields = item0.getClass().getDeclaredFields();
        String[] fields = new String[tmpFields.length];
        for(int i = 0;i<tmpFields.length;i++){
            fields[i] = tmpFields[i].getName();
        }
        //SortUtils.sortListByFields(list,fields);
        System.out.println("-------------");
        //PrintCollectionUtils.print(list);
        SortUtils.sortListByField(list,null);
        PrintCollectionUtils.print(list);
    }

}

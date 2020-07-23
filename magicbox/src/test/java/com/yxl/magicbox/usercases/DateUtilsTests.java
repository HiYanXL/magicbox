package com.yxl.magicbox.usercases;

import com.yxl.magicbox.MagicboxApplicationTests;
import com.yxl.magicbox.utils.DateUtils;
import com.yxl.magicbox.utils.PrintSeparatorUtils;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

public class DateUtilsTests extends MagicboxApplicationTests {
    @Test
    public void testStr2Date(){
        String str = "20201201";
        System.out.println(DateUtils.str2Date(str));
    }
    @Test
    public void testFormatDateStr(){
        String str = "20201201";
        System.out.println(DateUtils.formatDateStr(str,""));
    }

    @Test
    public void testDaysBeforeNow(){
        Date date = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int count = 18;
        c.add(Calendar.DATE,-count);
        System.out.println(DateUtils.daysBeforeNow(date,count).compareTo(c.getTime()));


    }
    @Test
    public void testDaysAfterNow(){
        Date date = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int count = -1;
        c.add(Calendar.DATE,count);
        System.out.println(DateUtils.daysAfterNow(date,count).compareTo(c.getTime()));
        System.out.println(DateUtils.daysAfterNow(date,count));
        PrintSeparatorUtils.print();
        for(int i=-1000;i<1000;i++){
            c.setTime(date);
            c.add(Calendar.DATE,i);
            int b=DateUtils.daysAfterNow(date,i).compareTo(c.getTime());
            if(b!=0){
                System.out.println(b);
            }
        }
        PrintSeparatorUtils.print();

    }


    @Test
    public void testMonthsAfterNow(){
        Date date = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int count = -1;
        c.add(Calendar.MONTH,count);
        System.out.println(DateUtils.monthsAfterNow(date,count).compareTo(c.getTime()));
        System.out.println(DateUtils.monthsAfterNow(date,count));
        PrintSeparatorUtils.print();
        for(int i=-100;i<100;i++){
            c.setTime(date);
            c.add(Calendar.MONTH,i);
            int b=DateUtils.monthsAfterNow(date,i).compareTo(c.getTime());
            if(b!=0){
                System.out.println(b);
            }
        }
        PrintSeparatorUtils.print();
    }
    @Test
    public void testMonthsBeforeNow(){
        Date date = new Date();
        System.out.println(DateUtils.monthsBeforeNow(date,-18));
        System.out.println(DateUtils.monthsBeforeNow(date,-1));
        System.out.println(DateUtils.monthsBeforeNow(date,0));
        System.out.println(DateUtils.monthsBeforeNow(date,3));
        System.out.println(DateUtils.monthsBeforeNow(date,6));
        System.out.println(DateUtils.monthsBeforeNow(date,12));
        System.out.println(DateUtils.monthsBeforeNow(date,18));

    }
    @Test
    public void testYearsBeforeNow(){
        Date date = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int count = 18;
        c.add(Calendar.YEAR,-count);
        System.out.println(DateUtils.yearsBeforeNow(date,count).compareTo(c.getTime()));


    }
    @Test
    public void testYearsAfterNow(){
        Date date = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int count = -18;
        c.add(Calendar.YEAR,count);
        System.out.println(DateUtils.yearsAfterNow(date,count).compareTo(c.getTime()));
        System.out.println(DateUtils.yearsAfterNow(date,count));
        PrintSeparatorUtils.print();
        for(int i=-100;i<100;i++){
            c.setTime(date);
            c.add(Calendar.MONTH,i);
            int b=DateUtils.monthsAfterNow(date,i).compareTo(c.getTime());
            if(b!=0){
                System.out.println(b);
            }
        }
        PrintSeparatorUtils.print();
    }
}

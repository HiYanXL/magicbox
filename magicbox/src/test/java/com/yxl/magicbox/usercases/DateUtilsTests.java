package com.yxl.magicbox.usercases;

import com.yxl.magicbox.MagicboxApplicationTests;
import com.yxl.magicbox.utils.DateUtils;
import com.yxl.magicbox.utils.PrintSeparatorUtils;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

public class DateUtilsTests extends MagicboxApplicationTests {
    @Test
    public void testGetPeriod(){

        String str1="20200229";
        String str2="20380228";
        System.out.println(DateUtils.getPeriod(str1,str2));

        PrintSeparatorUtils.print();

    }
    @Test
    public void testGetBetweenDays(){
        String str1="20200229";
        String str2="20380228";
        long days = DateUtils.getBetweenDays(str1,str2);
        System.out.println(days);
        System.out.println(DateUtils.daysLater(DateUtils.str2Date(str1),Integer.parseInt(String.valueOf(days))));

    }
    @Test
    public void testGetCurrentTime(){
        System.out.println(DateUtils.getCurrentTime());
    }
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
        System.out.println(DateUtils.daysBefore(date,count).compareTo(c.getTime()));


    }
    @Test
    public void testDaysAfterNow(){
        Date date = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int count = -1;
        c.add(Calendar.DATE,count);
        System.out.println(DateUtils.daysLater(date,count).compareTo(c.getTime()));
        System.out.println(DateUtils.daysLater(date,count));
        PrintSeparatorUtils.print();
        for(int i=-1000;i<1000;i++){
            c.setTime(date);
            c.add(Calendar.DATE,i);
            int b=DateUtils.daysLater(date,i).compareTo(c.getTime());
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
        System.out.println(DateUtils.monthsLater(date,count).compareTo(c.getTime()));
        System.out.println(DateUtils.monthsLater(date,count));
        PrintSeparatorUtils.print();
        for(int i=-100;i<100;i++){
            c.setTime(date);
            c.add(Calendar.MONTH,i);
            int b=DateUtils.monthsLater(date,i).compareTo(c.getTime());
            if(b!=0){
                System.out.println(b);
            }
        }
        PrintSeparatorUtils.print();
    }
    @Test
    public void testMonthsBeforeNow(){
        Date date = new Date();
        System.out.println(DateUtils.monthsBefore(date,-18));
        System.out.println(DateUtils.monthsBefore(date,-1));
        System.out.println(DateUtils.monthsBefore(date,0));
        System.out.println(DateUtils.monthsBefore(date,3));
        System.out.println(DateUtils.monthsBefore(date,6));
        System.out.println(DateUtils.monthsBefore(date,12));
        System.out.println(DateUtils.monthsBefore(date,18));

    }
    @Test
    public void testYearsBeforeNow(){
        Date date = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int count = 18;
        c.add(Calendar.YEAR,-count);
        System.out.println(DateUtils.yearsBefore(date,count).compareTo(c.getTime()));


    }
    @Test
    public void testYearsAfterNow(){
        Date date = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int count = -18;
        c.add(Calendar.YEAR,count);
        System.out.println(DateUtils.yearsLater(date,count).compareTo(c.getTime()));
        System.out.println(DateUtils.yearsLater(date,count));
        PrintSeparatorUtils.print();
        for(int i=-100;i<100;i++){
            c.setTime(date);
            c.add(Calendar.MONTH,i);
            int b=DateUtils.monthsLater(date,i).compareTo(c.getTime());
            if(b!=0){
                System.out.println(b);
            }
        }
        PrintSeparatorUtils.print();
    }
}

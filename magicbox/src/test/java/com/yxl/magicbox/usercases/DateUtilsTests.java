package com.yxl.magicbox.usercases;

import com.yxl.magicbox.MagicboxApplicationTests;
import com.yxl.magicbox.utils.DateUtils;
import com.yxl.magicbox.utils.PrintSeparatorUtils;
import org.junit.Test;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;

public class DateUtilsTests extends MagicboxApplicationTests {

    @Test
    public void testWeeksLater() {
        String dateStr = "20200801";

        System.out.println(DateUtils.weeksLater(dateStr,0));

        PrintSeparatorUtils.print();
        System.out.println(DateUtils.weeksLater(dateStr,1));
        System.out.println(DateUtils.weeksLater(dateStr,2));
        System.out.println(DateUtils.weeksLater(dateStr,3));
        System.out.println(DateUtils.weeksLater(dateStr,4));
        System.out.println(DateUtils.weeksLater(dateStr,5));

        PrintSeparatorUtils.print();
        System.out.println(DateUtils.weeksLater(dateStr,-1));
        System.out.println(DateUtils.weeksLater(dateStr,-2));
        System.out.println(DateUtils.weeksLater(dateStr,-3));
        System.out.println(DateUtils.weeksLater(dateStr,-4));
        System.out.println(DateUtils.weeksLater(dateStr,-5));
    }

    @Test
    public void testSec() {

        Date date = new Date();
        System.out.println(date);

        System.out.println(date.getTime());

        System.out.println(System.currentTimeMillis());

        System.out.println(new Date(1596598677041L));
    }

    @Test
    public void testNow() {
        System.out.println(new Date());

        PrintSeparatorUtils.print();

        ZoneId zoneId = ZoneId.of("UTC");
        LocalDateTime localDateTime = LocalDateTime.now();
        ZonedDateTime zonedDateTime = localDateTime.atZone(zoneId);
        System.out.println(zonedDateTime.toInstant());

        PrintSeparatorUtils.print();

        ZoneId zoneId2 = ZoneId.systemDefault();
        LocalDateTime localDateTime2 = LocalDateTime.now();
        ZonedDateTime zonedDateTime2 = localDateTime2.atZone(zoneId2);
        System.out.println(zonedDateTime2.toInstant());

        PrintSeparatorUtils.print();

        System.out.println(Date.from(Instant.parse("2020-08-05T11:10:09.468861Z")));
        System.out.println(Date.from(Instant.parse("2020-08-05T03:10:09.474857Z")));
    }

    @Test
    public void testGetPeriod() {

        String str1 = "20200229";
        String str2 = "20210301";
        System.out.println(DateUtils.getPeriod(str1, str2));

        PrintSeparatorUtils.print();

    }

    @Test
    public void testGetBetweenDays() {
        String str1 = "20200229";
        String str2 = "20380228";
        long days = DateUtils.getBetweenDays(str1, str2);
        System.out.println(days);
        System.out.println(DateUtils.daysLater(DateUtils.str2Date(str1), Integer.parseInt(String.valueOf(days))));

    }

    @Test
    public void testGetCurrentTime() {
        System.out.println(DateUtils.getCurrentTime());
    }

    @Test
    public void testStr2Date() {
        String str = "20201201";
        System.out.println(DateUtils.str2Date(str));
    }

    @Test
    public void testFormatDateStr() {
        String str = "20201201";
        System.out.println(DateUtils.formatDateStr(str, ""));
    }

    @Test
    public void testDaysBeforeNow() {
        Date date = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int count = 18;
        c.add(Calendar.DATE, -count);
        System.out.println(DateUtils.daysBefore(date, count).compareTo(c.getTime()));


    }

    @Test
    public void testDaysAfterNow() {
        Date date = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int count = -1;
        c.add(Calendar.DATE, count);
        System.out.println(DateUtils.daysLater(date, count).compareTo(c.getTime()));
        System.out.println(DateUtils.daysLater(date, count));
        PrintSeparatorUtils.print();
        for (int i = -1000; i < 1000; i++) {
            c.setTime(date);
            c.add(Calendar.DATE, i);
            int b = DateUtils.daysLater(date, i).compareTo(c.getTime());
            if (b != 0) {
                System.out.println(b);
            }
        }
        PrintSeparatorUtils.print();

    }


    @Test
    public void testMonthsAfterNow() {
        Date date = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int count = -1;
        c.add(Calendar.MONTH, count);
        System.out.println(DateUtils.monthsLater(date, count).compareTo(c.getTime()));
        System.out.println(DateUtils.monthsLater(date, count));
        PrintSeparatorUtils.print();
        for (int i = -100; i < 100; i++) {
            c.setTime(date);
            c.add(Calendar.MONTH, i);
            int b = DateUtils.monthsLater(date, i).compareTo(c.getTime());
            if (b != 0) {
                System.out.println(b);
            }
        }
        PrintSeparatorUtils.print();
    }

    @Test
    public void testMonthsBeforeNow() {
        Date date = new Date();
        System.out.println(DateUtils.monthsBefore(date, -18));
        System.out.println(DateUtils.monthsBefore(date, -1));
        System.out.println(DateUtils.monthsBefore(date, 0));
        System.out.println(DateUtils.monthsBefore(date, 3));
        System.out.println(DateUtils.monthsBefore(date, 6));
        System.out.println(DateUtils.monthsBefore(date, 12));
        System.out.println(DateUtils.monthsBefore(date, 18));

    }

    @Test
    public void testYearsBeforeNow() {
        Date date = DateUtils.str2Date("20200229");
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int count = 1;
        c.add(Calendar.YEAR, -count);
        System.out.println(DateUtils.yearsBefore(date, count).compareTo(c.getTime()));
        System.out.println(c.getTime());

    }

    @Test
    public void testYearsAfterNow() {
        Date date = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int count = -18;
        c.add(Calendar.YEAR, count);
        System.out.println(DateUtils.yearsLater(date, count).compareTo(c.getTime()));
        System.out.println(DateUtils.yearsLater(date, count));
        PrintSeparatorUtils.print();
        for (int i = -100; i < 100; i++) {
            c.setTime(date);
            c.add(Calendar.MONTH, i);
            int b = DateUtils.monthsLater(date, i).compareTo(c.getTime());
            if (b != 0) {
                System.out.println(b);
            }
        }
        PrintSeparatorUtils.print();
    }
}

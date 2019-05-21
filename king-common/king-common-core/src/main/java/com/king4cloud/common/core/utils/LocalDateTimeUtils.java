package com.king4cloud.common.core.utils;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

public class LocalDateTimeUtils {
    //Date转换为LocalDateTime
    public static LocalDateTime convertDateToLDT(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

    //LocalDateTime转换为Date
    public static Date convertLDTToDate(LocalDateTime time) {
        return Date.from(time.atZone(ZoneId.systemDefault()).toInstant());
    }

    //获取指定日期的毫秒
    public static Long getMilliByTime(LocalDateTime time) {
        return time.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    //获取指定日期的秒
    public static Long getSecondsByTime(LocalDateTime time) {
        return time.atZone(ZoneId.systemDefault()).toInstant().getEpochSecond();
    }

    //获取指定时间的指定格式
    public static String formatTime(LocalDateTime time, String pattern) {
        return time.format(DateTimeFormatter.ofPattern(pattern));
    }

    //获取当前时间的指定格式
    public static String formatNow(String pattern) {
        return formatTime(LocalDateTime.now(), pattern);
    }

    //获取一天的开始时间，2017,7,22 00:00
    public static LocalDateTime getDayStart(LocalDateTime time) {
        return time.withHour(0)
                .withMinute(0)
                .withSecond(0)
                .withNano(0);
    }

    //获取一天的结束时间，2017,7,22 23:59:59.999999999
    public static LocalDateTime getDayEnd(LocalDateTime time) {
        return time.withHour(23)
                .withMinute(59)
                .withSecond(59)
                .withNano(999999999);
    }

    //获取某月的开始时间，2017,7,01 00:00
    public static LocalDateTime getMonthStart(LocalDateTime time) {
        return time.with(TemporalAdjusters.firstDayOfMonth())
                .withHour(0)
                .withMinute(0)
                .withSecond(0)
                .withNano(0);
    }
    //获取某月的结束时间，2017,7,31 23:59:59.999999999
    public static LocalDateTime getMonthEnd(LocalDateTime time) {
        return time.with(TemporalAdjusters.lastDayOfMonth())
                .withHour(23)
                .withMinute(59)
                .withSecond(59)
                .withNano(999999999);
    }

    public static LocalDateTime parseFromStr(String date,String pattern){
        DateTimeFormatter df = DateTimeFormatter.ofPattern(pattern);
        return LocalDateTime.parse(date,df);
    }

    public static void main(String[] args) {
//        System.out.println(LocalDateTimeUtils.getMonthStart(LocalDateTime.now()));
//        System.out.println(LocalDateTimeUtils.getMonthEnd(LocalDateTime.now()));
//        System.out.println(LocalDateTimeUtils.getMonthStart(LocalDateTime.of(2019,2,15,2,12)));
//        System.out.println(LocalDateTimeUtils.getMonthEnd(LocalDateTime.of(2019,2,15,2,12)));
        System.out.println(LocalDateTimeUtils.parseFromStr("2004-01-01 00:00:00","yyyy-MM-dd HH:mm:ss"));
    }
}

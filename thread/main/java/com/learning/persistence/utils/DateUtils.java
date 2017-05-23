package com.learning.persistence.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

/**
 * Created by zzf on 17/5/12.
 */
public class DateUtils {

    public static final String DATE_PARTTERN = "yyyy-MM-dd";

    /**
     * 获取 某年份的 最后日期, 今年和去年
     */
    public static LocalDate getEndDateOfYear(boolean thisYear) {
        LocalDate now = LocalDate.now();
        LocalDate with = LocalDate.now();
        if (thisYear) {

            with = now.with(TemporalAdjusters.lastDayOfYear());//
        } else {
            with = now.minusYears(1).with(TemporalAdjusters.lastDayOfYear());
        }
        System.out.println(with);
        return with;
    }

    public static void getFirstDateOfYear() {
        LocalDate now = LocalDate.now();
        LocalDate with = now.with(TemporalAdjusters.firstDayOfYear());//
        System.out.println(with);
    }

    public static String endOfDateOfYear(LocalDate localDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_PARTTERN);
        return  localDate.format(formatter);
    }

    /**
     * LocalDate 转 Date
     * @param localDate
     * @return
     */
    public static Date asDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * Date 转 LocalDate
     * @param date
     * @return
     */
    public static LocalDate asLocalDate(Date date) {
        return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
    }

    /**
     * LocalDateTime 转 Date
     * @param localDateTime
     * @return
     */
    public static Date asDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * Date 转 LocalDateTime
     * @param date
     * @return
     */
    public static LocalDateTime asLocalDateTime(Date date) {
        return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    /**
     * 时间格式转换（yyyy-MM-dd）
     * @param date
     * @param partter
     * @return
     */
    public static String fomat(Date date, String partter) {
        if (StringUtils.isBlank(partter)) {
            partter = DATE_PARTTERN;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(partter);
        return asLocalDate(date).format(formatter);
    }

    public static Date getBeginTime(int year, int month) {
        YearMonth yearMonth = YearMonth.of(year, month);
        LocalDate localDate = yearMonth.atDay(1);
        LocalDateTime startOfDay = localDate.atStartOfDay();
        ZonedDateTime zonedDateTime = startOfDay.atZone(ZoneId.of("Asia/Shanghai"));

        return Date.from(zonedDateTime.toInstant());
    }

    //java获取年份的第一天和最后一天
    public static Date getEndTime(int year, int month) {
        YearMonth yearMonth = YearMonth.of(year, month);
        LocalDate endOfMonth = yearMonth.atEndOfMonth();
        LocalDateTime localDateTime = endOfMonth.atTime(23, 59, 59, 999);
        ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.of("Asia/Shanghai"));
        return Date.from(zonedDateTime.toInstant());
    }

    public static void main(String[] args) {
        getEndDateOfYear(true);
        getFirstDateOfYear();
        endOfDateOfYear(getEndDateOfYear(true));

        String json = "{\"name\":\"fred\", \"age\":10, \"flag\":true}";
        JSONObject jsonObject = JSON.parseObject(json);
        System.out.println(jsonObject.getBoolean("flag"));
        System.out.println(jsonObject.getBoolean("eeeee"));

    }
}

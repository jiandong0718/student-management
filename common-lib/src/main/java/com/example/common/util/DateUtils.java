package com.example.common.util;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * 日期工具类
 */
public class DateUtils {

    /**
     * 默认日期格式
     */
    public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";

    /**
     * 默认日期时间格式
     */
    public static final String DEFAULT_DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    /**
     * 默认时间格式
     */
    public static final String DEFAULT_TIME_FORMAT = "HH:mm:ss";

    /**
     * 将LocalDateTime转换为字符串，使用默认格式
     *
     * @param dateTime LocalDateTime对象
     * @return 格式化后的日期时间字符串
     */
    public static String formatDateTime(LocalDateTime dateTime) {
        return formatDateTime(dateTime, DEFAULT_DATETIME_FORMAT);
    }

    /**
     * 将LocalDateTime转换为字符串，使用指定格式
     *
     * @param dateTime LocalDateTime对象
     * @param pattern  日期格式
     * @return 格式化后的日期时间字符串
     */
    public static String formatDateTime(LocalDateTime dateTime, String pattern) {
        if (dateTime == null) {
            return null;
        }
        return dateTime.format(DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * 将LocalDate转换为字符串，使用默认格式
     *
     * @param date LocalDate对象
     * @return 格式化后的日期字符串
     */
    public static String formatDate(LocalDate date) {
        return formatDate(date, DEFAULT_DATE_FORMAT);
    }

    /**
     * 将LocalDate转换为字符串，使用指定格式
     *
     * @param date    LocalDate对象
     * @param pattern 日期格式
     * @return 格式化后的日期字符串
     */
    public static String formatDate(LocalDate date, String pattern) {
        if (date == null) {
            return null;
        }
        return date.format(DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * 将字符串转换为LocalDateTime，使用默认格式
     *
     * @param dateTimeStr 日期时间字符串
     * @return LocalDateTime对象
     */
    public static LocalDateTime parseDateTime(String dateTimeStr) {
        return parseDateTime(dateTimeStr, DEFAULT_DATETIME_FORMAT);
    }

    /**
     * 将字符串转换为LocalDateTime，使用指定格式
     *
     * @param dateTimeStr 日期时间字符串
     * @param pattern     日期格式
     * @return LocalDateTime对象
     */
    public static LocalDateTime parseDateTime(String dateTimeStr, String pattern) {
        if (dateTimeStr == null || dateTimeStr.trim().isEmpty()) {
            return null;
        }
        return LocalDateTime.parse(dateTimeStr, DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * 将字符串转换为LocalDate，使用默认格式
     *
     * @param dateStr 日期字符串
     * @return LocalDate对象
     */
    public static LocalDate parseDate(String dateStr) {
        return parseDate(dateStr, DEFAULT_DATE_FORMAT);
    }

    /**
     * 将字符串转换为LocalDate，使用指定格式
     *
     * @param dateStr 日期字符串
     * @param pattern 日期格式
     * @return LocalDate对象
     */
    public static LocalDate parseDate(String dateStr, String pattern) {
        if (dateStr == null || dateStr.trim().isEmpty()) {
            return null;
        }
        return LocalDate.parse(dateStr, DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * 将Date转换为LocalDateTime
     *
     * @param date Date对象
     * @return LocalDateTime对象
     */
    public static LocalDateTime toLocalDateTime(Date date) {
        if (date == null) {
            return null;
        }
        return Instant.ofEpochMilli(date.getTime())
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
    }

    /**
     * 将Date转换为LocalDate
     *
     * @param date Date对象
     * @return LocalDate对象
     */
    public static LocalDate toLocalDate(Date date) {
        if (date == null) {
            return null;
        }
        return Instant.ofEpochMilli(date.getTime())
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }

    /**
     * 将LocalDateTime转换为Date
     *
     * @param localDateTime LocalDateTime对象
     * @return Date对象
     */
    public static Date toDate(LocalDateTime localDateTime) {
        if (localDateTime == null) {
            return null;
        }
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 将LocalDate转换为Date
     *
     * @param localDate LocalDate对象
     * @return Date对象
     */
    public static Date toDate(LocalDate localDate) {
        if (localDate == null) {
            return null;
        }
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 获取当前日期时间
     *
     * @return 当前日期时间字符串，格式为默认格式
     */
    public static String now() {
        return formatDateTime(LocalDateTime.now());
    }

    /**
     * 获取当前日期时间，使用指定格式
     *
     * @param pattern 日期格式
     * @return 当前日期时间字符串，格式为指定格式
     */
    public static String now(String pattern) {
        return formatDateTime(LocalDateTime.now(), pattern);
    }

    /**
     * 获取当前日期
     *
     * @return 当前日期字符串，格式为默认格式
     */
    public static String today() {
        return formatDate(LocalDate.now());
    }

    /**
     * 获取当前日期，使用指定格式
     *
     * @param pattern 日期格式
     * @return 当前日期字符串，格式为指定格式
     */
    public static String today(String pattern) {
        return formatDate(LocalDate.now(), pattern);
    }
}

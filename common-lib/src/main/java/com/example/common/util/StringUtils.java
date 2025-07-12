package com.example.common.util;

import java.util.UUID;
import java.util.regex.Pattern;

/**
 * 字符串工具类
 * @author liujiandong
 */
public class StringUtils {

    /**
     * 判断字符串是否为空
     *
     * @param str 字符串
     * @return 是否为空
     */
    public static boolean isEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

    /**
     * 判断字符串是否不为空
     *
     * @param str 字符串
     * @return 是否不为空
     */
    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    /**
     * 判断字符串是否为空白
     *
     * @param str 字符串
     * @return 是否为空白
     */
    public static boolean isBlank(String str) {
        if (str == null) {
            return true;
        }
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断字符串是否不为空白
     *
     * @param str 字符串
     * @return 是否不为空白
     */
    public static boolean isNotBlank(String str) {
        return !isBlank(str);
    }

    /**
     * 生成UUID（无连字符）
     *
     * @return UUID字符串
     */
    public static String generateUuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    /**
     * 生成UUID（有连字符）
     *
     * @return UUID字符串
     */
    public static String generateUuidWithHyphen() {
        return UUID.randomUUID().toString();
    }

    /**
     * 截取字符串
     *
     * @param str   原字符串
     * @param start 开始位置
     * @param end   结束位置
     * @return 截取后的字符串
     */
    public static String substring(String str, int start, int end) {
        if (str == null) {
            return null;
        }
        if (end < 0) {
            end = str.length() + end;
        }
        if (start < 0) {
            start = str.length() + start;
        }
        if (end > str.length()) {
            end = str.length();
        }
        if (start > end) {
            return "";
        }
        if (start < 0) {
            start = 0;
        }
        if (end < 0) {
            end = 0;
        }
        return str.substring(start, end);
    }

    /**
     * 截取字符串（从开始位置到结束）
     *
     * @param str   原字符串
     * @param start 开始位置
     * @return 截取后的字符串
     */
    public static String substring(String str, int start) {
        if (str == null) {
            return null;
        }
        if (start < 0) {
            start = str.length() + start;
        }
        if (start < 0) {
            start = 0;
        }
        if (start > str.length()) {
            return "";
        }
        return str.substring(start);
    }

    /**
     * 判断字符串是否是数字
     *
     * @param str 字符串
     * @return 是否是数字
     */
    public static boolean isNumeric(String str) {
        if (isEmpty(str)) {
            return false;
        }
        return Pattern.matches("^[0-9]+$", str);
    }

    /**
     * 判断字符串是否是字母
     *
     * @param str 字符串
     * @return 是否是字母
     */
    public static boolean isAlpha(String str) {
        if (isEmpty(str)) {
            return false;
        }
        return Pattern.matches("^[a-zA-Z]+$", str);
    }

    /**
     * 判断字符串是否是字母或数字
     *
     * @param str 字符串
     * @return 是否是字母或数字
     */
    public static boolean isAlphaNumeric(String str) {
        if (isEmpty(str)) {
            return false;
        }
        return Pattern.matches("^[a-zA-Z0-9]+$", str);
    }

    /**
     * 判断是否是有效的邮箱地址
     *
     * @param email 邮箱地址
     * @return 是否是有效的邮箱地址
     */
    public static boolean isValidEmail(String email) {
        if (isEmpty(email)) {
            return false;
        }
        String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return Pattern.matches(regex, email);
    }

    /**
     * 判断是否是有效的手机号码（中国大陆）
     *
     * @param phoneNumber 手机号码
     * @return 是否是有效的手机号码
     */
    public static boolean isValidPhoneNumber(String phoneNumber) {
        if (isEmpty(phoneNumber)) {
            return false;
        }
        String regex = "^1[3-9]\\d{9}$";
        return Pattern.matches(regex, phoneNumber);
    }

    /**
     * 将字符串的首字母转为大写
     *
     * @param str 字符串
     * @return 首字母大写的字符串
     */
    public static String capitalize(String str) {
        if (isEmpty(str)) {
            return str;
        }
        return Character.toUpperCase(str.charAt(0)) + str.substring(1);
    }

    /**
     * 将字符串的首字母转为小写
     *
     * @param str 字符串
     * @return 首字母小写的字符串
     */
    public static String uncapitalize(String str) {
        if (isEmpty(str)) {
            return str;
        }
        return Character.toLowerCase(str.charAt(0)) + str.substring(1);
    }

    /**
     * 将驼峰式命名转为下划线命名
     *
     * @param str 驼峰式命名的字符串
     * @return 下划线命名的字符串
     */
    public static String camelToUnderscore(String str) {
        if (isEmpty(str)) {
            return str;
        }
        return str.replaceAll("([a-z])([A-Z])", "$1_$2").toLowerCase();
    }

    /**
     * 将下划线命名转为驼峰式命名
     *
     * @param str 下划线命名的字符串
     * @return 驼峰式命名的字符串
     */
    public static String underscoreToCamel(String str) {
        if (isEmpty(str)) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        boolean nextUpper = false;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '_') {
                nextUpper = true;
            } else {
                if (nextUpper) {
                    sb.append(Character.toUpperCase(c));
                    nextUpper = false;
                } else {
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }
}

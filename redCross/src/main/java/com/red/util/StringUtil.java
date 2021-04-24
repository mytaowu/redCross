package com.red.util;


import com.red.config.myconst.StringConst;

import java.lang.reflect.Parameter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 项目要用到的字符串校验类；
 *
 * @true：字符串正确；
 * @false：字符串错误；
 */

public class StringUtil {
    /**
     * @param soucre:字符串；
     * @true：字符串正确；
     * @false：字符串错误；
     */
    public static boolean stringCheck(String soucre) {
        return !("".equals(soucre) || soucre == null);
    }

    /**
     * 执行MD5加密的工具方法
     *
     * @param soucre
     * @return
     */
    public static String md5(String soucre) {

        // 1.对字符串进行校验
        boolean checkResult = stringCheck(soucre);

        // 2.如果字符串校验失败，则抛出一个异常
        if (!checkResult) {
            throw new RuntimeException(new RuntimeException(StringConst.STRINGFORMTERROR));
        }

        // 3.将源字符串转换为字节数组
        byte[] inputBytes = soucre.getBytes();

        // 4.获取MessageDigest实例
        String algorithm = "md5";

        // 5.声明变量存储加密结果
        byte[] outputBytes = null;

        try {

            // 6.获取MessageDigest实例
            MessageDigest digest = MessageDigest.getInstance(algorithm);

            // 7.执行加密
            outputBytes = digest.digest(inputBytes);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        // 8.把加密结果字节数组转换为字符串
        // ①声明StringBuilder
        StringBuilder builder = new StringBuilder();

        // ②声明字符数组
        char[] characters = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E',
                'F'};

        // ③遍历outputBytes
        for (int i = 0; i < outputBytes.length; i++) {

            byte b = outputBytes[i];

            // ③取当前字节的低四位数值
            int lowValue = b & 15;

            // ④取当前字节的高四位数值
            int highValue = (b >> 4) & 15;

            // ⑤使用高四位和低四位的值从characters字符数组中取出对应的字符
            char lowChar = characters[lowValue];
            char highChar = characters[highValue];

            // ⑥拼字符串
            builder.append(highChar).append(lowChar);

        }

        return builder.toString();
    }


    public static String parametersToString(Parameter[] parameters) {
        StringBuilder stringBuilder = new StringBuilder();
        String prefix = "(";
        String suffix = ")";
        stringBuilder.append(prefix);
        for (Parameter parameter : parameters) {
            stringBuilder.append(getParamerterSuffix(parameter.toString()));
            stringBuilder.append(",");
        }
        stringBuilder.append(suffix);
        return stringBuilder.toString();
    }

    private static String getParamerterSuffix(String str) {
        return new String(str.substring(str.lastIndexOf('.') + 1, str.lastIndexOf(' ')));
    }

    public static String getClassNameSuffix(String str) {
        return new String(str.substring(str.lastIndexOf('.') + 1, str.length()));
    }
}

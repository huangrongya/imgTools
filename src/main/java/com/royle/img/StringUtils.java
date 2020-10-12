package com.royle.img;

public class StringUtils {
    public static boolean isNotEmpty(String s) {

        return s!=null&&!"".equalsIgnoreCase(s);
    }

    public static boolean isEmpty(String s) {
        return !isNotEmpty(s);
    }
}

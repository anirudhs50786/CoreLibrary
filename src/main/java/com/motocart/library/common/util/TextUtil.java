package com.motocart.library.common.util;

public class TextUtil {

    public static boolean isBlank(String s) {
        return s == null || s.isBlank();
    }

    public static boolean isNotBlank(String s) {
        return !isBlank(s);
    }
}

package com.motocart.library.common.util;

public class TextUtil {

    private static final int STACKTRACE_LIMIT = 4000;

    public static boolean isBlank(String s) {
        return s == null || s.isBlank();
    }

    public static boolean isNotBlank(String s) {
        return !isBlank(s);
    }

    public static String truncateStackTrace(String stacktrace) {
        if (isBlank(stacktrace) || stacktrace.length() <= STACKTRACE_LIMIT) {
            return stacktrace;
        }
        return stacktrace.substring(0, STACKTRACE_LIMIT) + "...";
    }
}

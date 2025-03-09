package com.tools.toolbox.utils;

public class UrlValidator {
    private static final UrlValidator INSTANCE = new UrlValidator();

    private UrlValidator() {}

    public static UrlValidator getInstance() {
        return INSTANCE;
    }
}

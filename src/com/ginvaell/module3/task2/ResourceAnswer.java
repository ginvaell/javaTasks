package com.ginvaell.module3.task2;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceAnswer {
    private final ResourceBundle bundle;

    public ResourceAnswer(Locale locale) {
        bundle = ResourceBundle.getBundle("com.ginvaell.module3.task2.resources.answer", locale);
    }

    public String getValue(String key) {
        return bundle.getString(key);
    }
}

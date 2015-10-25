package com.ginvaell.module3.task2;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceQuestion {
    private final ResourceBundle bundle;

    public ResourceQuestion(Locale locale) {
        bundle = ResourceBundle.getBundle("com.ginvaell.module3.task2.resources.question", locale);
    }

    public String getValue(String key) {
        return bundle.getString(key);
    }
}

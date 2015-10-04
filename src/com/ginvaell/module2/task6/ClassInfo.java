package com.ginvaell.module2.task6;

import java.lang.annotation.Documented;

@Documented
public @interface ClassInfo {
    String author();

    String date();
}

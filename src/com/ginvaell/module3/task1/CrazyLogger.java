package com.ginvaell.module3.task1;


import java.util.Calendar;
import java.util.Formatter;

public class CrazyLogger {
    private final StringBuilder log = new StringBuilder();

    public void addMessage(String message) {
        Calendar c = Calendar.getInstance();
        Formatter formatter = new Formatter();
        formatter.format("%td-%tm-%tY:%tH-%tM-%tS-%s;\n", c, c, c, c, c, c, message);
        log.append(formatter);
    }

    public StringBuilder searchForFragment(String fragment) {
        StringBuilder res = new StringBuilder();
        int startIndex = 0;
        int endIndex = 0;
        String tmp;
        while (endIndex < log.length()) {
            endIndex = log.indexOf(";", startIndex) + 2;
            tmp = log.substring(startIndex, endIndex);
            startIndex = endIndex;
            if (tmp.contains(fragment)) {
                res.append(tmp);
            }
        }
        return res;
    }

    @Override
    public String toString() {
        return log.toString();
    }


}

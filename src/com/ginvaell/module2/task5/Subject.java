package com.ginvaell.module2.task5;

import java.lang.annotation.Documented;

public  enum Subject {

    MATHS(true) {
        public Group<Integer> getGroup() {
            return getIntGroup(this);
        }
    },
    BIOLOGY(true) {
        public Group<Integer> getGroup() {
            return getIntGroup(this);
        }
    },
    ENGLISH(false) {
        public Group<Double> getGroup() {
            return getDoubleGroup(this);
        }
    };

    final boolean integer;

    Subject(boolean integer) {
        this.integer = integer;
    }

    public boolean isInteger() {
        return integer;
    }

    public abstract <T extends Number> Group<T> getGroup();

    private static Group<Integer> getIntGroup(Subject subject ) {
        return new Group<Integer>();
    }

    private static Group<Double> getDoubleGroup(Subject subject ) {
        return new Group<Double>();
    }
}

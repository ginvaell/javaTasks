package com.ginvaell.module2.task5;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ginva_000 on 10.10.2015.
 */
public class Group<T extends Number> {
    Map<Student, T> marks = new HashMap<>();


    public void add(Student student, T mark) {
        marks.put(student, mark);
    }

    public void add(Student student) {
        add(student, null);
    }

    @Override
    public String toString() {
        return "\nGroup{" +
                "marks=" + marks +
                "}\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Group)) return false;

        Group<?> group = (Group<?>) o;

        return !(marks != null ? !marks.equals(group.marks) : group.marks != null);

    }

    @Override
    public int hashCode() {
        return marks != null ? marks.hashCode() : 0;
    }
}

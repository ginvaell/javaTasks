package com.ginvaell.module2.task5;

/**
 * Created by ginva_000 on 04.10.2015.
 */
public class Student{
    final String name;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "\nStudent{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;

        Student student = (Student) o;

        return name.equals(student.name);

    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

}

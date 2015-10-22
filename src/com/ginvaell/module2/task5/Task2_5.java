package com.ginvaell.module2.task5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import static com.ginvaell.module2.task5.Subject.*;

/**
 * Created by ginva_000 on 04.10.2015.
 */
public class Task2_5 {
    public static void main(String[] args) {
        //Has not done yet!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!




        ArrayList<Student> students = new ArrayList<>(5);
        students.add(new Student("Dasha") );
        students.add(new Student("Klusha") );
        students.add(new Student("Johnny") );
        students.add(new Student("Bob") );
        students.add(new Student("Julio") );
        System.out.println(students);

        Map<Subject, Group<Number>> groups = new HashMap<>();
        for (Subject i: Subject.values()) {
            groups.put(i, i.getGroup());
        }
        groups.get(MATHS).add(students.get(2), new Integer(5));
        groups.get(MATHS).add(students.get(2), new Double(5));
        groups.get(ENGLISH).add(students.get(2), 5.1);
        System.out.println(groups);





    }
}

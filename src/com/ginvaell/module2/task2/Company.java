package com.ginvaell.module2.task2;

import java.util.ArrayList;

/**
 * Created by ginva_000 on 02.10.2015.
 */
public class Company {
    private final ArrayList<Employee> emp;

    public Company() {
        emp = new ArrayList<>();
    }

    public boolean addEmployee(Employee employee) {
        if (emp.contains(employee)) return false;
        emp.add(employee);
        return true;
    }

    public Employee getEmployee(String name) {
        for (Employee i : emp) {
            if (i.getName().equals(name)) {
                return i;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Company{" +
                "emp=" + emp +
                '}';
    }
}

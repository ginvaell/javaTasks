package com.ginvaell.module2.task5;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ginva_000 on 11.10.2015.
 */
public class Groups {
    private Map<Subject, Group<Number>> groups = new HashMap<>();
    public void generateGroups() {
        for (Subject i: Subject.values()) {
            groups.put(i, i.getGroup());
        }

    }
}

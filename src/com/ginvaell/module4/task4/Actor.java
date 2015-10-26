package com.ginvaell.module4.task4;

import java.io.Serializable;

public class Actor implements Serializable, Comparable<Actor> {
    private String name;

    public Actor(String name) {
        this.name = name;
    }

    public Actor() {
        this("Unknown");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Actor)) return false;

        Actor actor = (Actor) o;

        return getName().equals(actor.getName());

    }

    @Override
    public int hashCode() {
        return getName().hashCode();
    }

    @Override
    public int compareTo(Actor o) {
        return name.compareTo(o.getName());
    }

    @Override
    public String toString() {
        return "Actor{" +
                "name='" + name + '\'' +
                "}/n";
    }
}

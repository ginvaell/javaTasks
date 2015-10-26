package com.ginvaell.module4.task4;


import java.io.Serializable;

public class Film implements Serializable, Comparable<Film> {
    private String title;

    public Film(String title) {
        this.title = title;
    }

    public Film() {
        this("Unknown");
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Film)) return false;

        Film film = (Film) o;

        return getTitle().equals(film.getTitle());
    }

    @Override
    public int hashCode() {
        return getTitle().hashCode();
    }

    @Override
    public int compareTo(Film o) {
        return title.compareTo(o.getTitle());
    }

    @Override
    public String toString() {
        return "Film{" +
                "title='" + title + '\'' +
                "}\n";
    }
}

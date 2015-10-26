package com.ginvaell.module4.task4;


import java.io.Serializable;

public class Tie implements Serializable {
    private Actor actor;
    private Film film;

    public Tie(Film film, Actor actor) {
        this.actor = actor;
        this.film = film;
    }

    public Tie() {
    }

    public boolean containsActor(Actor actor) {
        return this.actor == actor;
    }

    public boolean containsFilm(Film film) {
        return this.film == film;
    }

    public Actor getActor() {
        return actor;
    }

    public Film getFilm() {
        return film;
    }

    @Override
    public String toString() {
        return "Tie{" +
                "actor=" + actor +
                ", film=" + film +
                "}\n";
    }
}

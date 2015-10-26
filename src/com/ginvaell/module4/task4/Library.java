package com.ginvaell.module4.task4;

import java.io.Serializable;
import java.util.*;

public class Library implements Serializable {
    private final SortedSet<Film> films = new TreeSet<>();
    private final SortedSet<Actor> actors = new TreeSet<>();
    private final List<Tie> ties = new ArrayList<>();

    public Library() {
    }

    public void addActor(String name) {
        actors.add(new Actor(name));
    }

    public void addFilm(String title) {
        films.add(new Film(title));
    }

    private Film getFilm(String title) {
        for (Film film : films) {
            if (film.getTitle().equals(title)) {
                return film;
            }
        }
        return null;
    }

    private Actor getActor(String name) {
        for (Actor actor : actors) {
            if (actor.getName().equals(name)) {
                return actor;
            }
        }
        return null;
    }

    public void tieFilmAndActor(String title, String name) throws NoSuchActorFoundException, NoSuchFilmFoundException {
        Actor actor = getActor(name);
        if (actor == null) throw new NoSuchActorFoundException();
        Film film = getFilm(title);
        if (film == null) throw new NoSuchFilmFoundException();
        Tie tie = new Tie(film, actor);
        ties.add(tie);
    }

    public void deleteActor(String name) {
        Actor actor = getActor(name);
        if (actor == null) return;
        ListIterator<Tie> i = ties.listIterator();
        while (i.hasNext()) {
            if (i.next().containsActor(actor)) i.remove();
        }
        actors.remove(actor);
    }

    public void deleteFilm(String title) {
        Film film = getFilm(title);
        if (film == null) return;
        ListIterator<Tie> i = ties.listIterator();
        while (i.hasNext()) {
            if (i.next().containsFilm(film)) i.remove();
        }
        films.remove(film);
    }

    public void untieFilmAndActor(String title, String name) {
        Actor actor = getActor(name);
        if (actor == null) throw new NoSuchActorFoundException();
        Film film = getFilm(title);
        if (film == null) throw new NoSuchFilmFoundException();
        Tie tie = new Tie(film, actor);
        ties.remove(tie);
    }

    public void printActors() {
        System.out.println("Actors:");
        for (Actor actor : actors) {
            System.out.println(actor.getName());
        }
        divide();
    }

    public void printFilms() {
        System.out.println("Films");
        for (Film film : films) {
            System.out.println(film.getTitle());
        }
        divide();
    }

    public void printFilmsAndActors() {
        System.out.println("Films and actors:");
        for (Tie tie : ties) {
            System.out.println(tie.getFilm().getTitle() + " : " + tie.getActor().getName());
        }
        divide();
    }

    public void printActorsWithFilm(String title) {
        System.out.println(title + ". Starring:");
        Film film = getFilm(title);
        if (film == null) return;
        ties.stream().filter(tie -> tie.containsFilm(film)).forEach(tie -> System.out.println(tie.getActor().getName()));
        divide();
    }

    public void printFilmsWithActor(String name) {
        System.out.println(name + " filmed in:");
        Actor actor = getActor(name);
        if (name == null) return;
        ties.stream().filter(tie -> tie.containsActor(actor)).forEach(tie -> System.out.println(tie.getFilm().getTitle()));
        divide();
    }

    private void divide() {
        System.out.println("---------------------");
    }

    @Override
    public String toString() {
        return "Library{" +
                "films=" + films +
                ", actors=" + actors +
                ", ties=" + ties +
                "}/n";
    }
}

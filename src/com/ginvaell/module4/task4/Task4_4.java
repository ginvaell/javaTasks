package com.ginvaell.module4.task4;

import java.io.*;

public class Task4_4 {
    public static void main(String[] args) {
        Library library = new Library();
        library.addActor("Johnny Depp");
        library.addActor("Liam Neelson");
        library.addActor("Jack Nicholson");
        library.addActor("Kevin Spacey");

        library.addFilm("Edward Scissorhands");
        library.addFilm("Sleepy Hollow");

        library.addFilm("Schindler's List");

        library.addFilm("One Flew Over the Cuckoo's Nest");
        library.addFilm("The Shining");
        library.addFilm("The Departed");


        library.addFilm("Se7en");
        library.addFilm("American Beauty");
        library.addFilm("The Life of David Gale");

        library.tieFilmAndActor("Edward Scissorhands", "Johnny Depp");
        library.tieFilmAndActor("Sleepy Hollow", "Johnny Depp");
        library.tieFilmAndActor("Schindler's List", "Liam Neelson");
        library.tieFilmAndActor("The Departed", "Kevin Spacey");
        library.tieFilmAndActor("American Beauty", "Kevin Spacey");
        library.tieFilmAndActor("The Life of David Gale", "Kevin Spacey");

        library.printActors();
        library.printFilms();
        library.printFilmsAndActors();
        library.printFilmsWithActor("Kevin Spacey");


        File file = new File("src\\com\\ginvaell\\module4\\task4\\serialized");
        try (FileOutputStream fileOutputStream = new FileOutputStream(file);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {

            objectOutputStream.writeObject(library);

        } catch (IOException e) {
            e.printStackTrace();
        }
        library.deleteActor("Kevin Spacey");
        library.printActors();
        library.printFilmsAndActors();

        try (FileInputStream fileInputStream = new FileInputStream(file);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            Library library1 = (Library) objectInputStream.readObject();
            System.out.println("Deserialized: ");
            library1.printActors();
            library1.printFilms();
            library1.printFilmsAndActors();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}

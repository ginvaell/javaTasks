package com.ginvaell.module1.task6;

/**
 * The record for notebook.
 * Consist of title and text
 *
 * @author ginva_000
 */
public class Record {
    private final String title;
    private String text;

    /**
     * Creates an instance of the class with the given title and text.
     *
     * @param title record`s title
     * @param text  record`s text
     */
    public Record(String title, String text) {
        this.title = title;
        this.text = text;
    }

    public String getText() {

        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTitle() {

        return title;
    }

    @Override
    public String toString() {
        return "\n\tRecord{" +
                "title='" + title + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}

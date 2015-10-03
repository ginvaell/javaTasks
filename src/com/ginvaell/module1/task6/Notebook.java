package com.ginvaell.module1.task6;

import java.util.ArrayList;

/**
 * Contains array of {@link Record}.
 * <p>You can add, read, edit, or delete records.</p>
 *
 * @author ginva_000
 */
public class Notebook {
    private final ArrayList<Record> records;

    public Notebook() {
        records = new ArrayList<>();
    }

    /**
     * Adds {@link Record} to Notebook.
     *
     * @param title record`s title
     * @param text  record`s text
     * @return true if record was added successfully and false
     * if record with such title is already existed.
     */
    public boolean addRecord(String title, String text) {
        if (findRecord(title) == null) {
            records.add(new Record(title, text));
            return true;
        }
        return false;
    }

    /**
     * Reads {@link Record} with given title from notebook.
     *
     * @param title record`s title
     * @return record`s text if record with such title exists and null if don`t
     */
    public String readRecord(String title) {
        Record record;
        if ((record = findRecord(title)) != null) {
            return record.getText();
        }
        return null;
    }

    /**
     * Searches for {@link Record} with given title.
     *
     * @param title - title of record to find
     * @return record with such title if it exist and null if don`t
     */
    private Record findRecord(String title) {
        for (Record i : records) {
            if (title.equals(i.getTitle())) {
                return i;
            }
        }
        return null;
    }

    /**
     * Edits text of  {@link Record} with given title.
     *
     * @param title   title of record to edit
     * @param newText will be set to the record`s text field
     * @return true if record was edited successfully and false
     * if record with such title does not exist
     */
    public boolean editRecord(String title, String newText) {
        Record record;
        if ((record = findRecord(title)) != null) {
            record.setText(newText);
            return true;
        }
        return false;
    }

    /**
     * Deletes {@link Record} with given title.
     *
     * @param title title of record to delete
     * @return true if record was deleted successfully and false
     * if record with such title does not exist
     */
    public boolean deleteRecord(String title) {
        Record record;
        if ((record = findRecord(title)) != null) {
            records.remove(record);
            return true;
        }
        return false;
    }


    @Override
    public String toString() {
        return "Notebook{" +
                "records=" + records +
                '}';
    }
}

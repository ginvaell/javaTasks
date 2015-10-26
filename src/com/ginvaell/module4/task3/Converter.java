package com.ginvaell.module4.task3;

import java.io.*;

public class Converter {
    private final File inputFile;
    private final File outputFile;
    private final StringBuilder readText = new StringBuilder();

    public String getReadText() {
        return readText.toString();
    }

    public Converter(File inputFile, File outputFile) {
        this.inputFile = inputFile;
        this.outputFile = outputFile;
    }


    public void readFile() throws IOException {

        try (InputStream fileInputStream = new FileInputStream(inputFile);
             InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
            int c;
            while (true) {
                c = bufferedReader.read();
                if (c == -1) break;
                readText.append((char) c);
            }
        }

    }

    public void writeFile() throws IOException {
        try (OutputStream fileOutputStream = new FileOutputStream(outputFile);
             OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, "UTF-16");
             BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter)) {
            bufferedWriter.write(readText.toString(), 0, readText.toString().length());
        }
    }

    public void printReadText() {
        System.out.println(readText);
    }
}

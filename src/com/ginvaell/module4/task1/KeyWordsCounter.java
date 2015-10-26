package com.ginvaell.module4.task1;

import java.io.*;
import java.util.Objects;

public class KeyWordsCounter {
    private final File file;
    private KeyWords keyWords;

    KeyWordsCounter(File file, File keyWordsFile) throws IOException {
        this.file = file;
        keyWords = new KeyWords(keyWordsFile);
    }

    public void parseWithInputStream() throws IOException {
        try (InputStream inputStream = new FileInputStream(file); BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream)) {
            int c;
            String tmp = "";
            while (true) {
                c = bufferedInputStream.read();
                if (c == -1) {
                    keyWords.tryInc(tmp);
                    break;
                }
                if (isLetter(c)) {
                    tmp += (char) c;
                } else {
                    if (!Objects.equals(tmp, "")) {
                        keyWords.tryInc(tmp);
                        tmp = "";
                    }
                }

            }
        }
    }

    public void parseWithReader() throws IOException {
        try (Reader reader = new FileReader(file); BufferedReader bufferedReader = new BufferedReader(reader)) {
            int c;
            String tmp = "";
            while (true) {
                c = bufferedReader.read();
                if (c == -1) {
                    keyWords.tryInc(tmp);
                    break;
                }
                if (isLetter(c)) {
                    tmp += (char) c;
                } else {
                    if (!Objects.equals(tmp, "")) {
                        keyWords.tryInc(tmp);
                        tmp = "";
                    }
                }

            }

        }
    }

    private boolean isLetter(int c) {
        int a1 = 65;
        int z1 = 90;
        int a = 97;
        int z = 122;
        return (c >= a1 && c <= z1) || c >= a && c <= z;
    }

    public void printAll() {
        keyWords.printAll();
    }

    public void printUsed() {
        System.out.println(keyWords.getUsedWords());
    }

    public void printToFileWithStream(File outputFile) throws IOException {
        try (OutputStream outputStream = new FileOutputStream(outputFile); BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream)) {
            byte[] b = keyWords.getUsedWords().getBytes();
            bufferedOutputStream.write(b, 0, b.length);
        }
    }

    public void printToFileWithWriter(File outputFile) throws IOException {
        try (Writer writer = new FileWriter(outputFile); BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
            char[] b = keyWords.getUsedWords().toCharArray();
            bufferedWriter.write(b, 0, b.length);
        }
    }
}

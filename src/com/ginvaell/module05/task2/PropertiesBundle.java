package com.ginvaell.module5.task2;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.locks.ReentrantLock;

public class PropertiesBundle {
    private String directory;
    private final Map<File, Properties> bundle = new HashMap<>();
    private final Map<File, ReentrantLock> locks = new HashMap<>();
    private static final ReentrantLock globalLock = new ReentrantLock();

    public PropertiesBundle(String directory) {
        this.directory = directory;
    }

    public PropertiesBundle() {
        this("");
    }

    public String getValue(String directory, String name, String key) throws IOException, IllegalArgumentException {
        File file = new File(directory + "\\" + name + ".properties");
        if (!bundle.containsKey(file)) {
            load(file);
        }
        String res = bundle.get(file).getProperty(key);
        if (res == null) throw new IllegalArgumentException("Wrong key: " + key);
        return res;

    }

    public String getValue(String name, String key) throws IOException, IllegalArgumentException {
        return getValue(directory, name, key);
    }

    private void load(File file) throws IOException {
        ReentrantLock lock;
        boolean loaded = false;
        globalLock.lock();
        if ((lock = locks.get(file)) != null) {
            globalLock.unlock();
            lock.lock();
            if (!bundle.containsKey(file)) {
                globalLock.lock();
                readFile(file, lock);
            }
            else lock.unlock();

        } else {
            lock = new ReentrantLock();
            readFile(file, lock);
        }
    }

    private void readFile(File file, ReentrantLock lock) throws IOException {
        lock.lock();
        locks.put(file, lock);
        globalLock.unlock();
        try (Reader freader = new FileReader(file); Reader reader = new BufferedReader(freader)) {
            System.out.println("Loading file " + file.getName());
            Properties properties = new Properties();
            properties.load(reader);
            bundle.put(file, properties);
        }
        finally {
            locks.remove(file);
            lock.unlock();
        }
    }

    public String getDirectory() {
        return directory;
    }

    public void setDirectory(String directory) {
        this.directory = directory;
    }
}

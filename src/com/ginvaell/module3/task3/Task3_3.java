package com.ginvaell.module3.task3;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task3_3 {
    public static void main(String[] args) {
        StringBuilder str = new StringBuilder();
        File file = new File("src\\com\\ginvaell\\module3\\task3\\text.html");
        try (FileInputStream fis = new FileInputStream(file); InputStreamReader fr = new InputStreamReader(fis, "windows-1251"); BufferedReader fin = new BufferedReader(fr)) {
            String line;
            while ((line = fin.readLine()) != null) str.append(line + '\n');

            System.out.println("Sentances with links to drawings");
            Pattern p = Pattern.compile("[Р-п]([^.!?]*(\\(ашё\\. \\d[^)]*\\)))+[^.!?]*[.!?]");
            Matcher m = p.matcher(str);
            while (m.find()) {
                System.out.println(m.group());
                System.out.println("----------------------------");

            }

            System.out.println("\nOrder of pictures");
            p = Pattern.compile("(\\d+)\\.jpg");
            m = p.matcher(str);
            int x, max = 0;
            boolean flag = false;
            while (m.find()) {
                x = Integer.parseInt(m.group(1));
                if (x != ++max) {
                    System.out.println("Error!");
                    flag = true;
                    break;
                }
            }
            if (flag == false) System.out.println("ALLGOOD!!!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

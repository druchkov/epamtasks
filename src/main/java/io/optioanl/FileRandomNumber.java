package io.optioanl;

import java.io.*;
import java.util.Random;

public class FileRandomNumber {
    public static void main(String[] args) {
        File file = new File("IO/randomNumber.txt");
        try {
            file.createNewFile();
            FileWriter writer = new FileWriter(file);
            FileReader reader = new FileReader(file);
            BufferedReader buffRedear = new BufferedReader(reader);
            int i = 0;
            while (i <= 10) {
                int x =(int)  (Math.random() * 50);
                writer.write(Integer.toString(x) + "\n");
                ++i;
            }

            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

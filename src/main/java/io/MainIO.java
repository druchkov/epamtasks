package io;

import java.io.FileWriter;
import java.io.IOException;

public class MainIO {
    public static void main(String[] args) {
        TreeF tree = new TreeF();
        try {
            tree.treeF("F:\\downloads\\панкрок", "IO/out.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

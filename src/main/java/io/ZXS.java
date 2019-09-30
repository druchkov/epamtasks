package io;

import java.io.FileWriter;
import java.io.IOException;

public class ZXS {
    public static void main(String[] args) {
        TreeF tree = new TreeF();
        try {
            tree.treeF("F:\\downloads\\панкрок", "IO/uot.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

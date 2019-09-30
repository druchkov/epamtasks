package io;

import java.io.*;

public class TreeF {
    File file;
    FileWriter writer;
    int count = 0;

    public void treeF(String path, String pathFileOutput) throws IOException {
        file = new File(path);
        writer = new FileWriter(pathFileOutput, true);
        File[] listFiles = file.listFiles();
        for (File file : listFiles) {
            if (file.isDirectory()) {
                writer.write(tab(++count) + file.getAbsolutePath() + "\n");
                System.out.print(tab(++count) + "|====" + file.getName() + "\n");
                treeF(file.getAbsolutePath(), pathFileOutput);
            } else {
                System.out.print(tab(count + 1) + "-----" + file.getName() + "\n");
                writer.write(tab(count + 1) + "-----" + file.getName() + "\n");
                file.isAbsolute();
            }
        }
    /*    for (File file : listFiles) {
            if (file.isFile()) {
                writer.write(tab(count) + "-----" + file.getName() + "\n");
                System.out.println(tab(count) + "-----" + file.getName() + "\n");
            } else {
                writer.write(tab(count) + "|====" + file.getName() + "\n");
                System.out.println(tab(count) + "|====" + file.getName() + "\n");
                treeF(file.getAbsolutePath(), pathFileOutput);
            }
        }*/
        count = 0;
        writer.flush();
    }

    public void treeF(String path) throws IOException {
        FileReader reader = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(reader);
        double countFolders = 0;
        double countFiles = 0;
        double sumLenghtFiles = 0;
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            if (line.contains("|====")) {
                countFolders++;
            } else {
                countFiles++;
                int i = line.lastIndexOf("-");
                sumLenghtFiles += line.substring(i + 1).length();
            }
        }
        System.out.println("Количество папок" + (int) countFolders);
        System.out.println("file " + (int) countFiles);
        System.out.println(countFolders / countFiles);
        System.out.println(sumLenghtFiles / countFiles);

    }

    private String tab(int n) {
        String tab = "";
        for (int i = 0; i < n; i++) {
            tab += "\t";
        }
        return "|" + tab;
    }
}

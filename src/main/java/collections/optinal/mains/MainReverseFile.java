package collections.optinal.mains;

import collections.optinal.ReverseLineInFile;

public class MainReverseFile {
    public static void main(String[] args) {
        ReverseLineInFile reverseLineInFile = new ReverseLineInFile();
        try {
            reverseLineInFile.reverseFile("src/main/resources/song.txt");
        } catch (Exception e) {}
    }
}

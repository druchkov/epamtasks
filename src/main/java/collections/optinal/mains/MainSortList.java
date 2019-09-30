package collections.optinal.mains;


import collections.optinal.SortList;

import java.io.IOException;
import java.util.ArrayList;

public class MainSortList {
    public static void main(String[] args) throws IOException {
        ArrayList<String> list = SortList.sortList("src/main/resources/fileForSortAndCountWords.txt");
        for (String line : list) {
            System.out.println(line);
        }
    }
}

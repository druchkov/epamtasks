package collections.optinal;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SortList {
    public static ArrayList<String> sortList(String path) throws IOException {
        ArrayList<String> list = new ArrayList<>();
        FileReader reader = new FileReader(path);
        Scanner scanner = new Scanner(reader);
        while (scanner.hasNextLine()) {
            list.add(scanner.nextLine());
        }
        Collections.sort(list);
        scanner.close();
        reader.close();
        return list;
    }
}


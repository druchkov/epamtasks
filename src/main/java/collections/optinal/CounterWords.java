package collections.optinal;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

public class CounterWords {
    public HashSet<String> setOtherWords(String path) throws IOException {
        HashSet<String> worlds = new HashSet<>();
        FileReader reader = new FileReader(path);
        Scanner scanner = new Scanner(reader);
        while (scanner.hasNext()) {
            String str = scanner.next();
            worlds.add(str.toLowerCase().replaceAll(",", "").replaceAll("\\?", ""));
        }
        return worlds;
    }
}

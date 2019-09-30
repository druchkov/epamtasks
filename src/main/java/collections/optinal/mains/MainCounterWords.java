package collections.optinal.mains;

import collections.optinal.CounterWords;

import java.io.IOException;
import java.util.Set;

public class MainCounterWords {
    public static void main(String[] args) throws IOException {
        CounterWords counterWords = new CounterWords();
        Set<String> str = counterWords.setOtherWords("src/main/resources/fileForSortAndCountWords.txt");
        System.out.println(str.size());
        System.out.println(str);
    }
}

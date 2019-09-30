package collections.optinal;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReverseLineInFile {
    public void reverseFile(String path) throws IOException {
        FileReader reader = new FileReader(path);
        Scanner scanner = new Scanner(reader);
        ArrayList<String> lines = new ArrayList<>();
        while (scanner.hasNextLine()) {
            lines.add(scanner.nextLine());
        }
        scanner.close();
        reader.close();
        FileWriter writer = new FileWriter(path);
        while (!lines.isEmpty()) {
            writer.write(lines.get(lines.size() - 1) + "\n");
            lines.remove(lines.size() - 1);
        }
        writer.close();
    }
}

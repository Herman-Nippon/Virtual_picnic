import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File(System.getProperty("user.dir") + "\\input.txt"));
        FileWriter fr = new FileWriter("output.txt");

        Map<String, Integer> frequencyMap = new HashMap<>();
        String longestWord = "";
        int wordsInFile = 0;

        while (scanner.hasNext()) {
            wordsInFile++;
            String word = scanner.next().toLowerCase(Locale.ROOT).strip();

            if (word.length() > longestWord.length()) {
                longestWord = word;
            }

            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
            fr.write(entry + "\n");
        }

        fr.write("\nThe longest word is: " + longestWord);
        fr.write("\nThere are " + wordsInFile + " words in the file.");
        fr.close();
    }
}

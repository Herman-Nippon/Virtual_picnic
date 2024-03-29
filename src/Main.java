import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(System.getProperty("user.dir") + "\\input.txt"));
        Map<String, Integer> frequencyMap = new HashMap<>();
        String longestWord = "";
        int wordsInFile = 0;

        while (scanner.hasNext()) {
            wordsInFile++;
            String word = scanner.next().toLowerCase(Locale.ROOT).strip();

            if (word.length() > longestWord.length())
                longestWord = word;

            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
            System.out.println(entry);
        }

        System.out.println("\nThe longest word is: " + longestWord);
        System.out.println("There are " + wordsInFile + " words in the file.");
    }
}

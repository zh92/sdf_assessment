package sdf;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MainTest {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        Path cithPath = Paths.get("cat_in_the_hat_test.txt");
        File cith = cithPath.toFile();

        if (!cith.exists()) {
            System.err.println("File not found");
            System.exit(1);
        }
        // Read file using buffered reader
        FileReader fr = new FileReader(cith);
        BufferedReader br = new BufferedReader(fr);

        String line;
        String[] columns;
        Map<String, Integer> wordMap = new HashMap<>();

        // Read file line by line
        while (null != (line = br.readLine())) {
            line = line.trim();
            line = line.toLowerCase();

            // Remove all punctuations
            for (int i = 0; i < Constants.PUNCTUATIONS.length - 1; i++) {
                line = line.replace(Constants.PUNCTUATIONS[i], "");
            }
            if (line.length() <= 0) {
                continue;
            }

            columns = line.split(" ");
            System.out.println(Arrays.toString(columns));

            for (String s : columns) {
                if (wordMap.containsKey(s)) {
                    wordMap.computeIfPresent(s, (w, c) -> Integer.valueOf(c.intValue() + 1));
                } else {
                    wordMap.computeIfAbsent(s, (w) -> Integer.valueOf(1));
                }
            }
            System.out.println(wordMap.toString());

        }
        br.close();
        fr.close();

         // Print out results
         System.out.println("Top 10 words with highest frequency: ");
         System.out.println(wordMap.values());
    }
}

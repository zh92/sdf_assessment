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

public class Main {

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

        // Read file line by line
        while (null != (line = br.readLine())) {
            line = line.trim();

            //Remove all punctuations
            for (int i = 0; i < Constants.PUNCTUATIONS.length - 1; i++) {
                line = line.replace(Constants.PUNCTUATIONS[i], "");
            }
            if (line.length() <= 0) {
                continue;
            }

            columns = line.split(" ");
            System.out.println(Arrays.toString(columns));

            Map<String, WordCount> wordMap = new HashMap<>();

            //Add to Hashmap word and count
            for (String s : columns) {
                WordCount data = wordMap.get(s);
                if (data == null) {
                    data = new WordCount(s);
                    wordMap.put(s, data);
                }
                data.add();
            }

        br.close();
        fr.close();
        }

        //Print out results
        System.out.println("Top 10 words with highest frequency: ");
        for (String s: wordMap.keySet()) {
            PlaystoreData data = playstore.get(cat);
            System.out.printf("Category: %s\n", cat);
            System.out.printf("\taverage rating: %.2f\n", data.getAverageRating());
            System.out.printf("\tHighest rated game: %s (%.2f)\n"
                    , data.getHighestRatedGame(), data.getHighestRating());
            System.out.printf("\tLowest rated game: %s (%.2f)\n"
                    , data.getLowestRatedGame(), data.getLowestRating());
        // for (int i = 1; i < 11; i++) {
        //     System.out.printf("%s. \n", i);

        // }
    }
}
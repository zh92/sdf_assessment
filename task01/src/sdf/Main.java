package sdf;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        Path cithPath = Paths.get("cat_in_the_hat.txt");
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
        int count = 0;
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
            //System.out.println(Arrays.toString(columns));

            for (String s : columns) {
                if (wordMap.containsKey(s)) {
                    wordMap.computeIfPresent(s, (w, c) -> Integer.valueOf(c.intValue() + 1));
                } else {
                    wordMap.computeIfAbsent(s, (w) -> Integer.valueOf(1));
                }
            }
            //System.out.println(wordMap.toString());
            count += line.length();

        }
        br.close();
        fr.close();

        List<Integer> list = new ArrayList<Integer>(wordMap.values());
        Collections.sort(list, Collections.reverseOrder());
        List<Integer> top10 = list.subList(0, 10);

         // Print out results
         System.out.println("Top 10 words with highest frequency: ");
         System.out.printf("Total word count: %s\n", count);
         for (int i = 0; i < 10; i++) {
            System.out.printf("%s. , count frequency = %s, term frequency = %f\n", i+1, top10.get(i), (double)top10.get(i)/(double)count);
         }
    }
}


package sdf;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        Path cithPath = Paths.get("cat_in_the_hat_test.txt");
        File cith = cithPath.toFile();

        if (!cith.exists()) {
            System.err.println("File not found");
            System.exit(1);
        }
        //Read file using buffered reader
        FileReader fr = new FileReader(cith);
        BufferedReader br = new BufferedReader(fr);

        String line;
        String[] columns;

        //Read file line by line
        while (null != (line = br.readLine())) {
            line = line.trim();
            if (line.length() <= 0) {
                continue;
            }

            //Remove punctuation
            for (int i = 0; i < Constants.PUNCTUATIONS.length; i++) {
                columns = line.split(Constants.PUNCTUATIONS[i]);
            }

            WordCount word = WordCount.getWordCount();
        }

        br.close();
        fr.close();

    }
}
package sdf;

public class WordCount {
    
    private int wordCount = 0;
    private int totalWordCount = 0;
    private String word = "";

    public int getWordCount() {return wordCount;}
    public void setWordCount(int wordCount) {this.wordCount = wordCount;}
    public int getTotalWordCount() {return totalWordCount;}
    public void setTotalWordCount(int totalWordCount) {this.totalWordCount = totalWordCount;}
    public String getWord() {return word;}
    public void setWord(String word) {this.word = word;}

    public void add(int wordCount) {
        this.wordCount += wordCount;
    }

    public void termFrequency (int wordCount, int totalWordCount) {
        Double termfrequency = (double)(wordCount / totalWordCount);
    }

    

}
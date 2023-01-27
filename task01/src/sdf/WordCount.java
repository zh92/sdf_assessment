package sdf;

public class WordCount {
    
    private int wordCount = 0;
    private int totalWordCount = 0;
    private String word;
    private Double termFrequency = 0.00;

    public int getWordCount() {return wordCount;}
    public void setWordCount(int wordCount) {this.wordCount = wordCount;}
    public int getTotalWordCount() {return totalWordCount;}
    public void setTotalWordCount(int totalWordCount) {this.totalWordCount = totalWordCount;}
    public String getWord() {return word;}
    public void setWord(String word) {this.word = word;}

    public WordCount(String word) {
        this.word = word;
    }
    public void add() {
        this.wordCount += wordCount;
    }

    public double calculateTermFrequency (int wordCount, int totalWordCount) {
        termFrequency = (double)(wordCount / totalWordCount);
        return termFrequency;
    }
}

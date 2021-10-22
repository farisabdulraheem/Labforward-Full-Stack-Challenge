package com.labforward.notebook.models;

import java.util.List;

/**
 * Response Model for the  Similarity Check POST API Request for a Word
 */
public class SimilarityCheckResultModel {
    private String word;
    private int frequencyCount;
    private List<String> similarWords;


    public SimilarityCheckResultModel(String word, int frequencyCount,
                                      List<String> similarWords) {
        this.word = word;
        this.frequencyCount = frequencyCount;
        this.similarWords = similarWords;
    }


    public SimilarityCheckResultModel() {
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getFrequencyCount() {
        return frequencyCount;
    }

    public void setFrequencyCount(int frequencyCount) {
        this.frequencyCount = frequencyCount;
    }

    public List<String> getSimilarWords() {
        return similarWords;
    }

    public void setSimilarWords(List<String> similarWords) {
        this.similarWords = similarWords;
    }

}

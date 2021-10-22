package com.labforward.notebook.dto;

import java.util.List;

/**
 * Response Dto Model for the  Similarity Check POST API Request for a Word
 */
public class SimilarityResponseDto {

    private final String word;

    private final int frequencyCount;

    private final List<String> similarWords;

    public SimilarityResponseDto(String word, int frequencyCount, List<String> similarWords) {
        this.word = word;
        this.frequencyCount = frequencyCount;
        this.similarWords = similarWords;
    }

    public String getWord() {
        return word;
    }

    public List<String> getSimilarWords() {
        return similarWords;
    }

    public int getFrequencyCount() {
        return frequencyCount;
    }
}
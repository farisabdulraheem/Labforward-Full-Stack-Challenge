package com.labforward.notebook.models;

/**
 * Request Model for the Similarity Request
 */
public class SimilarityCheckRequestModel {
    private String content;
    private String word;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}

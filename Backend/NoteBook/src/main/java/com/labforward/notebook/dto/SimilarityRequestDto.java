package com.labforward.notebook.dto;

import javax.validation.constraints.NotEmpty;

/**
 * Request Model for the Similarity Request
 */
public class SimilarityRequestDto {

    @NotEmpty
    private String content;

    @NotEmpty
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
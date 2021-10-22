package com.labforward.notebook.controllers.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.labforward.notebook.dto.SimilarityRequestDto;
import com.labforward.notebook.dto.SimilarityResponseDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.labforward.notebook.controllers.SimilarityController;


@SpringBootTest
class SimilarityControllerTest {

    @Autowired
    private SimilarityController similarityController;

    @Test
    public void testfrequencyAndSimilarWords() {
        SimilarityRequestDto noteBookSimilarityRequest = new SimilarityRequestDto();
        noteBookSimilarityRequest.setContent("word words wor");
        noteBookSimilarityRequest.setWord("word");
        SimilarityResponseDto similarityResponse = similarityController.frequencyAndSimilarWords(noteBookSimilarityRequest);

        assertEquals(1, similarityResponse.getFrequencyCount());
        assertEquals(2, similarityResponse.getSimilarWords().size());
    }

    @Test
    public void testfrequencyAndSimilarWordsContentNull() {
        SimilarityRequestDto noteBookSimilarityRequest = new SimilarityRequestDto();
        noteBookSimilarityRequest.setContent(null);
        noteBookSimilarityRequest.setWord("word");


        assertThrows(NullPointerException.class, () -> {
            similarityController.frequencyAndSimilarWords(noteBookSimilarityRequest);
        });
    }

    @Test()
    public void testfrequencyAndSimilarWordsWordNull() {
        SimilarityRequestDto noteBookSimilarityRequest = new SimilarityRequestDto();
        noteBookSimilarityRequest.setContent("word  words wor");
        noteBookSimilarityRequest.setWord(null);

        assertThrows(IllegalArgumentException.class, () ->{
            similarityController.frequencyAndSimilarWords(noteBookSimilarityRequest);
        });
    }


    @Test
    public void testfrequencyAndSimilarWordsContentAndWordSame() {
        SimilarityRequestDto noteBookSimilarityRequest = new SimilarityRequestDto();
        noteBookSimilarityRequest.setContent("word");
        noteBookSimilarityRequest.setWord("word");
        SimilarityResponseDto similarityResponse = similarityController.frequencyAndSimilarWords(noteBookSimilarityRequest);

        assertEquals(1, similarityResponse.getFrequencyCount());
        assertEquals(0, similarityResponse.getSimilarWords().size());
    }
}
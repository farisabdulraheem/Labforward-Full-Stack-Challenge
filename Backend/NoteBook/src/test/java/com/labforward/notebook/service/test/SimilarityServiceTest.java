package com.labforward.notebook.services.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.labforward.notebook.models.SimilarityCheckRequestModel;
import com.labforward.notebook.models.SimilarityCheckResultModel;
import com.labforward.notebook.service.SimilarityService;

@SpringBootTest
public class SimilarityServiceTest {

    @Autowired
    SimilarityService similarityService;

    @Test
    public void testGetSimilarity() {
        SimilarityCheckRequestModel noteBookSimilarityRequest = new SimilarityCheckRequestModel();
        noteBookSimilarityRequest.setContent("word  words wor");
        noteBookSimilarityRequest.setWord("word");
        SimilarityCheckResultModel similarityResponse = similarityService.getSimilarity(noteBookSimilarityRequest);

        assertEquals(1, similarityResponse.getFrequencyCount());
        assertEquals(2, similarityResponse.getSimilarWords().size());
    }

    @Test
    public void testGetSimilaritySingle() {
        SimilarityCheckRequestModel noteBookSimilarityRequest = new SimilarityCheckRequestModel();
        noteBookSimilarityRequest.setContent("Word");
        noteBookSimilarityRequest.setWord("Word");
        SimilarityCheckResultModel similarityResponse = similarityService.getSimilarity(noteBookSimilarityRequest);

        assertEquals(1, similarityResponse.getFrequencyCount());
        assertEquals(0, similarityResponse.getSimilarWords().size());
    }
}

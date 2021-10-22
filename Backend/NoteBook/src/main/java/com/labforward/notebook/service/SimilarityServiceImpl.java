package com.labforward.notebook.service;


import org.apache.commons.text.similarity.LevenshteinDistance;
import com.labforward.notebook.models.SimilarityCheckRequestModel;
import com.labforward.notebook.models.SimilarityCheckResultModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Service implementation for Similarity Check
 */

@Service
public class SimilarityServiceImpl implements SimilarityService {

    /**
     * Service method to get the frequency and similar words
     */
    @Override
    public SimilarityCheckResultModel getSimilarity(SimilarityCheckRequestModel note) {

        String word = note.getWord();
        String content = note.getContent();


        int occurrences = frequencyOfWord(content, word);

        List<String> similarWords = levenshteinCheck(content, word);

        return new SimilarityCheckResultModel(word, occurrences, similarWords);
    }

    /**
     * Helper method to frequency of word in a content
     */
    private int frequencyOfWord(String content, String word) {
        String[] words = content.split(" ");
        int occurrences = 0;
        for (String s : words) {
            if (s.equals(word)) {
                occurrences++;
            }

        }
        return occurrences;
    }

    /**
     * @param content - Complete Note of the user
     * @param word    - Search string
     * @return list of words which are similar to the Note
     */
    private List<String> levenshteinCheck(String content, String word) {
        List<String> similarWords = new ArrayList<>();
        LevenshteinDistance distance=new LevenshteinDistance();

        for (String checkingWord : content.split(" ")) {

            if (!checkingWord.equals(word) && distance.apply(word, checkingWord) <=1) {
                if (!similarWords.contains(checkingWord)) {
                    similarWords.add(checkingWord);
                }


            }
        }
        return similarWords;
    }
}



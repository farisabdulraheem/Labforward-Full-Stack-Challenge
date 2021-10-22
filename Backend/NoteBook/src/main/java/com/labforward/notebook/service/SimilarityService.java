package com.labforward.notebook.service;

import com.labforward.notebook.models.SimilarityCheckRequestModel;
import com.labforward.notebook.models.SimilarityCheckResultModel;

/**
 * Service Interface for Similarity Check
 */
public interface SimilarityService {
    SimilarityCheckResultModel getSimilarity(SimilarityCheckRequestModel note);
}

package com.labforward.notebook.controllers;

import com.labforward.notebook.dto.SimilarityRequestDto;
import com.labforward.notebook.dto.SimilarityResponseDto;
import com.labforward.notebook.helper.SimilarityCheckHelper;
import com.labforward.notebook.service.SimilarityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Controller class for Similarity Check
 */
@RestController
@RequestMapping("/similarity")
public class SimilarityController {
    @Autowired
    SimilarityService service;
    @Autowired
    SimilarityCheckHelper helper;

    /**
     * Endpoint for getting frequency and similar words for a particular input from user with the notebook
     */

    @PostMapping(value = "/check", consumes = "application/json", produces = "application/json")
    public SimilarityResponseDto frequencyAndSimilarWords(@RequestBody @Valid SimilarityRequestDto requestDto) {
        return helper.mapResponse(service.getSimilarity(helper.mapRequest(requestDto)));
    }


}



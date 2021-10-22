package com.labforward.notebook.helper;

import com.labforward.notebook.dto.SimilarityRequestDto;
import com.labforward.notebook.dto.SimilarityResponseDto;
import com.labforward.notebook.models.SimilarityCheckRequestModel;
import com.labforward.notebook.models.SimilarityCheckResultModel;
import org.springframework.stereotype.Component;

import javax.validation.Valid;

/**
 * Helper Class for Similarity Check
 */
@Component
public class SimilarityCheckHelper {


    public SimilarityCheckRequestModel mapRequest(@Valid SimilarityRequestDto requestDto) {
        SimilarityCheckRequestModel requestModel = new SimilarityCheckRequestModel();
        requestModel.setContent(requestDto.getContent());
        requestModel.setWord(requestDto.getWord());
        return requestModel;
    }

    public SimilarityResponseDto mapResponse(SimilarityCheckResultModel resultModel) {
        return new SimilarityResponseDto(resultModel.getWord(), resultModel.getFrequencyCount(),
                resultModel.getSimilarWords());
    }


}




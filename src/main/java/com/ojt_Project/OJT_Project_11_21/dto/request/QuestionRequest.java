package com.ojt_Project.OJT_Project_11_21.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class QuestionRequest {
    private int questionId;
    private int questionBankId;
    private String questionDescription;
    private String questionAnswerExplain;
    private String questionImage;
}

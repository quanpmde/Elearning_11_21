package com.ojt_Project.OJT_Project_11_21.dto.response;

import com.ojt_Project.OJT_Project_11_21.entity.QuestionBank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class ExamResponse {
    private int examId;
    private String examName;
    private int examTimer;
    private int examAttempt;
    private List<QuestionBankResponse> questionBanks;
}
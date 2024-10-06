package com.ojt_Project.OJT_Project_11_21.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class ExamRequest {
    private int examId;
    private String examName;
    private int examTimer;
    private int examAttempt;
    private List<Integer> questionBankIds;


}

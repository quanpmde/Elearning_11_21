package com.ojt_Project.OJT_Project_11_21.controller;

import com.ojt_Project.OJT_Project_11_21.dto.request.ExamRequest;
import com.ojt_Project.OJT_Project_11_21.dto.response.ApiResponse;
import com.ojt_Project.OJT_Project_11_21.dto.response.ExamResponse;
import com.ojt_Project.OJT_Project_11_21.service.ExamService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/exam")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ExamController {
    @Autowired
    private ExamService examService;

    @PostMapping
    public ApiResponse<ExamResponse> createNewExam(@RequestBody @Valid ExamRequest request) throws IOException {
        return ApiResponse.<ExamResponse>builder()
                .result(examService.createNewExam(request))
                .build();
    }

    @GetMapping
    public ApiResponse<List<ExamResponse>> getAllExams() {
        return ApiResponse.<List<ExamResponse>>builder()
                .result(examService.getAllExams())
                .build();
    }

    @GetMapping("/{examId}")
    public ApiResponse<ExamResponse> getExamById(@PathVariable int examId) {
        return ApiResponse.<ExamResponse>builder()
                .result(examService.getExamById(examId))
                .build();
    }

    @PutMapping("/{examId}")
    public ApiResponse<ExamResponse> updateExamById(@PathVariable int examId, @RequestBody @Valid ExamRequest request) {
        return ApiResponse.<ExamResponse>builder()
                .result(examService.updateExamById(examId, request))
                .build();
    }

    @DeleteMapping("/{examId}")
    public ApiResponse<Void> deleteExamById(@PathVariable int examId) {
        examService.deleteExamById(examId);
        return ApiResponse.<Void>builder().result(null).build();
    }
}

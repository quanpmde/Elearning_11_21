package com.ojt_Project.OJT_Project_11_21.service;

import com.ojt_Project.OJT_Project_11_21.dto.request.ExamRequest;
import com.ojt_Project.OJT_Project_11_21.dto.response.ExamResponse;
import com.ojt_Project.OJT_Project_11_21.entity.Exam;
import com.ojt_Project.OJT_Project_11_21.entity.QuestionBank;
import com.ojt_Project.OJT_Project_11_21.exception.AppException;
import com.ojt_Project.OJT_Project_11_21.exception.ErrorCode;
import com.ojt_Project.OJT_Project_11_21.mapper.ExamMapper;
import com.ojt_Project.OJT_Project_11_21.mapper.QuestionBankMapper;
import com.ojt_Project.OJT_Project_11_21.repository.ExamRepository;
import com.ojt_Project.OJT_Project_11_21.repository.QuestionBankRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExamService {
    @Autowired
    private ExamMapper examMapper;
    @Autowired
    private ExamRepository examRepository;
    @Autowired
    private QuestionBankMapper questionBankMapper;
    @Autowired
    private QuestionBankRepository questionBankRepository;

    public ExamResponse createNewExam(ExamRequest request) throws IOException {
        Exam exam = examMapper.toExam(request);

        List<QuestionBank> questionBanks = questionBankRepository.findAllById(request.getQuestionBankIds());
        if(questionBanks.isEmpty() || questionBanks.size() !=request.getQuestionBankIds().size()){
            throw new AppException(ErrorCode.QUESTIONBANK_NOT_EXISTED);
        }
        exam.setQuestionBanks(questionBanks);

        return examMapper.toExamResponse(examRepository.save(exam));
    }

    public List<ExamResponse> getAllExams() {
        List<Exam> exams = examRepository.findAll();
        return exams.stream()
                .map(examMapper::toExamResponse)
                .toList();
    }

    public ExamResponse getExamById(int examId) {
        Exam exam = examRepository.findById(examId)
                .orElseThrow(() -> new AppException(ErrorCode.EXAM_NOT_EXISTED));

        // Tải thủ công các câu hỏi từ QuestionBank
        exam.getQuestionBanks().forEach(questionBank -> {
            questionBank.getQuestions().forEach(question -> {
                question.getAnswers().size();  // Tải danh sách câu trả lời
            });
        });

        // Ánh xạ vào DTO để trả về cho người dùng
        ExamResponse examResponse = examMapper.toExamResponse(exam);

        // Ánh xạ danh sách questionBanks đã tải đủ dữ liệu
        examResponse.setQuestionBanks(exam.getQuestionBanks().stream()
                .map(questionBankMapper::toQuestionBankResponse)
                .toList());

        return examResponse;
    }

    public ExamResponse updateExamById(int examId, ExamRequest request) {
        Exam exam = examRepository.findById(examId)
                .orElseThrow(() -> new AppException(ErrorCode.EXAM_NOT_EXISTED));

        List<QuestionBank> questionBanks = questionBankRepository.findAllById(request.getQuestionBankIds());
        if (questionBanks.isEmpty() || questionBanks.size() != request.getQuestionBankIds().size()) {
            throw new AppException(ErrorCode.QUESTIONBANK_NOT_EXISTED);
        }
        exam.setQuestionBanks(questionBanks);

        return examMapper.toExamResponse(examRepository.save(exam));
    }

    public void deleteExamById(int examId) {
        Exam exam = examRepository.findById(examId)
                .orElseThrow(() -> new AppException(ErrorCode.EXAM_NOT_EXISTED));
        examRepository.delete(exam);
    }
}

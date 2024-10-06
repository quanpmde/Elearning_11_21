package com.ojt_Project.OJT_Project_11_21.service;

import com.ojt_Project.OJT_Project_11_21.dto.request.AnswerRequest;
import com.ojt_Project.OJT_Project_11_21.dto.response.AnswerResponse;
import com.ojt_Project.OJT_Project_11_21.entity.Answer;
import com.ojt_Project.OJT_Project_11_21.exception.AppException;
import com.ojt_Project.OJT_Project_11_21.exception.ErrorCode;
import com.ojt_Project.OJT_Project_11_21.mapper.AnswerMapper;
import com.ojt_Project.OJT_Project_11_21.repository.AnswerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnswerService {
    @Autowired
    private AnswerMapper answerMapper;
    @Autowired
    private AnswerRepository answerRepository;

    public AnswerResponse createNewAnswer(AnswerRequest request) {
        Answer answer = answerMapper.toAnswer(request);
        return answerMapper.toAnswerResponse(answerRepository.save(answer));
    }

    public List<AnswerResponse> getAllAnswers() {
        List<Answer> answers = answerRepository.findAll();
        return answers.stream()
                .map(answerMapper::toAnswerResponse)
                .toList();
    }

    public AnswerResponse getAnswerById(int answerId) {
        Answer answer = answerRepository.findById(answerId)
                .orElseThrow(() -> new AppException(ErrorCode.ANSWER_NOT_EXISTED));
        return answerMapper.toAnswerResponse(answer);
    }

    public AnswerResponse updateAnswerById(int answerId, AnswerRequest request) {
        Answer answer = answerRepository.findById(answerId)
                .orElseThrow(() -> new AppException(ErrorCode.ANSWER_NOT_EXISTED));
        answerMapper.updateAnswerFromRequest(answer, request);
        return answerMapper.toAnswerResponse(answerRepository.save(answer));
    }
}
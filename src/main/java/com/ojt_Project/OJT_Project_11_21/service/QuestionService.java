package com.ojt_Project.OJT_Project_11_21.service;

import com.ojt_Project.OJT_Project_11_21.dto.request.QuestionRequest;
import com.ojt_Project.OJT_Project_11_21.dto.response.QuestionResponse;
import com.ojt_Project.OJT_Project_11_21.entity.Question;
import com.ojt_Project.OJT_Project_11_21.exception.AppException;
import com.ojt_Project.OJT_Project_11_21.exception.ErrorCode;
import com.ojt_Project.OJT_Project_11_21.mapper.AnswerMapper;
import com.ojt_Project.OJT_Project_11_21.mapper.QuestionMapper;
import com.ojt_Project.OJT_Project_11_21.repository.QuestionRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
public class QuestionService {
    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private AnswerMapper answerMapper;

    public QuestionResponse createNewQuestion(QuestionRequest request) {
        Question question = questionMapper.toQuestion(request);
        return questionMapper.toQuestionResponse(questionRepository.save(question));
    }

    public List<QuestionResponse> getAllQuestions() {
        List<Question> questions = questionRepository.findAll();
        return questions.stream()
                .map(questionMapper::toQuestionResponse)
                .toList();
    }

    public QuestionResponse getQuestionById(int questionId) {
        Question question = questionRepository.findById(questionId)
                .orElseThrow(() -> new AppException(ErrorCode.QUESTION_NOT_EXISTED));

        QuestionResponse response = questionMapper.toQuestionResponse(question);
        response.setAnswers(question.getAnswers().stream()
                .map(answerMapper::toAnswerResponse)
                .toList());

        return questionMapper.toQuestionResponse(question);
    }

    public QuestionResponse updateQuestionById(int questionId, QuestionRequest request) {
        Question question = questionRepository.findById(questionId)
                .orElseThrow(() -> new AppException(ErrorCode.QUESTION_NOT_EXISTED));
        questionMapper.updateQuestionFromRequest(question, request);
        return questionMapper.toQuestionResponse(questionRepository.save(question));
    }
}

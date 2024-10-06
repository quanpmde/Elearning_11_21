package com.ojt_Project.OJT_Project_11_21.service;

import com.ojt_Project.OJT_Project_11_21.dto.request.QuestionBankRequest;
import com.ojt_Project.OJT_Project_11_21.dto.response.QuestionBankResponse;
import com.ojt_Project.OJT_Project_11_21.dto.response.SubjectResponse;
import com.ojt_Project.OJT_Project_11_21.entity.QuestionBank;
import com.ojt_Project.OJT_Project_11_21.exception.AppException;
import com.ojt_Project.OJT_Project_11_21.exception.ErrorCode;
import com.ojt_Project.OJT_Project_11_21.mapper.QuestionBankMapper;
import com.ojt_Project.OJT_Project_11_21.repository.QuestionBankRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionBankService {
    @Autowired
    private QuestionBankMapper questionBankMapper;
    @Autowired
    private QuestionBankRepository questionBankRepository;

    public QuestionBankResponse createNewQuestionBank(QuestionBankRequest request) throws IOException {
        QuestionBank questionBank = questionBankMapper.toQuestionBank(request);
        return questionBankMapper.toQuestionBankResponse(questionBankRepository.save(questionBank));
    }

    public List<QuestionBankResponse> getAllQuestionBanks() {
        List<QuestionBank> questionBanks = questionBankRepository.findAll();
        return questionBanks.stream()
                .map(questionBankMapper::toQuestionBankResponse)
                .toList();
    }

    public QuestionBankResponse getQuestionBankById(int questionBankId) {
        QuestionBank questionBank = questionBankRepository.findById(questionBankId)
                .orElseThrow(() -> new AppException(ErrorCode.QUESTIONBANK_NOT_EXISTED));

        // Tải thủ công các câu hỏi và câu trả lời
        questionBank.getQuestions().forEach(question -> {
            question.getAnswers().size();  // Tải danh sách câu trả lời
        });

        return questionBankMapper.toQuestionBankResponse(questionBank);
    }

    public QuestionBankResponse updateQuestionBankById(int questionBankId,QuestionBankRequest request){
        QuestionBank questionBank = questionBankRepository.findById(questionBankId)
                .orElseThrow(() -> new AppException(ErrorCode.QUESTIONBANK_NOT_EXISTED));
        questionBankMapper.updateQuestionBankFromRequest(questionBank,request);

        return questionBankMapper.toQuestionBankResponse(questionBankRepository.save(questionBank));
    }

}

package com.ojt_Project.OJT_Project_11_21.mapper;

import com.ojt_Project.OJT_Project_11_21.dto.request.QuestionBankRequest;
import com.ojt_Project.OJT_Project_11_21.dto.response.QuestionBankResponse;
import com.ojt_Project.OJT_Project_11_21.entity.QuestionBank;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = {QuestionMapper.class})
public interface QuestionBankMapper {
    QuestionBank toQuestionBank(QuestionBankRequest request);

    QuestionBankResponse toQuestionBankResponse(QuestionBank questionBank);

    void updateQuestionBankFromRequest(@MappingTarget QuestionBank questionBank, QuestionBankRequest request);
}
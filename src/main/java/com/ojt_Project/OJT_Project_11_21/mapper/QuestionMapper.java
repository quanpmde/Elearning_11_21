package com.ojt_Project.OJT_Project_11_21.mapper;

import com.ojt_Project.OJT_Project_11_21.dto.request.QuestionRequest;
import com.ojt_Project.OJT_Project_11_21.dto.response.QuestionResponse;
import com.ojt_Project.OJT_Project_11_21.entity.Question;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface QuestionMapper {
    @Mapping(source = "questionBankId", target = "questionBank.questionBankID")
    Question toQuestion(QuestionRequest request);

    QuestionResponse toQuestionResponse(Question question);

    @Mapping(source = "questionBankId", target = "questionBank.questionBankID")
    void updateQuestionFromRequest(@MappingTarget Question question, QuestionRequest request);
}

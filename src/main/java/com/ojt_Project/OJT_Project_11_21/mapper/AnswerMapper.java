package com.ojt_Project.OJT_Project_11_21.mapper;

import com.ojt_Project.OJT_Project_11_21.dto.request.AnswerRequest;
import com.ojt_Project.OJT_Project_11_21.dto.response.AnswerResponse;
import com.ojt_Project.OJT_Project_11_21.entity.Answer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring",uses = AnswerMapper.class)
public interface AnswerMapper {
    @Mapping(source = "questionId", target = "question.questionId")
    Answer toAnswer(AnswerRequest request);
    @Mapping(source = "question.questionId", target = "questionId")
    AnswerResponse toAnswerResponse(Answer answer);

    @Mapping(source = "questionId", target = "question.questionId")
    void updateAnswerFromRequest(@MappingTarget Answer answer, AnswerRequest request);
}
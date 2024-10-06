package com.ojt_Project.OJT_Project_11_21.mapper;

import com.ojt_Project.OJT_Project_11_21.dto.request.ExamRequest;
import com.ojt_Project.OJT_Project_11_21.dto.response.ExamResponse;
import com.ojt_Project.OJT_Project_11_21.dto.response.QuestionBankResponse;
import com.ojt_Project.OJT_Project_11_21.entity.Exam;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring",uses = QuestionBankMapper.class)
public interface ExamMapper {
    @Mapping(target = "questionBanks", ignore = true) // Bỏ qua để xử lý sau
    Exam toExam(ExamRequest request);

    ExamResponse toExamResponse(Exam exam);

    void updateExamFromRequest(@MappingTarget Exam exam, ExamRequest request);
}

package com.ojt_Project.OJT_Project_11_21.mapper;

import com.ojt_Project.OJT_Project_11_21.dto.request.SubjectRequest;
import com.ojt_Project.OJT_Project_11_21.dto.response.SubjectResponse;
import com.ojt_Project.OJT_Project_11_21.entity.Subject;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface SubjectMapper {
    Subject toSubject(SubjectRequest request);
    SubjectResponse toSubjectResponse(Subject subject);

    // Phương thức để cập nhật thông tin subject
    void updateSubjectFromRequest(@MappingTarget Subject subject, SubjectRequest request);
}

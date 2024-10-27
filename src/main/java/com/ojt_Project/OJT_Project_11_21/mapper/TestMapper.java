package com.ojt_Project.OJT_Project_11_21.mapper;

import com.ojt_Project.OJT_Project_11_21.dto.request.TestRequest;
import com.ojt_Project.OJT_Project_11_21.dto.response.TestResponse;
import com.ojt_Project.OJT_Project_11_21.entity.Test;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TestMapper {
    Test toTest(TestRequest request);

    @Mapping(source = "user.userId", target = "userId") // Mapping userId từ entity sang response
    @Mapping(source = "questions", target = "questions") // Mapping danh sách câu hỏi
    @Mapping(source = "answers", target = "answers") // Mapping danh sách câu trả lời
    TestResponse toTestResponse(Test test);
}

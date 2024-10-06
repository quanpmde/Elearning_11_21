package com.ojt_Project.OJT_Project_11_21.mapper;

import com.ojt_Project.OJT_Project_11_21.dto.request.UserRegisterRequest;
import com.ojt_Project.OJT_Project_11_21.dto.request.UserUpdateRequest;
import com.ojt_Project.OJT_Project_11_21.dto.response.UserResponse;
import com.ojt_Project.OJT_Project_11_21.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserRegisterRequest request);
    UserResponse toUserResponse(User user);

    void updateUser(@MappingTarget User user, UserUpdateRequest userUpdateRequest);

}

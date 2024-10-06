package com.ojt_Project.OJT_Project_11_21.dto.request;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class UserUpdateRequest {
    @Size(min = 5, message = "USERNAME_INVALID")
    private String userName;
    private String fullName;
    @Size(min = 10, message = "PHONE_INVALID")
    private String phone;
}

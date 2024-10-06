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
public class UserCreationRequest {
    String fullName;
    String email;
    @Size(min = 8, message = "PASSWORD_INVALID")
    String password;
    @Size(min = 10, message = "PHONE_INVALID")
    String phone;
    String status;
}

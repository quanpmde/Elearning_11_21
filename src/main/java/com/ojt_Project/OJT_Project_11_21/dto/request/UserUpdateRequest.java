package com.ojt_Project.OJT_Project_11_21.dto.request;

import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserUpdateRequest {
    @Size(min = 5, message = "USERNAME_INVALID")
    String userName;
    String fullName;
    @Size(min = 10, message = "PHONE_INVALID")
    String phone;
}

package com.ojt_Project.OJT_Project_11_21.controller;

import com.ojt_Project.OJT_Project_11_21.dto.request.UserRegisterRequest;
import com.ojt_Project.OJT_Project_11_21.dto.response.ApiResponse;
import com.ojt_Project.OJT_Project_11_21.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@CrossOrigin("*")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ApiResponse<String> register(@RequestBody @Valid UserRegisterRequest request){
        return ApiResponse.<String>builder()
                .result(userService.createNewUser(request))
                .build();
    }

}

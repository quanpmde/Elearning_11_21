package com.ojt_Project.OJT_Project_11_21.service;

import com.ojt_Project.OJT_Project_11_21.dto.request.UserRegisterRequest;
import com.ojt_Project.OJT_Project_11_21.dto.request.UserUpdateRequest;
import com.ojt_Project.OJT_Project_11_21.dto.response.UserResponse;
import com.ojt_Project.OJT_Project_11_21.entity.User;
import com.ojt_Project.OJT_Project_11_21.enums.Role;
import com.ojt_Project.OJT_Project_11_21.exception.AppException;
import com.ojt_Project.OJT_Project_11_21.exception.ErrorCode;
import com.ojt_Project.OJT_Project_11_21.mapper.UserMapper;
import com.ojt_Project.OJT_Project_11_21.repository.UserRepository;
import com.ojt_Project.OJT_Project_11_21.util.EmailUtil;
import com.ojt_Project.OJT_Project_11_21.util.OtpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserService{
    @Autowired
    private OtpUtil otpUtil;
    @Autowired
    private EmailUtil emailUtil;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public String createNewUser(UserRegisterRequest request)throws IOException {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new AppException(ErrorCode.EMAIL_EXISTED);
        }

//        String otp = otpUtil.generateOtp();
//        try {
//            emailUtil.sendOtpEmail(request.getEmail(), otp);
//        } catch (MessagingException e) {
//            throw new RuntimeException("Unable to send otp please try again");
//        }

        User user = userMapper.toUser(request);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(Role.USER.name());
//        user.setOtp(otp);
        user.setGenerateOtpTime(LocalDateTime.now());

        userRepository.save(user);
        return "To verify this is your email account, we will send a confirmation code to this email. Please check your email to receive the verification code to activate your account";
    }

    public User createUser(UserRegisterRequest request){
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new AppException(ErrorCode.EMAIL_EXISTED);
        }
        User user = userMapper.toUser(request);

        return userRepository.save(user);
    }
    public List<UserResponse> getAllUsers(){
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(userMapper::toUserResponse)
                .toList();
    }

    public UserResponse getUserByEmail(String email){
        return userMapper.toUserResponse(
                userRepository.findByEmail(email)
                        .orElseThrow(() -> new AppException(ErrorCode.EMAIL_NOT_EXISTED))
        );
    }

    public UserResponse updateUserByEmail(String email, UserUpdateRequest userUpdateRequest){
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new AppException(ErrorCode.EMAIL_NOT_EXISTED));

        userMapper.updateUser(user,userUpdateRequest);
        userRepository.save(user);
        return userMapper.toUserResponse(user);
    }
}

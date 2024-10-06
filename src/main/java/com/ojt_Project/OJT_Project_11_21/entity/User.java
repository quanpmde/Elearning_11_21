package com.ojt_Project.OJT_Project_11_21.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "user", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "voucherExchanges"})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userid")
    int userId;

    @Column(name = "fullname", length = 255, unique = true)
    String fullName;

    @Column(name = "username", length = 50)
    String userName;

    @Column(name = "email", length = 100)
    String email;

    @Column(name = "phone", length = 15)
    String phone;

    @Column(name = "password", length = 255)
    String password;

    @Column(name = "role", length = 50)
    String role;

    @Column(name = "active")
    int active;

    @Column(name = "otp", length = 10)
    String otp;

    @Column(name = "generateotptime")
    LocalDateTime generateOtpTime;
}

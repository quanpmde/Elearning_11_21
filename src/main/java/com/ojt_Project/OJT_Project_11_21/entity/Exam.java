package com.ojt_Project.OJT_Project_11_21.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Exam")
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "examId")
    private int examId;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "exam_user",
            joinColumns = @JoinColumn(name = "userId"),
            inverseJoinColumns = @JoinColumn(name = "examId")
    )
    private Collection<User> users;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "exam_questionBank",
            joinColumns = @JoinColumn(name = "examId"),
            inverseJoinColumns = @JoinColumn(name = "questionBankId")
    )
    private Collection<QuestionBank> questionBanks;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "exam_question",
            joinColumns = @JoinColumn(name = "examId"),
            inverseJoinColumns = @JoinColumn(name = "questionId")
    )
    private List<Question> questions;

    @OneToMany(mappedBy = "exam",cascade = CascadeType.ALL)
    private List<Test> tests;

    @Column(name = "examName",  length = 255)
    private String examName;

    @Column(name = "examPassword", length = 32)
    private String examPassword;

    @Column(name = "examTotalQuestions")
    private int examTotalQuestions;

    @Column(name = "examStartDate")
    private LocalDateTime examStartDate;

    @Column(name = "examEndDate")
    private LocalDateTime examEndDate;

    @Column(name = "examTimer")
    private int examTimer;

    @Column(name = "examAttempt")
    private int examAttempt;

    @Column(name = "examStatus")
    private String examStatus;


}

package com.ojt_Project.OJT_Project_11_21.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Collection;

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
            name = "exam_question_bank",
            joinColumns = @JoinColumn(name = "examId"),
            inverseJoinColumns = @JoinColumn(name = "questionBankId")
    )
    private Collection<QuestionBank> questionBanks;

    @Column(name = "examName",  length = 255)
    private String examName;

    @Column(name = "examCreateDate")
    private LocalDateTime examCreateDate;

    @Column(name = "examTimer")
    private int examTimer;

    @Column(name = "examAttempt")
    private int examAttempt;


}

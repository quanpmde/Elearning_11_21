package com.ojt_Project.OJT_Project_11_21.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "questionId")
    private int questionId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "questionBankId",nullable = true)
    private QuestionBank questionBank;

    @OneToMany(mappedBy = "question",cascade = CascadeType.ALL)
    private List<Answer> answers;

    @Column(name = "questionDescription")
    private String questionDescription;

    @Column(name = "questionAnswerExplain")
    private String questionAnswerExplain;

    @Column(name = "questionImage")
    private String questionImage;
}
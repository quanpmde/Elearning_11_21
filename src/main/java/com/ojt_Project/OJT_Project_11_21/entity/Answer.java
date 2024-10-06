package com.ojt_Project.OJT_Project_11_21.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Answer")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "answerId")
    private int answerId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "questionId", nullable = false)
    private Question question;

    @Column(name = "answerDescription")
    private String answerDescription;

    @Column(name = "answerCorrect")
    private int answerCorrect;

    @Column(name = "answerImage")
    private String answerImage;
}

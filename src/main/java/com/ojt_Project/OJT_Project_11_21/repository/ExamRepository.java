package com.ojt_Project.OJT_Project_11_21.repository;

import com.ojt_Project.OJT_Project_11_21.entity.Exam;
import com.ojt_Project.OJT_Project_11_21.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExamRepository extends JpaRepository<Exam,Integer> {
    List<Exam> findByUsersContaining(User user);
}

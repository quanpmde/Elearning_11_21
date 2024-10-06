package com.ojt_Project.OJT_Project_11_21.service;

import com.ojt_Project.OJT_Project_11_21.dto.request.SubjectRequest;
import com.ojt_Project.OJT_Project_11_21.dto.response.SubjectResponse;
import com.ojt_Project.OJT_Project_11_21.entity.Subject;
import com.ojt_Project.OJT_Project_11_21.exception.AppException;
import com.ojt_Project.OJT_Project_11_21.exception.ErrorCode;
import com.ojt_Project.OJT_Project_11_21.mapper.SubjectMapper;
import com.ojt_Project.OJT_Project_11_21.repository.SubjectRepostiory;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SubjectService {
    @Autowired
    private SubjectMapper subjectMapper;
    @Autowired
    private SubjectRepostiory subjectRepository;

    public SubjectResponse createNewSubject(SubjectRequest request) throws IOException {
        Subject subject = subjectMapper.toSubject(request);
        Subject newSubject = subjectRepository.save(subject);
        return subjectMapper.toSubjectResponse(newSubject);
    }

    // Phương thức để lấy tất cả các subject
    public List<SubjectResponse> getAllSubjects() {
        List<Subject> subjects = subjectRepository.findAll();
        return subjects.stream()
                .map(subjectMapper::toSubjectResponse)
                .toList();
    }

    public SubjectResponse getSubjectById(int subjectId) {
        Subject subject = subjectRepository.findById(subjectId)
                .orElseThrow(() -> new AppException(ErrorCode.SUBJECT_NOT_EXISTED));
        return subjectMapper.toSubjectResponse(subject);
    }

    // Phương thức để cập nhật subject theo subjectId
    public SubjectResponse updateSubject(int subjectId, SubjectRequest request) {
        Subject subject = subjectRepository.findById(subjectId)
                .orElseThrow(() -> new AppException(ErrorCode.SUBJECT_NOT_EXISTED));

        subjectMapper.updateSubjectFromRequest(subject, request);

        return subjectMapper.toSubjectResponse(subjectRepository.save(subject));
    }

}

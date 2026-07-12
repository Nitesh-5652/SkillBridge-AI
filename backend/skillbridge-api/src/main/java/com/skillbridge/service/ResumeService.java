package com.skillbridge.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.skillbridge.dto.ResumeResponse;

public interface ResumeService {

    ResumeResponse uploadResume(String email, MultipartFile file);

    List<ResumeResponse> getMyResumes(String email);

}

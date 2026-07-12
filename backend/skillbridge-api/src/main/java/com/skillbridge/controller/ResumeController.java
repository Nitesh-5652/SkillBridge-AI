package com.skillbridge.controller;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.skillbridge.dto.ResumeResponse;
import com.skillbridge.service.ResumeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/resumes")
@RequiredArgsConstructor
public class ResumeController {

    private final ResumeService resumeService;

    @PostMapping
    public ResumeResponse upload(
            Authentication authentication,
            @RequestParam("file") MultipartFile file) {

        System.out.println("========== UPLOAD HIT ==========");
        System.out.println(file.getOriginalFilename());

        return resumeService.uploadResume(
                authentication.getName(),
                file);
    }

    @GetMapping
    public List<ResumeResponse> myResumes(Authentication authentication) {

        return resumeService.getMyResumes(authentication.getName());
    }
}

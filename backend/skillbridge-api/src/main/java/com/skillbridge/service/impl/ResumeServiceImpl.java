package com.skillbridge.service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.skillbridge.dto.ResumeResponse;
import com.skillbridge.entity.Resume;
import com.skillbridge.entity.User;
import com.skillbridge.repository.ResumeRepository;
import com.skillbridge.repository.UserRepository;
import com.skillbridge.service.ResumeParserService;
import com.skillbridge.service.ResumeService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ResumeServiceImpl implements ResumeService {

    private final ResumeRepository resumeRepository;
    private final UserRepository userRepository;
    private final ResumeParserService resumeParserService;

    @Override
    public ResumeResponse uploadResume(String email, MultipartFile file) {
        try {
            User user = userRepository.findByEmail(email)
                    .orElseThrow(() -> new RuntimeException("User not found"));

            // Improved directory handling
            Path uploadDir = Paths.get(System.getProperty("user.dir"), "uploads");
            Files.createDirectories(uploadDir);

            Path destination = uploadDir.resolve(file.getOriginalFilename());
            System.out.println("Saving to: " + destination.toAbsolutePath());

            // Extract text BEFORE saving
            String resumeText = resumeParserService.extractText(file);

            System.out.println("========== RESUME TEXT ==========");
            System.out.println(resumeText);
            System.out.println("=================================");

            // Now save file
            file.transferTo(destination.toFile());

            String filePath = destination.toString();

            Resume resume = Resume.builder()
                    .fileName(file.getOriginalFilename())
                    .fileType(file.getContentType())
                    .filePath(filePath)
                    .resumeText(resumeText)
                    .uploadedAt(LocalDateTime.now())
                    .user(user)
                    .build();

            resumeRepository.save(resume);

            return ResumeResponse.builder()
                    .id(resume.getId())
                    .fileName(resume.getFileName())
                    .fileType(resume.getFileType())
                    .uploadedAt(resume.getUploadedAt())
                    .build();

        } catch (IOException e) {
            throw new RuntimeException("Failed to upload file: " + e.getMessage(), e);
        }
    }

    @Override
    public List<ResumeResponse> getMyResumes(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return resumeRepository.findByUserId(user.getId())
                .stream()
                .map(resume -> ResumeResponse.builder()
                        .id(resume.getId())
                        .fileName(resume.getFileName())
                        .fileType(resume.getFileType())
                        .uploadedAt(resume.getUploadedAt())
                        .build())
                .toList();
    }
}
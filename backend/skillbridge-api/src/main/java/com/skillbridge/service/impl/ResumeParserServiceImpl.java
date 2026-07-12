package com.skillbridge.service.impl;

import java.io.IOException;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.skillbridge.service.ResumeParserService;

@Service
public class ResumeParserServiceImpl implements ResumeParserService {

    @Override
    public String extractText(MultipartFile file) {

        try {

            PDDocument document = Loader.loadPDF(file.getBytes());

            PDFTextStripper stripper = new PDFTextStripper();

            String text = stripper.getText(document);

            document.close();

            return text;

        } catch (IOException e) {

            throw new RuntimeException(e);

        }
    }
}

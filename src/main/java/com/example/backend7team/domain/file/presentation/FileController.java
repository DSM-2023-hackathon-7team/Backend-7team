package com.example.backend7team.domain.file.presentation;

import com.example.backend7team.domain.file.presentation.dto.response.FileUploadResponse;
import com.example.backend7team.domain.file.service.FileUploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@RequestMapping("/files")
@RestController
public class FileController {

    private final FileUploadService fileUploadService;

    @PostMapping
    public FileUploadResponse uploadFile(@RequestPart("image") MultipartFile image) {
         return fileUploadService.execute(image);
    }
}

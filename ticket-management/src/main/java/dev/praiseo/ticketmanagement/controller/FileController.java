package dev.praiseo.ticketmanagement.controller;

import dev.praiseo.ticketmanagement.service.FileUploadService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("file")
public class FileController {

    private final FileUploadService fileUploadService;

    public FileController(FileUploadService fileUploadService) {
        this.fileUploadService = fileUploadService;
    }

    @PostMapping("upload")
    public String uploadFile(@RequestParam("file")MultipartFile file) throws IOException {
        try {
            fileUploadService.uploadFile(file);
        } catch (IOException e) {
            throw new IOException(e.getMessage());
        }
        return "Uploaded";
    }
}

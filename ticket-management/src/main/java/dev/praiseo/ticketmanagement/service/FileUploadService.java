package dev.praiseo.ticketmanagement.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileUploadService {
    void uploadFile(MultipartFile file) throws IOException;
}

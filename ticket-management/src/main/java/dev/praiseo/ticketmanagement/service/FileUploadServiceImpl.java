package dev.praiseo.ticketmanagement.service;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;

@Service
public class FileUploadServiceImpl implements FileUploadService {
    private Path location;

    public FileUploadServiceImpl() throws IOException {
        String home = System.getProperty("user.home");
        location = Paths.get(home);
        Files.createDirectories(location);
    }

    @Override
    public void uploadFile(MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        if (fileName.isEmpty()) throw new IOException("File is empty");
        try {
            Files.copy(file.getInputStream(), this.location.resolve(fileName), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ex) {
            throw new IOException("Error uploading file " + fileName);
        }
    }


}

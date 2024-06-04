package com.example.frealsb.Services.Interface;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public interface ICloudinaryService {
    public String uploadFile(MultipartFile file);
    public File convertMultiPartToFile(MultipartFile file) throws IOException;
    public void delete(String publicId);
}

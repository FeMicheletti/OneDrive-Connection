package com.shynx.onedriveapi.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileService {

    public Object listFiles() {
        return "GET all files";
    }

    public Object getFile(String path) {
        return "GET file: " + path;
    }

    public Object uploadFile(MultipartFile file, String path) {
        return "Upload recebido: " + file.getOriginalFilename() + " para " + path;
    }

    public void deleteFile(String path) {
        System.out.println("DELETE file: " + path);
    }

}

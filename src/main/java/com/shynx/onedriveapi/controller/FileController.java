package com.shynx.onedriveapi.controller;

import com.shynx.onedriveapi.service.FileService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/files")
@Tag(name = "Files", description = "Endpoints for file management using OneDrive storage")
public class FileController {
    private final FileService fileService;

    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @GetMapping
    @Operation(summary = "Get a file or list files")
    public ResponseEntity<?> getFile(@RequestParam(required = false) String path) {
        if (path == null || path.isBlank()) {
            return ResponseEntity.ok(fileService.listFiles());
        }

        return ResponseEntity.ok(fileService.getFile(path));
    }

    @PostMapping(value = "/upload", consumes = "multipart/form-data")
    @Operation(summary = "Upload a file")
    public ResponseEntity<?> uploadFile( @RequestParam("file") MultipartFile file, @RequestParam("path") String path ) {
        return ResponseEntity.ok(fileService.uploadFile(file, path));
    }

    @DeleteMapping
    @Operation(summary = "Delete a file")
    public ResponseEntity<Void> deleteFile( @RequestParam String path ) {
        fileService.deleteFile(path);
        return ResponseEntity.noContent().build();
    }
}
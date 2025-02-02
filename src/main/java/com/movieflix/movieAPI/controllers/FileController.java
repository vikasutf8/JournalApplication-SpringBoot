package com.movieflix.movieAPI.controllers;

import java.io.IOException;
import java.io.InputStream;

import javax.print.attribute.standard.Media;
import javax.print.attribute.standard.MediaTray;

import org.apache.tomcat.util.http.parser.MediaType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.io.IOContext;
import com.movieflix.movieAPI.services.FileService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/file/")
public class FileController {
    
    private final FileService fileService;
//constructor as it private
    public FileController(FileService fileService){
        this.fileService =fileService;
    }
//where we have to upload 
    @Value("${project.poster}")
    private String path;


    @PostMapping("/upload")
    public ResponseEntity<String> uploadFileHandler(@RequestPart MultipartFile file) throws IOException{
        String uploadedFileName =fileService.uploadFile(path, file);
        return ResponseEntity.ok("File Uploaded :"+ uploadedFileName);
    }

    @GetMapping("/{fileName}")
    public void  serveFileHandler(@PathVariable String fileName,HttpServletResponse response) throws IOException {
         InputStream resourceFile  =fileService.getResourceFile(path, fileName);
        response.setContentType(MediaType.IMAGE_PNG_VALUE);
        StreamUtils.copy(resourceFile, response.getOutputStream());
    }
    
}
//http://localhost:8080?/file/upload
// form-data
// file -FILE -- png
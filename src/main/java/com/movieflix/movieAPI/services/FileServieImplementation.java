package com.movieflix.movieAPI.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
@Service
public class FileServieImplementation implements FileService{
     //to save data into db
     @Override
    public String uploadFile(String path ,MultipartFile file) throws IOException{

        //get name of file
        String fileName =file.getOriginalFilename();

        //to get filepath
        String filePath =path +File.separator +fileName;

        //create a file object
        File  f =new File(path);
        if(!f.exists()){
            f.mkdirs();
        }

        //copy file and upload file to path
        Files.copy(file.getInputStream(), Paths.get(filePath), StandardCopyOption.REPLACE_EXISTING); 


        return fileName; //this is how file save in db
    } 

    //to fetch data into db -call it -->receive file as inputStream --> generate url -->addittion putting ie dto -->serve at frontend
    @Override
    public InputStream getResourceFile(String path,String filename) throws FileNotFoundException{
    
        //getting full file paht
        String filePath =path +File.separator +filename;



        return new FileInputStream(filePath);
    }
}

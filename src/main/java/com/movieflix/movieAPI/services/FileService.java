package com.movieflix.movieAPI.services;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    
    //to save data into db
    public String uploadFile(String path ,MultipartFile file) throws IOException; //storage path,file

    //to fetch data into db -call it -->receive file as inputStream --> generate url -->addittion putting ie dto -->serve at frontend
    InputStream getResourceFile(String path,String filename) throws FileNotFoundException;



}

package com.movieflix.movieAPI.controllers;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.movieflix.movieAPI.dto.MovieDto;
import com.movieflix.movieAPI.services.MovieService;

@RestController
@RequestMapping("/api/v1/movie")
public class MovieController {
    
    private final MovieService movieService;

    public MovieController(MovieService movieService){
        this.movieService =movieService;
    }

    //string to json
    private MovieDto convertToMovieDto(String movieDtoObj) throws JsonProcessingException{
        // MovieDto movieDto =new MovieDto();
        ObjectMapper objectMapper =new ObjectMapper();
        return objectMapper.readValue(movieDtoObj, MovieDto.class);
        // file object /json object  --need to take string and convert class oject for service layer
        
    }
    @PostMapping("/add-movie")
    public ResponseEntity<MovieDto> addMovieHandler(@RequestPart MultipartFile file,@RequestPart String movieDto) throws IOException{
        
        MovieDto dto =convertToMovieDto(movieDto);
        return new ResponseEntity<>(movieService.addMovie(dto, file), HttpStatus.CREATED);
    }
}

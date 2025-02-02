package com.movieflix.movieAPI.services;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.movieflix.movieAPI.dto.MovieDto;
import com.movieflix.movieAPI.entities.Movie;
import com.movieflix.movieAPI.repositories.MovieRepository;

@Service
public class MovieServiceImplementation implements MovieService {

    private final MovieRepository movieRepository;
    private final FileService fileService;


    public MovieServiceImplementation(MovieRepository movieRepository, FileService fileService){
        this.movieRepository =movieRepository;
        this.fileService =fileService;
    }

    //where we have to upload 
    @Value("${project.poster}")
    private String path;

    @Value("${base.url}")
    private String baseUrl;

    
    @Override
    public MovieDto addMovie(MovieDto movieDto ,MultipartFile file) throws IOException{
        
        //1. upload file
        String uploadedFileName =fileService.uploadFile(path, file);
        //2. set value of fild poster as filename
        movieDto.setPoster(uploadedFileName);
        //3. map dto to movie object
        Movie movie =new Movie(
            movieDto.getMovieId(),
            movieDto.getTitle(),
            movieDto.getDirector(),
            movieDto.getStudio(),
            movieDto.getMovieCast(),
            movieDto.getReleaseYear(),
            movieDto.getPoster()

        );
        //4. to save movie object ==> retrun back saved movies object
        Movie savedMovie =movieRepository.save(movie);

        //5. we have to return movieDto -- but it have extra file url
        // generate poster url
        String posterUrl =baseUrl+ "/file/" +uploadedFileName;

        //6 . mapp movie object to DTO object and return it.
        MovieDto response =new MovieDto(
            savedMovie.getMovieId(),
            savedMovie.getTitle(),
            savedMovie.getDirector(),
            savedMovie.getStudio(),
            savedMovie.getMovieCast(),
            savedMovie.getReleaseYear(),
            savedMovie.getPoster(),
        posterUrl
        );

        return response;
    }

    @Override
    public MovieDto getMovie(Integer movieId);

    @Override
    public List<MovieDto> getAllMovies();
}

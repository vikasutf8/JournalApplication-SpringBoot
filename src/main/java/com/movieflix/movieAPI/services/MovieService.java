package com.movieflix.movieAPI.services;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.movieflix.movieAPI.dto.MovieDto;

public interface MovieService {
    MovieDto addMovie(MovieDto movieDto ,MultipartFile file);

    MovieDto getMovie(Integer movieId);

    List<MovieDto> getAllMovies();
}

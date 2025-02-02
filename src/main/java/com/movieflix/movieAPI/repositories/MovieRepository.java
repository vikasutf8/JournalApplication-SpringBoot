package com.movieflix.movieAPI.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movieflix.movieAPI.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie,Integer> {
    
}

package com.movieflix.movieAPI.entities;

import java.util.Set;

import jakarta.annotation.Generated;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //?
    private Integer movieId;

    @Column(nullable = false, length = 50)
    @NotBlank(message = "Please provide movie's name")
    private String  title;

    @Column(nullable = false, length = 50)
    @NotBlank(message = "Please provide movie's director's name")
    private String director;
    
    @Column(nullable = false, length = 100)
    @NotBlank(message = "Please provide movie's studio name")
    private  String studio;

    @ElementCollection
    @CollectionTable(name ="movie_cast") //?
    private Set<String> movieCast; //collection of string 

    @Column(nullable = false )
    @NotBlank(message = "Please provide movie's name")
    private Integer releaseYear;

    @Column(nullable = false)
    @NotBlank(message = "Please provide movie's Poster")
    private String poster ; //img
}

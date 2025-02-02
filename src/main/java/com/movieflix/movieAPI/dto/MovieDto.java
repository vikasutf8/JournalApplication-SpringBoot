package com.movieflix.movieAPI.dto;

import java.util.Set;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class MovieDto {
   
    private Integer movieId;

    
    @NotBlank(message = "Please provide movie's name")
    private String  title;

  
    @NotBlank(message = "Please provide movie's director's name")
    private String director;
    
   
    @NotBlank(message = "Please provide movie's studio name")
    private  String studio;

   
  
    private Set<String> movieCast; //collection of string 

    
    private Integer releaseYear;

   
    @NotBlank(message = "Please provide movie's Poster")
    private String poster ; //img name

    @NotBlank(message = "Please provide  Poster's URL")
    private String posterUrl ; //img url

}

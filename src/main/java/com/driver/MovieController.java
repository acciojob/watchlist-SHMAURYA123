package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;
@RestController
@RequestMapping("/movies")
public class MovieController {
   @Autowired
   MovieService movieService;
@PostMapping("/add-movie")
   public ResponseEntity<String> addMovie(@RequestBody() Movie movie){
    movieService.addMovie(movie);
    return new ResponseEntity<>("Add Movie Successfully", HttpStatus.CREATED);
   }
@PostMapping("/add-director")
   public ResponseEntity<String> addDirector(@RequestBody() Director director){
    movieService.addDirector(director);
    return new ResponseEntity<>("Add Director Successfully",HttpStatus.CREATED);
   }
  @PutMapping("/add-movie-director-pair")
   public ResponseEntity<String> addMovieDirectorPair(@RequestParam("movie-name")String movie_name,@RequestParam("director name") String director_name){
      movieService.addMovieDirectorPair(movie_name,director_name);
    return new ResponseEntity<>("MovieDirector Pair add Successfully",HttpStatus.CREATED);
   }
@GetMapping("/get-movie-by-name/{name}")
   public ResponseEntity<Movie> getMovieByName(@PathVariable("name") String movie_name){
    return new ResponseEntity<>(movieService.getMovieByName(movie_name),HttpStatus.CREATED);
   }
 @GetMapping("/get-director-by-name/{name}")
   public ResponseEntity<Director> getDirectorByName(@PathVariable("name") String director_name){
    return new ResponseEntity<>(movieService.getDirectorByName(director_name),HttpStatus.CREATED);
   }

  @GetMapping("/get-movies-by-director-name/{director}")
   public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable("director") String director_name){
    return new ResponseEntity<>(movieService.getMoviesByDirectorName(director_name),HttpStatus.CREATED);
   }
@GetMapping("/get-all-movies")
   public ResponseEntity<List<String>> findAllMovies(){
    return  new ResponseEntity<>(movieService.findAllMovies(),HttpStatus.CREATED);
   }
  @DeleteMapping("/delete-director-by-name")
   public ResponseEntity<String> deleteDirectorByName(@RequestParam String director_name){
      movieService.deleteDirectorByName(director_name);
    return new ResponseEntity<>("Delete director and its movie successfully",HttpStatus.CREATED);
   }
@DeleteMapping("/delete-all-directors")
   public ResponseEntity<String> deleteAllDirectors(){
    movieService.deleteAllDirectors();
    return new ResponseEntity<>("Delete all directors & all movie by them successfully",HttpStatus.CREATED);
   }

}

package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MovieService {

    @Autowired
   MovieRepository mr;

    public void addMovie(Movie movie) {
      mr.addMovie(movie);
    }

    public void addDirector(Director director) {
        mr.addDirector(director);
    }

    public void addMovieDirectorPair(String movieName, String directorName) {
        mr.addMovieDirectorPair(movieName,directorName);
    }

    public Movie getMovieByName(String movieName) {
        return mr.getMovieByName(movieName);
    }

    public Director getDirectorByName(String directorName) {
        return mr.getDirectorByName(directorName);
    }

    public List<String> getMoviesByDirectorName(String directorName) {
        return mr.getMoviesByDirectorName(directorName);
    }

    public void deleteDirectorByName(String directorName) {
        mr.deleteDirectorByName(directorName);
    }

    public void deleteAllDirectors() {
        mr.deleteAllDirectors();
    }



    public List<String> findAllMovies() {
        return mr.findAllMovies();
    }
}

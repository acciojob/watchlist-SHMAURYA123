package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@Repository
public class MovieRepository {

    HashMap<String,Movie> m=new HashMap<>();
    HashMap<String,Director>d=new HashMap<>();
    HashMap<String, List<String>> pair=new HashMap<>();
    public void addMovie(Movie movie) {
        if(!m.containsKey(movie.getName())){
            m.put(movie.getName(),movie);
        }
    }

    public void addDirector(Director director) {
        if(!d.containsKey(director.getName())){
            d.put(director.getName(),director);
        }
    }

    public void addMovieDirectorPair(String movieName, String directorName) {
        if(!pair.containsKey(directorName)){
            List<String> temp=new ArrayList<>();
            temp.add(movieName);
            pair.put(directorName,temp);
        }else{
            List<String> temp=pair.get(directorName);
            if(!temp.contains(movieName)){
                temp.add(movieName);
                pair.put(directorName,temp);
            }
}
    }

    public Movie getMovieByName(String movieName) {
         if(m.containsKey(movieName)){
             return m.get(movieName);
         }
         return null;
    }

    public Director getDirectorByName(String directorName) {
        if(d.containsKey(directorName)){
            return d.get(directorName);
        }
        return null;
    }

    public List<String> getMoviesByDirectorName(String directorName) {
    if(pair.containsKey(directorName)){
        return pair.get(directorName);
    }
    return new ArrayList<>();
    }

    public void deleteDirectorByName(String directorName) {
        List<String> l=new ArrayList<>();
        if(pair.containsKey(directorName)){
            l=pair.get(directorName);
            pair.remove(directorName);
        }
        this.d.remove(directorName);
        for(String s:l){
            m.remove(s);
        }
    }

    public void deleteAllDirectors() {
        for(String s:pair.keySet()){
            deleteDirectorByName(s);
        }
        for(String s:d.keySet()){
            d.remove(s);
        }
    }

    public List<String> findAllMovies() {
        return new ArrayList<>(m.keySet());
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Java_project_SGU.DTO;

import Java_project_SGU.DAL.DAL_Implement;
import Java_project_SGU.DTO.Movie;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 *
 * @author ADMIN
 */
public class ClassListMovie {
    List<Movie> movies;

    public ClassListMovie() {
        movies = new ArrayList<Movie>();
    }

    public ClassListMovie(List<Movie> movies) {
        this.movies = movies;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
    
    public void addMovie(Movie movie) {
        this.movies.add(movie);
    }

    public void removeMovie(int selectRowMovie) {
        this.movies.remove(selectRowMovie);
    }

    public void updateMovie(int selectRowMovie, Movie movieUpdate) {
        this.movies.set(selectRowMovie, movieUpdate);
    }

    public void searchMovies(String searchMovieInput) {
        this.movies = new DAL_Implement().readMovieFromDS();
        
        ArrayList <Movie> rsMovies = new ArrayList<>();
        Pattern pattern = Pattern.compile("^.*" + searchMovieInput + ".*$", 
                Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
        for (Movie movie : movies) {
            String nameMovie = movie.getNameMovie();
            String idMovie = movie.getIdMovie();
            String opdateMovie = new SimpleDateFormat("dd/MM/yyyy")
                    .format(movie.getOpeningDate());
            String country = movie.getCountry();
            String ageLimit = "" + movie.getAgeLimit();
            String typeMovie = movie.getTypeMovie();
            String time = movie.getTime() + "";
            if (pattern.matcher(idMovie).matches() 
                    || pattern.matcher(nameMovie).matches()
                    || pattern.matcher(opdateMovie).matches()
                    || pattern.matcher(country).matches()
                    || pattern.matcher(ageLimit).matches()
                    || pattern.matcher(typeMovie).matches()
                    || pattern.matcher(time).matches()) {
                rsMovies.add(movie);
                continue;
            }
        }
        this.movies = rsMovies;
    }
    
    public void fillMovieBySearchName(String nameMovie) {
        Pattern nameSearchPT = Pattern.compile("^.*" + nameMovie + ".*$", 
                Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE | Pattern.CANON_EQ);
        ArrayList<Movie> rsListMovie = new ArrayList<>();
        for (Movie movie : this.movies) {
            if (nameSearchPT.matcher(movie.getNameMovie()).matches()) {
                rsListMovie.add(movie);
            }
        }
        this.movies.clear();
        this.movies = rsListMovie;
    }
}

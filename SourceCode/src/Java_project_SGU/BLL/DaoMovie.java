/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Java_project_SGU.BLL;

import Java_project_SGU.DAL.DAL_Implement;
import Java_project_SGU.DTO.Movie;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class DaoMovie implements DaoInterface<Movie>{
    private DAL_Implement dal;
    private ArrayList<Movie> listMovie;

    public DaoMovie() {
        dal = new DAL_Implement();
        this.listMovie = (ArrayList<Movie>) dal.readMovieFromDS();
    }
    
    @Override
    public ArrayList<Movie> getAll() {
        this.listMovie = (ArrayList<Movie>) dal.readMovieFromDS();
        return this.listMovie;
    }

    @Override
    public Movie getById(Movie o) {
        for (Movie movie : this.listMovie) {
            if (movie.equals(o)) return movie;
        }
        return null;
    }

    @Override
    public int insert(Movie o) {
        if (getById(o) == null) {
            return 0;
        }
        this.listMovie.add(o);
        dal.insertMovieDataToSql(o);
        return 1;
    }

    @Override
    public int insertAll(ArrayList<Movie> o) {
        for (Movie movie : o) {
            if (insert(movie) == 0) return 0;
        }
        return 1;
    }

    @Override
    public int delete(Movie o) {
        if (getById(o) == null) {
            return 0;
        }
        this.listMovie.remove(o);
        dal.deleteMovie(o);
        return 1;
    }

    @Override
    public int deleteAll(ArrayList<Movie> o) {
        for (Movie movie : o) {
            if (delete(movie) == 0) return 0;
        }
        return 1;
    }

    @Override
    public int update(Movie t) {
        if (getById(t) == null) {
            return 0;
        }
        this.listMovie.remove(t);
        this.listMovie.add(t);
        dal.updateMovie(t);
        return 1;
    }
}

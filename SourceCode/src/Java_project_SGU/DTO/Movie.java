/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Java_project_SGU.DTO;

import Java_project_SGU.Exception.InfoFilterImp;
import Java_project_SGU.Exception.InvalidBirthdayException;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.swing.JOptionPane;

/**
 *
 * @author ADMIN
 */
public class Movie implements Serializable{
    public static int idMovieAuto = 1;
    //
    private String idMovie; // auto
    private String nameMovie;
    private int time;
    private int ageLimit;
    private Date openingDate;
    private String laguage;
    private String country;
    private String producer;
    private String content;
    private String typeMovie;
    private String director;
    private boolean isShowing;
    private String linkImage;

    public Movie() {
    }

    public Movie(String idMovie, String nameMovie, int time, int ageLimit, 
            String openingDate, String laguage, String country, String producer,
            String content, String typeMovie)
            throws ParseException, InvalidBirthdayException {
        this.setIdMovie(idMovie);
        this.nameMovie = nameMovie;
        this.time = time;
        this.ageLimit = ageLimit;
        this.setOpeningDate(openingDate);
        this.laguage = laguage;
        this.country = country;
        this.producer = producer;
        this.content = content;
        this.typeMovie = typeMovie;
    }

    public Movie(String idMovie, String nameMovie, int time, int ageLimit, String 
            openingDate, String laguage, String country, String producer, 
            String content, String typeMovie, String director, 
            boolean isShowing, String linkImage) throws ParseException, InvalidBirthdayException {
        this.setIdMovie(idMovie);
        this.nameMovie = nameMovie;
        this.time = time;
        this.ageLimit = ageLimit;
        this.setOpeningDate(openingDate);
        this.laguage = laguage;
        this.country = country;
        this.producer = producer;
        this.content = content;
        this.typeMovie = typeMovie;
        this.director = director;
        this.isShowing = isShowing;
        this.linkImage = linkImage;
    }
    
    public static int getIdMovieAuto() {
        return idMovieAuto;
    }

    public static void setIdMovieAuto(int idMovieAuto) {
        Movie.idMovieAuto = idMovieAuto;
    }

    public String getIdMovie() {
        return idMovie;
    }

    public void setIdMovie(String idMovie) {
        if (idMovie != null) {
            this.idMovie = idMovie;
        } else {
            this.idMovie = "MOV" + Movie.idMovieAuto;
            Movie.idMovieAuto++;
        }
    }

    public String getNameMovie() {
        return nameMovie;
    }

    public void setNameMovie(String nameMovie) {
        this.nameMovie = nameMovie;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getAgeLimit() {
        return ageLimit;
    }

    public void setAgeLimit(int ageLimit) {
        this.ageLimit = ageLimit;
    }

    public Date getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(String openingDate) throws ParseException, InvalidBirthdayException {
        InfoFilterImp infoFilterImp = new InfoFilterImp();
        try {
            if (infoFilterImp.isBirthdayValid(openingDate)) {
                this.openingDate = new SimpleDateFormat("dd/MM/yyyy").parse(openingDate);
            }
        } catch (InvalidBirthdayException ex) {
            throw ex;
        } catch (ParseException ex) {
            throw ex;
        }
        
    }

    public String getLaguage() {
        return laguage;
    }

    public void setLaguage(String laguage) {
        this.laguage = laguage;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTypeMovie() {
        return typeMovie;
    }

    public void setTypeMovie(String typeMovie) {
        this.typeMovie = typeMovie;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public boolean isIsShowing() {
        return isShowing;
    }

    public void setIsShowing(boolean isShowing) {
        this.isShowing = isShowing;
    }

    public String getLinkImage() {
        return linkImage;
    }

    public void setLinkImage(String linkImage) {
        this.linkImage = linkImage;
    }

    @Override
    public String toString() {
        return "Movie{" + "idMovie=" + idMovie + ", nameMovie=" + nameMovie + ", time=" + time + ", ageLimit=" + ageLimit + ", openingDate=" + openingDate + ", laguage=" + laguage + ", country=" + country + ", producer=" + producer + ", content=" + content + ", typeMovie=" + typeMovie + ", director=" + director + ", isShowing=" + isShowing + ", linkImage=" + linkImage + '}';
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.idMovie);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Movie other = (Movie) obj;
        return Objects.equals(this.idMovie, other.idMovie);
    }
}
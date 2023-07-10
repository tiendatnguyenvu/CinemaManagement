/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Java_project_SGU.DTO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author ADMIN
 */
public class ShowTime {
    public static int idAutoST = 1;
    private String idShowTime;
    private Date startTime;
    private Movie movie;
    private Room room;
    private String movieFomart;
    private int ticketPrice;
    private boolean isChoosen;

    public ShowTime() {
        this.movie = new Movie();
        this.room = new Room();
    }

    public ShowTime(String idShowTime,String startTime, Movie movie, 
            Room room, String movieFomart, int ticketPrice, boolean isChoosen) {
        this();
        this.setIdShowTime(idShowTime);
        this.setStartTime(startTime);
        this.movie = movie;
        this.room = room;
        this.movieFomart = movieFomart;
        this.ticketPrice = ticketPrice;
        this.isChoosen = isChoosen;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        try {
            this.startTime = (Date) new 
            SimpleDateFormat("HH:mm dd/MM/yyyy").parse(startTime);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public String getMovieFomart() {
        return movieFomart;
    }

    public void setMovieFomart(String movieFomart) {
        this.movieFomart = movieFomart;
    }

    public static int getIdAutoST() {
        return idAutoST;
    }

    public static void setIdAutoST(int idAutoST) {
        ShowTime.idAutoST = idAutoST;
    }

    public String getIdShowTime() {
        return idShowTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }
    
    

    public void setIdShowTime(String idShowTime) {
        if (idShowTime != null) {
            this.idShowTime = idShowTime;
        } else {
            this.idShowTime = ShowTime.idAutoST + "";
            ShowTime.idAutoST++;
        }
    }
    
    public int getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(int ticketPrice) {
        ticketPrice = ticketPrice;
    }

    public boolean isIsChoosen() {
        return isChoosen;
    }

    public void setIsChoosen(boolean isChoosen) {
        this.isChoosen = isChoosen;
    }
    
    
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.startTime);
        hash = 37 * hash + Objects.hashCode(this.movie);
        hash = 37 * hash + Objects.hashCode(this.room);
        hash = 37 * hash + Objects.hashCode(this.movieFomart);
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
        final ShowTime other = (ShowTime) obj;
        if (!Objects.equals(this.movieFomart, other.movieFomart)) {
            return false;
        }
        if (!Objects.equals(this.startTime, other.startTime)) {
            return false;
        }
        if (!Objects.equals(this.movie, other.movie)) {
            return false;
        }
        return Objects.equals(this.room, other.room);
    }

    @Override
    public String toString() {
        return "ShowTime{" + "idShowTime=" + idShowTime + ", startTime=" + new SimpleDateFormat("HH:mm dd/MM/yyyy").format(startTime) + ", movie=" + movie.getIdMovie() + ", room=" + room.getIdRoom() + ", movieFomart=" + movieFomart + ", ticketPrice=" + ticketPrice + ", isChoosen=" + isChoosen + '}';
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Java_project_SGU.DTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author ADMIN
 */
public class ClassListShowTime {
    private List<ShowTime> listShowtime;

    public ClassListShowTime() {
        this.listShowtime = new ArrayList<>();
    }

    public ClassListShowTime(List<ShowTime> classListShowtime) {
        this.listShowtime = classListShowtime;
    }

    public List<ShowTime> getClassListShowtime() {
        return listShowtime;
    }

    public void setClassListShowtime(List<ShowTime> classListShowtime) {
        this.listShowtime = classListShowtime;
    }
    
    public void addShowTime(ShowTime showTime) {
        this.listShowtime.add(showTime);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.listShowtime);
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
        final ClassListShowTime other = (ClassListShowTime) obj;
        return Objects.equals(this.listShowtime, other.listShowtime);
    }

    public void removeST(int indexRemove) {
        this.listShowtime.remove(indexRemove);
    }
    
    public void removeShowTime(ShowTime showtime) {
        this.listShowtime.remove(showtime);
    }
    
    public void updateST(int indexUpdate, ShowTime showTimeUpdate) {
        this.listShowtime.remove(showTimeUpdate);
        this.listShowtime.add(indexUpdate, showTimeUpdate);
    }
}

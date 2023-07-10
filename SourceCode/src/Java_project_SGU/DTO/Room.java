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
public class Room {
    private String idRoom;
    private int numRowChair; 
    private int numColChair;
    // so luong ghe thuong = numRowChair *  numColChair
    private int numNormalChair;
    private int numPairChair;
    private int numVipChair;
    private int numAllChair;
    private List<Seat> listSeat;

    public Room() {
        this.listSeat = new ArrayList<>();
    }

    public Room(String idRoom, int numRowChair, int numColChair) {
        this.idRoom = idRoom;
        this.numRowChair = numRowChair;
        this.numColChair = numColChair;
    }
    
    public Room(String idRoom, int numRowChair, 
            int numColChair, List<Seat> listSeat) {
        this.idRoom = idRoom;
        this.numRowChair = numRowChair;
        this.numColChair = numColChair;
        this.listSeat = listSeat;
    }

    public Room(String idRoom, int numRowChair, int numColChair, int numPairChair, int numVipChair, List<Seat> listSeat) {
        this.idRoom = idRoom;
        this.numRowChair = numRowChair;
        this.numColChair = numColChair;
        this.numPairChair = numPairChair;
        this.numVipChair = numVipChair;
        this.listSeat = listSeat;
    }

    public String getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(String idRoom) {
        this.idRoom = idRoom;
    }

    public int getNumRowChair() {
        return numRowChair;
    }

    public void setNumRowChair(int numRowChair) {
        this.numRowChair = numRowChair;
    }

    public int getNumColChair() {
        return numColChair;
    }

    public void setNumColChair(int numColChair) {
        this.numColChair = numColChair;
    }

    public List<Seat> getListSeat() {
        return listSeat;
    }

    public void setListSeat(List<Seat> listSeat) {
        this.listSeat = listSeat;
    }

    @Override
    public String toString() {
        return "Room{" + "idRoom=" + idRoom + ", numRowChair=" + numRowChair + ", numColChair=" + numColChair + ", listSeat=" + listSeat + '}';
    }

    
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.idRoom);
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
        final Room other = (Room) obj;
        return Objects.equals(this.idRoom, other.idRoom);
    }
    
    public void calcuNormalChair() {
        this.numNormalChair = this.numColChair * this.numColChair;
    }
    
    public void calcuAllChair() {
        numAllChair =  this.numNormalChair + this.numColChair * this.numColChair;
    }
}

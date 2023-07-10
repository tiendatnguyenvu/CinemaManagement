/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Java_project_SGU.DTO;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class ClassListRoom {
    private List<Room> rooms;

    public ClassListRoom() {
        this.rooms = new ArrayList<>();
    }

    public ClassListRoom(List<Room> rooms) {
        this.rooms = rooms;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }
    
    
}

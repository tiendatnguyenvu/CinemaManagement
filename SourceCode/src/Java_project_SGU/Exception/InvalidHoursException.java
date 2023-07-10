/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Java_project_SGU.Exception;

/**
 *
 * @author ADMIN
 */
public class InvalidHoursException extends Exception{
    private String invalidHour;

    public InvalidHoursException(String message, String ivalidHour) {
        super(message);
        this.invalidHour = invalidHour;
    }

    public String getInvalidHour() {
        return invalidHour;
    }

    public void setInvalidHour(String invalidHour) {
        this.invalidHour = invalidHour;
    }
    
    
}

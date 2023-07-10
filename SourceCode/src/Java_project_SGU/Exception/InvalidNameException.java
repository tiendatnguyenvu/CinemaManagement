/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Java_project_SGU.Exception;

/**
 *
 * @author ADMIN
 */
public class InvalidNameException extends Exception {
    private String name;

    public InvalidNameException() {
    }

    public InvalidNameException(String message, String name) {
        super(message);
        this.name = name;
    }

    public String getInvalidDob() {
        return name;
    }

    public void setInvalidDob(String invalidDob) {
        this.name = invalidDob;
    }
}

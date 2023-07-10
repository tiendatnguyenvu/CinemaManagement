/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Java_project_SGU.Exception;

/**
 *
 * @author ADMIN
 */
public class InvalidIdPersonException extends Exception{
    private String invalidPerson;

    public InvalidIdPersonException() {
    }

    public InvalidIdPersonException(String message, String invalidPerson) {
        super(message);
        this.invalidPerson = invalidPerson;
    }

    public String getInvalidPerson() {
        return invalidPerson;
    }

    public void setInvalidPerson(String invalidPerson) {
        this.invalidPerson = invalidPerson;
    }
}

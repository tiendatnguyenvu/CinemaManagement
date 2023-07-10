/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Java_project_SGU.Exception;

/**
 *
 * @author ADMIN
 */
public class InvalidPasswordCusException extends Exception{
    private String invalidPasswordCus;

    public InvalidPasswordCusException() {
    }

    public InvalidPasswordCusException(String message, String invalidPasswordCus) {
        super(message);
        this.invalidPasswordCus = invalidPasswordCus;
    }

    public String getInvalidPasswordCus() {
        return invalidPasswordCus;
    }

    public void setInvalidPasswordCus(String invalidPasswordCus) {
        this.invalidPasswordCus = invalidPasswordCus;
    }
}

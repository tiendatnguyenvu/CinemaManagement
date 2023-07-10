/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Java_project_SGU.Exception;

/**
 *
 * @author ADMIN
 */

public class InvalidPhoneException extends Exception{
    private String invalidPhone;

    public InvalidPhoneException() {}

    public InvalidPhoneException(String message, String invalidPhone) {
        super(message);
        this.invalidPhone = invalidPhone;
    }

    public String getInvalidPhone() {
        return invalidPhone;
    }

    public void setInvalidPhone(String invalidPhone) {
        this.invalidPhone = invalidPhone;
    }
}

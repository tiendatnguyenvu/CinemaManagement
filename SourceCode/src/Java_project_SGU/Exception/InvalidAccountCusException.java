/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Java_project_SGU.Exception;

/**
 *
 * @author ADMIN
 */
public class InvalidAccountCusException extends Exception{
    private String invalidAccountCus;

    public InvalidAccountCusException() {
    }

    public InvalidAccountCusException(String message, String invalidAccountCus) {
        super(message);
        this.invalidAccountCus = invalidAccountCus;
    }

    public String getInvalidAccountCus() {
        return invalidAccountCus;
    }

    public void setInvalidAccountCus(String invalidAccountCus) {
        this.invalidAccountCus = invalidAccountCus;
    }
}

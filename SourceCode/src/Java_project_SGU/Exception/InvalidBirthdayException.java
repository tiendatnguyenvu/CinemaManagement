/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Java_project_SGU.Exception;

import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class InvalidBirthdayException extends Exception {
    private String inValidBirthday;

    public InvalidBirthdayException(String message,String inValidBirthday) {
        super(message);
        this.inValidBirthday = inValidBirthday;
    }

    public String getInValidBirthday() {
        return inValidBirthday;
    }

    public void setInValidBirthday(String inValidBirthday) {
        this.inValidBirthday = inValidBirthday;
    }
}

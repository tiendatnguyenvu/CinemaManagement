/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Java_project_SGU.Exception;

import javax.swing.JTextField;

/**
 *
 * @author ADMIN
 */

public interface InfoFilter {
    boolean isNamePersonValid (String id)throws InvalidNameException; 
    boolean isEmailPersonValid (String id) throws InvalidEmailException; 
    boolean isPhonePersonValid (String id) throws InvalidPhoneException; 
    boolean isIdPersonValid (String id) throws InvalidIdPersonException;
    boolean isAccountCus(String id) throws InvalidAccountCusException;
    boolean isPasswordValid (String id) throws InvalidPasswordCusException;
    boolean isBirthdayValid (String id) throws InvalidBirthdayException;
    boolean isHourValid (String id) throws InvalidHoursException;
    public boolean isMoneyValid(String money) throws InvalidMoneyException;

    public boolean checkParseTime(String timeTxt);
}

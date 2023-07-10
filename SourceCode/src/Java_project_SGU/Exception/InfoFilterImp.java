/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Java_project_SGU.Exception;

import java.util.regex.Pattern;
import javax.swing.JTextField;

/**
 *
 * @author ADMIN
 */
public class InfoFilterImp implements InfoFilter {
    @Override
    public boolean isNamePersonValid(String name) throws InvalidNameException {
        String regex = "^[a-zA-ZẮẰẲẴẶĂẤẦẨẪẬÂÁÀÃẢẠĐẾỀỂỄỆÊÉÈẺẼẸÍÌỈĨỊỐỒỔỖỘÔỚỜỞỠ"
                + "ỢƠÓÒÕỎỌỨỪỬỮỰƯÚÙỦŨỤÝỲỶỸỴ]+[a-zA-ZẮẰẲẴẶĂẤẦẨẪẬÂÁÀÃẢẠĐẾỀỂỄỆÊÉÈẺẼẸÍÌỈĨỊỐỒỔỖỘÔỚỜỞỠ"
                + "ỢƠÓÒÕỎỌỨỪỬỮỰƯÚÙỦŨỤÝỲỶỸỴ\\s]+$";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE
                | Pattern.CANON_EQ | Pattern.UNICODE_CASE);
        if (pattern.matcher(name).matches()) {
            return true;
        } else {
            String msg = "TÊN KHÁCH HÀNG KHÔNG HỢP LỆ: " + name;
            throw new InvalidNameException(msg, name);
        }
    }
    
    @Override
    public boolean isEmailPersonValid(String email) throws InvalidEmailException {
        String regex = "^[a-z]+[a-z0-9_.]*@gmail.com$";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        if (pattern.matcher(email).matches()) {
            return true;
        } else {
            String msg = "EMAIL KHÁCH HÀNG KHÔNG HỢP LỆ: " + email;
            throw new InvalidEmailException(msg, email);
        }
    }

    @Override
    public boolean isIdPersonValid(String idPerson) throws InvalidIdPersonException {
        String regex = "^[0-9]{9,12}$";
        Pattern pattern = Pattern.compile(regex);
        if (pattern.matcher(idPerson).matches()) {
            return true;
        } else {
            String msg = "CCCD/ CMND KHÔNG HỢP LỆ: " + idPerson;
            throw new InvalidIdPersonException(msg, idPerson);
        }
    }

    @Override
    public boolean isPhonePersonValid(String phoneNumber) throws InvalidPhoneException {
        String regex = "^(03|04|07|08|09)[0-9]{8}$";
        Pattern pattern = Pattern.compile(regex);
        if (pattern.matcher(phoneNumber).matches()) {
            return true;
        } else {
            String msg = "SỐ ĐIỆN THOẠI KHÔNG HỢP LỆ: " + phoneNumber;
            throw new InvalidPhoneException(msg, phoneNumber);
        }
    }

    @Override
    public boolean isAccountCus(String account) throws InvalidAccountCusException {
        String regex = "^.*[a-z]+.*$";
        String regex2 = "^.*[0-9]+.*$";
        String regex3 = "^.{8,}$";

        Pattern pattern = Pattern.compile(regex);
        Pattern pattern2 = Pattern.compile(regex2);
        Pattern pattern3 = Pattern.compile(regex3);
        
        if (pattern.matcher(account).matches()
                && pattern2.matcher(account).matches()
                && pattern3.matcher(account).matches()) {
            return true;
        } else {
            String msg = "TÀI KHOẢN KHÔNG HỢP LỆ: " + account;
            throw new InvalidAccountCusException(msg, account);
        }
    }

    @Override
    public boolean isPasswordValid(String password) throws InvalidPasswordCusException {
        String regex1 = "^.*[0-9]+.*$";
        String regex2 = "^.*[A-Z]+.*$";
        String regex3 = "^.*[a-z]+.*$";
        String regex4 = "^.*[~!@#$%^&*._]+.*$";
        String regex5 = "^.{8,}$";
        Pattern pattern1 = Pattern.compile(regex1);
        Pattern pattern2 = Pattern.compile(regex2);
        Pattern pattern3 = Pattern.compile(regex3);
        Pattern pattern4 = Pattern.compile(regex4);
        Pattern pattern5 = Pattern.compile(regex5);

        if (pattern1.matcher(password).matches()
                && pattern2.matcher(password).matches()
                && pattern3.matcher(password).matches()
                && pattern4.matcher(password).matches()
                && pattern5.matcher(password).matches()) {
            return true;
        } else {
            String msg = "MẬT KHẨU KHÔNG HỢP LỆ: " + password;
            throw new InvalidPasswordCusException(msg, password);
        }
    }

    @Override
    public boolean isBirthdayValid(String birthDay) throws InvalidBirthdayException {
        String regex = "^\\d{1,2}/\\d{1,2}/\\d{4}$";
        Pattern pattern = Pattern.compile(regex);
        if (pattern.matcher(birthDay).matches()) {
            return true;
        } else {
            String msg = "ĐỊNH DẠNG NGÀY KHÔNG HỢP LỆ: " + birthDay;
            throw new InvalidBirthdayException(msg, birthDay);
        }
    }

    @Override
    public boolean isHourValid(String hour) throws InvalidHoursException {
        Pattern checkHour = Pattern.compile("^\\d{1,2}:\\d{1,2}$");
        if (checkHour.matcher(hour).matches()) {
            return true;
        } else {
            String msg = "ĐỊNH DẠNG GIỜ KHÔNG HỢP LỆ!";
            throw new InvalidHoursException(msg, hour);
        }
    }
    
    public boolean isMoneyValid(String money) throws InvalidMoneyException {
        Pattern checkHour = Pattern.compile("^[0-9]+$");
        if (checkHour.matcher(money).matches()) {
                return true;
        } else {
            String msg = "ĐỊNH DẠNG TIỀN TỆ KHÔNG HỢP LỆ!";
            throw new InvalidMoneyException(msg, money);
        }
    }

    @Override
    public boolean checkParseTime(String timeTxt) {
        Pattern pattern = Pattern.compile("^[0-9]+$");
        if (pattern.matcher(timeTxt).matches()) {
            return true;
        }
        return false;
    }
    
     public boolean checkHours(String hour) {
        Pattern checkHour = Pattern.compile("^\\d{1,2}:\\d{1,2}$");
        if (checkHour.matcher(hour).matches()) {
            return true;
        } else {
            return false;
        }
    }
     
     public boolean checkDate(String birthDay) {
        String regex = "^\\d{1,2}/\\d{1,2}/\\d{4}$";
        Pattern pattern = Pattern.compile(regex);
        if (pattern.matcher(birthDay).matches()) {
            return true;
        } else {
            return false;
        }
    }
}

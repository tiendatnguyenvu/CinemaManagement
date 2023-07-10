/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Java_project_SGU.DTO;

import Java_project_SGU.Exception.InfoFilterImp;
import Java_project_SGU.Exception.InvalidAccountCusException;
import Java_project_SGU.Exception.InvalidBirthdayException;
import Java_project_SGU.Exception.InvalidEmailException;
import Java_project_SGU.Exception.InvalidIdPersonException;
import Java_project_SGU.Exception.InvalidNameException;
import Java_project_SGU.Exception.InvalidPasswordCusException;
import Java_project_SGU.Exception.InvalidPhoneException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class Customer extends Person {
    private static int idCustomerAuto = 1000;
    private String id_customer;
    private String account;
    private String password;
    private boolean isSavePW;
    private Date startDate;

    public Customer() { 
        super();
        startDate = new Date();
    }
    
    

    public Customer(String id_customer, String account, String password, 
            boolean isSavePW) {
        this();
        this.account = account;
        this.password = password;
        this.isSavePW = isSavePW;
        this.setId_customer(id_customer); 

    }

    public Customer(String id_customer, String account, String password, 
            boolean isSavePW, String fullName, String email, String 
                    phoneNumber, String address, String birthDay, 
                    boolean sex, String id_person) throws InvalidNameException,
            InvalidEmailException, InvalidPhoneException, 
            InvalidBirthdayException, InvalidIdPersonException,
            InvalidAccountCusException, InvalidPasswordCusException  {
        super(fullName, email, phoneNumber, address, birthDay, sex, id_person) ;
        this.setId_customer(id_customer);
        this.setAccount(account);
        this.setPassword(password);
        this.isSavePW = isSavePW;
    }

    public String getId_customer() {
        return id_customer;
    }

    //////
    public void setId_customer(String id_customer) {
        if (id_customer != null) {
            this.id_customer =id_customer;
        } else {
            String idTmp = "CUS" + idCustomerAuto;
            this.id_customer = idTmp;
            Customer.idCustomerAuto++; 
        }
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) throws InvalidAccountCusException {
        InfoFilterImp infoFilter = new InfoFilterImp();
        try {
            if (infoFilter.isAccountCus(account)) {
                this.account = account;
            }
        } catch (InvalidAccountCusException ex) {
            throw ex;
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) throws InvalidPasswordCusException {
        InfoFilterImp infoFilter = new InfoFilterImp();
        try {
            if (infoFilter.isPasswordValid(password)) {
                this.password = password;
            }
        } catch (InvalidPasswordCusException ex) {
            throw ex;
        }
    }

    public boolean getIsSavePW() {
        return isSavePW;
    }

    public void setIsSavePW(boolean isSavePW) {
        this.isSavePW = isSavePW;
    }

    public static int getIdCustomerAuto() {
        return idCustomerAuto;
    }

    public static void setIdCustomerAuto(int idCustomerAuto) {
        Customer.idCustomerAuto = idCustomerAuto;
    }       

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
        try {
            this.startDate = simpleDateFormat.parse(startDate);
        } catch (ParseException ex) {
            throw ex;
        }
    }
    
    @Override
    public String toString() {
        return "Customer{" + "id_customer=" + id_customer + ", account=" + account + ", password=" + password + ", isSavePW=" + isSavePW + '}';
    }
}

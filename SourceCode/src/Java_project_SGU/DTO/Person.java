/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Java_project_SGU.DTO;

import Java_project_SGU.Exception.InfoFilterImp;
import Java_project_SGU.Exception.InvalidEmailException;
import Java_project_SGU.Exception.InvalidIdPersonException;
import Java_project_SGU.Exception.InvalidNameException;
import Java_project_SGU.Exception.InvalidPhoneException;
import Java_project_SGU.Exception.InvalidBirthdayException;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author ADMIN
 */
public class Person implements Serializable {
    private FullName fullName;
    private String email;
    private String phoneNumber;
    private String address;
    private Date birthDay;
    private boolean sex; // Man => true
    private String id_person;

    public Person() { this.fullName = new FullName(); }

    public Person(String fullName, String email, String phoneNumber, String 
            address, String birthDay, boolean sex, String id_person) 
            throws InvalidNameException, InvalidEmailException, 
            InvalidPhoneException, InvalidBirthdayException, 
            InvalidIdPersonException {
        this();
        this.setFullName(fullName);
        this.setEmail(email);
        this.setPhoneNumber(phoneNumber);
        this.address = address;
        this.setBirthDay(birthDay);
        this.sex = sex;
        this.setId_person(id_person);
    }
    
    

    public String getFullName() {
        return fullName.lastName + " " + fullName.midName + fullName.firstName;
    }
    
        public String getFirstName() {
            return fullName.firstName;
        }
    
    public void setFullName(String fullName) throws InvalidNameException {
        InfoFilterImp infoFilterImp = new InfoFilterImp();
        try {
            if (infoFilterImp.isNamePersonValid(fullName)) {
                String[] words = fullName.split("\\s+");
                this.fullName.lastName = words[0];
                this.fullName.firstName = words[words.length - 1];
                String midNameTmp = "";
                for (int i = 1; i < words.length - 1; i++) {
                    midNameTmp += words[i] + " ";
                }
                this.fullName.midName = midNameTmp;
            }
        } catch (InvalidNameException e) {
            throw e;
        }

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws InvalidEmailException {
        InfoFilterImp infoFilterImp = new InfoFilterImp();
        try {
            if (infoFilterImp.isEmailPersonValid(email)) {
                this.email = email;
            }
        } catch(InvalidEmailException ex) {
            throw ex;
        }
    }

    public void setPhoneNumber(String phoneNumber) throws InvalidPhoneException{
        InfoFilterImp infoFilterImp = new InfoFilterImp();
        try {
            if (infoFilterImp.isPhonePersonValid(phoneNumber)) {
                this.phoneNumber = phoneNumber;
            }
        } catch (InvalidPhoneException ex) {
            throw ex;
        }
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) throws InvalidBirthdayException {
        InfoFilterImp infoFilter = new InfoFilterImp();
        try {
            if (infoFilter.isBirthdayValid(birthDay)) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                this.birthDay = simpleDateFormat.parse(birthDay);
            }
        } catch (InvalidBirthdayException ex) {
            throw ex;
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
    }

    public boolean getSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getId_person() {
        return id_person;
    }

    public void setId_person(String id_person) throws InvalidIdPersonException{
        InfoFilterImp infoFilterImp = new InfoFilterImp();
        try {
            if (infoFilterImp.isIdPersonValid(id_person)) {
                this.id_person = id_person;
            }
        } catch (InvalidIdPersonException ex) {
            throw ex;
        }
        this.id_person = id_person;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.id_person);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Person other = (Person) obj;
        return Objects.equals(this.id_person, other.id_person);
    }

    //Inner class
    class FullName implements Serializable {

        private String firstName;
        private String midName;
        private String lastName;

        public FullName() {
        }
        
        public FullName(String firstName, String midName, String lastName) {
            this.firstName = firstName;
            this.midName = midName;
            this.lastName = lastName;
        }

        public String getMidName() {
            return midName;
        }

        public void setMidName(String midName) {
            this.midName = midName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getFullName() {
            return this.lastName + this.midName + " " + this.firstName;
        }

        @Override
        public String toString() {
            return "FullName{" + "firstName=" + firstName + ", midName=" + midName + ", lastName=" + lastName + '}';
        }
    }
}

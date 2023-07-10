package Java_project_SGU.DTO;

import Java_project_SGU.Exception.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class Staff extends Person {

    private static int autoStaffId = 1000;
    private String ID_Staff;
    private String password;
    private Date startDate;
    private boolean isWorking;
    private String nameTask;
    private boolean isDelete;
    private int numOfDateWorked;
    private int salaryDate;
    private String account;

    // constructor
    public Staff() {
        super();
    }
    
    public Staff(String fullName, String password, String ID_Person, String phoneNumber,
            String email, String address, String startDate, boolean sex, boolean isWorking, String nameTask,
            boolean isDelete, String birthDate, int numOfDateWorked, int salaryDay, String account) throws 
            InvalidNameException, InvalidPasswordCusException, InvalidBirthdayException, InvalidEmailException, 
            InvalidPhoneException, InvalidIdPersonException, ParseException, InvalidAccountCusException {
        super (fullName, email, phoneNumber, address, birthDate, sex, ID_Person);
        this.setPassword(password);
        this.setStartDate(startDate);
        this.setIsWorking(isWorking);
        this.setNameTask(nameTask);
        this.setIsDelete(isDelete);
        this.setNumOfDateWorked(numOfDateWorked);
        this.setSalaryDate(salaryDay);
        this.setAccount(account);
    }

    // getter and setter
    public String getID_Staff() {
        return ID_Staff;
    }

    public void setID_Staff(String iD_Staff) {
        if (iD_Staff == null) {
            this.ID_Staff = autoStaffId + "";
            autoStaffId++;
        } else {
            this.ID_Staff = iD_Staff;
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) throws InvalidPasswordCusException {
        InfoFilterImp infoFilterImp = new InfoFilterImp();
        try {
            if (infoFilterImp.isPasswordValid(password)) {
                this.password = password;
            }
        } catch (InvalidPasswordCusException ex) {
            throw ex;
        }
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) throws ParseException, InvalidBirthdayException {
        InfoFilterImp infoFilterImp = new InfoFilterImp();
        try {
            if (infoFilterImp.isBirthdayValid(startDate)) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                this.startDate = (Date) simpleDateFormat.parse(startDate);
            }
        } catch (InvalidBirthdayException ex) {
            throw ex;
        }
    }

    public boolean isIsWorking() {
        return isWorking;
    }

    public void setIsWorking(boolean isWorking) {
        this.isWorking = isWorking;
    }

    public String getNameTask() {
        return nameTask;
    }

    public void setNameTask(String nameTask) {
        this.nameTask = nameTask;
    }

    public boolean isIsDelete() {
        return isDelete;
    }

    public void setIsDelete(boolean isDelete) {
        this.isDelete = isDelete;
    }

    public int getNumOfDateWorked() {
        return numOfDateWorked;
    }

    public void setNumOfDateWorked(int numOfDateWorked) {
        this.numOfDateWorked = numOfDateWorked;
    }

    public int getSalaryDate() {
        return salaryDate;
    }

    public void setSalaryDate(int salaryDate) {
        this.salaryDate = salaryDate;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) throws InvalidAccountCusException {
        InfoFilterImp infoFilterImp = new InfoFilterImp();
        try {
            if (infoFilterImp.isAccountCus(account)) {
                this.account = account;
            }
        } catch (InvalidAccountCusException ex) {
            throw ex;
        }
    }

    // phương thức abtract
    public abstract void calSalary();

    // hàm phương thức
    public static int getAutoStaffId() {
        return autoStaffId;
    }

    public static void setAutoStaffId(int autoStaffId) {
        Staff.autoStaffId = autoStaffId;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + Objects.hashCode(this.ID_Staff);
        hash = 13 * hash + Objects.hashCode(this.password);
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
        final Staff other = (Staff) obj;
        if (!Objects.equals(this.ID_Staff, other.ID_Staff)) {
            return false;
        }
        return Objects.equals(this.password, other.password);
    }

}

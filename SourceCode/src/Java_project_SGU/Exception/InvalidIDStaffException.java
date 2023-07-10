
package Exception;

class InvalidIDStaffException extends Exception {
    private String IDStaff;
    
    // constructor
    public InvalidIDStaffException(String message, String IDStaff) {
        super(message);
        this.IDStaff = IDStaff;
    }

    public InvalidIDStaffException() {
    }
    
    // getter and setter

    public String getIDStaff() {
        return IDStaff;
    }

    public void setIDStaff(String IDStaff) {
        this.IDStaff = IDStaff;
    }
    
}

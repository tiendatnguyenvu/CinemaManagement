
package Java_project_SGU.Controller;

import Java_project_SGU.Controller.Sort.SortStaffByNameASC;
import Java_project_SGU.Controller.Sort.SortStaffByNameDESC;
import Java_project_SGU.Controller.Sort.*;
import Java_project_SGU.Controller.Sort.SortStaffByStartDateDESC;
import java.util.List;
import Java_project_SGU.DTO.Staff;

public class StaffControllerImp implements StaffController{

    @Override
    public void sortStaffByNameASC(List<Staff> staffs) {
        staffs.sort(new SortStaffByNameASC());
    }

    @Override
    public void sortStaffByNameDESC(List<Staff> staffs) {
        staffs.sort(new SortStaffByNameDESC());
    }

    @Override
    public void sortStaffByStartDateASC(List<Staff> staffs) {
        staffs.sort(new SortStaffByStartDateASC());
    }

    @Override
    public void sortStaffByStartDateDESC(List<Staff> staffs) {
        staffs.sort(new SortStaffByStartDateDESC());
    }

    @Override
    public List<Staff> addStaffByName(List<Staff> staffs, String name) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Staff> addStaffByDate(List<Staff> staffs, String frominputDate, String toinputDate) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}

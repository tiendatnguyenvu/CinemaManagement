
package Java_project_SGU.Controller;

import java.util.List;
import Java_project_SGU.DTO.Staff;

public interface StaffController {
    void sortStaffByNameASC(List<Staff> staffs);
    void sortStaffByNameDESC(List<Staff> staffs);
    void sortStaffByStartDateASC(List<Staff> staffs);
    void sortStaffByStartDateDESC(List<Staff> staffs);
    List<Staff> addStaffByName(List<Staff> staffs, String name);
    List<Staff> addStaffByDate(List<Staff> staffs, String frominputDate, String toinputDate);
}

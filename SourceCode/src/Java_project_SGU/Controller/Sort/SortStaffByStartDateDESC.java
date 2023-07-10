
package Java_project_SGU.Controller.Sort;

import java.util.Comparator;
import Java_project_SGU.DTO.Staff;

public class SortStaffByStartDateDESC implements Comparator<Staff>{
    @Override
    public int compare(Staff o1, Staff o2) {
        return o2.getStartDate().compareTo(o1.getStartDate());
    }
    
}

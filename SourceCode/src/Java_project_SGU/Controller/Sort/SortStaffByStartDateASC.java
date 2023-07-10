/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Java_project_SGU.Controller.Sort;

import Java_project_SGU.DTO.Staff;
import java.util.Comparator;

/**
 *
 * @author ADMIN
 */
public class SortStaffByStartDateASC implements Comparator<Staff>{
    @Override
    public int compare(Staff o1, Staff o2) {
        return o1.getStartDate().compareTo(o2.getStartDate());
    }
}

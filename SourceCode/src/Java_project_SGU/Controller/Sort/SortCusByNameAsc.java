/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Java_project_SGU.Controller.Sort;

import Java_project_SGU.DTO.Customer;
import java.util.Comparator;

/**
 *
 * @author ADMIN
 */
public class SortCusByNameAsc implements Comparator<Customer>{

    @Override
    public int compare(Customer o1, Customer o2) {
        return o1.getFirstName().compareTo(o2.getFirstName());
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Java_project_SGU.Controller;

import Java_project_SGU.DTO.Customer;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface CustomerController {
    void sortCusByNameASC(List<Customer> customers);
    void sortCusByNameDESC(List<Customer> customers);
    void sortCusByDateASC(List<Customer> dates);
    void sortCusByDateDESC(List<Customer> dates);
    void sortCusByAgeASC(List<Customer> birthDay);
    void sortCusByAgeDESC(List<Customer> birthDay);
    List<Customer> addCusByName(List<Customer> customers, String name);
    List<Customer> addCusByDate(List<Customer> listCusFromSql, String frominputDate, String toinputDate);
 }

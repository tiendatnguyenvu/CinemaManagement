/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Java_project_SGU.Controller;

import Java_project_SGU.Controller.Sort.SortCusByNameAsc;
import Java_project_SGU.Controller.Sort.SortCusByNameDesc;
import Java_project_SGU.Controller.Sort.SortCusByStartDateAsc;
import Java_project_SGU.Controller.Sort.SortCusByStartDateDesc;
import Java_project_SGU.DTO.Customer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

/**
 *
 * @author ADMIN
 */
public class CustomerControllerImp implements CustomerController{

    @Override
    public void sortCusByNameASC(List<Customer> customers) {
        customers.sort(new SortCusByNameAsc());
    }

    @Override
    public void sortCusByNameDESC(List<Customer> customers) {
        customers.sort(new SortCusByNameDesc());
    }

    @Override
    public void sortCusByDateASC(List<Customer> customers) {
        customers.sort(new SortCusByStartDateAsc());
    }

    @Override
    public void sortCusByDateDESC(List<Customer> customers) {
        customers.sort(new SortCusByStartDateDesc());
    }

    @Override
    public void sortCusByAgeASC(List<Customer> birthDay) {
        
    }

    @Override
    public void sortCusByAgeDESC(List<Customer> birthDay) {

    }

    @Override
    public List<Customer> addCusByName(List<Customer> customers, String name) {
        List<Customer> rs = new ArrayList<>();
        String regex = "^.*" + name + ".*$";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
        for (Customer customer: customers) {
            if (pattern.matcher(customer.getFullName()).matches()) {
                rs.add(customer);
            }
        }
        return rs;    
    }


    @Override
    public List<Customer> addCusByDate(List<Customer> listCusFromSql, String frominputDate, String toinputDate) {
        List<Customer> rs = new ArrayList<>();
        try {
            SimpleDateFormat dateFomart = new SimpleDateFormat("dd/MM/yyyy");
            Date fromDateParse = dateFomart.parse(frominputDate);
            Date toDateParse = dateFomart.parse(toinputDate);
            for (Customer customer : listCusFromSql) {
                if (customer.getStartDate().after(fromDateParse)
                        && customer.getStartDate().before(toDateParse)) {
                    rs.add(customer);
                }
            }
            return rs;
        } catch (ParseException ex) {
            Logger.getLogger(CustomerControllerImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public Customer addCusByPhoneNumber(List<Customer> customers, String phoneNumberInput) {
        for (Customer customer : customers) {
            if (customer.getPhoneNumber().equals(phoneNumberInput)) {
                return customer;
            }
        }
        return null;
    }
}

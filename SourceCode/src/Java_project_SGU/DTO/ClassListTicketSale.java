
package Java_project_SGU.DTO;

import Java_project_SGU.DAL.DAL_Implement;
import Java_project_SGU.Exception.InvalidNameException;
import Java_project_SGU.Exception.InvalidPhoneException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClassListTicketSale {
    private List<TicketSale> ticketSales;
    
    // constructor
    public ClassListTicketSale() {
        ticketSales = new ArrayList<>();
    }
    
    // getter and setter
    public List<TicketSale> getTicketSales() {
        return ticketSales;
    }

    public void setTicketSales(List<TicketSale> ticketSales) {
        this.ticketSales = ticketSales;
    }
    
    // phương thức làm việc với bảng
    public void loadInfoTicketSaleForTable() {
        DAL_Implement readTicketSaleSqlImp = new DAL_Implement();
        try {
            this.setTicketSales(readTicketSaleSqlImp.infoTicketSaleForTable());
        } catch (InvalidNameException ex) {
            Logger.getLogger(ClassListTicketSale.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidPhoneException ex) {
            Logger.getLogger(ClassListTicketSale.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(this.ticketSales.size());
    }
    
    public void add(TicketSale ts) {
        this.ticketSales.add(ts);
    }
  
    public void toString2() {
        for (TicketSale ticketSale : ticketSales) {
            System.out.println(ticketSale.getTotalMoney() + ", " + 
                    new SimpleDateFormat("dd/MM/yyyy").format(ticketSale.getSaleDate()));
        }
    }

    public long sumTotalMoney() {
        long sumTotalMoney = 0;
        for (TicketSale ts : ticketSales) {
            sumTotalMoney += ts.getTotalMoney();
        }
        return sumTotalMoney;
    }
}

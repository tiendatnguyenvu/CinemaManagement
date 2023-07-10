/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Java_project_SGU.DTO;

import Java_project_SGU.DAL.DAL_Implement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
import Java_project_SGU.Exception.InfoFilterImp;

/**
 *
 * @author ADMIN
 */
public class TicketSale {
    public static int autoId = 100;
    private String idTS;
    private Date saleDate; 
    private int totalMoney;
    private ShowTime showTime;
    private TicketClerk ticketClerk;
    private Customer customer;
    private ArrayList<Seat> listSeat;
    private int quantityNormal;
    private int quantityPair;
    private int quantityVip;
    private int quantityAll;

    public TicketSale() {
        this.setAutoId();
    }

    public TicketSale(String idTS, Date saleDate, int totalMoney, 
            ShowTime showTime, TicketClerk ticketClerk, Customer customer) {
        setAutoId();
        this.setIdTS(idTS);
        this.idTS = idTS;
        this.saleDate = saleDate;
        this.totalMoney = totalMoney;
        this.showTime = showTime;
        this.ticketClerk = ticketClerk;
        this.customer = customer;
    }

    public TicketSale(String idTS, Date saleDate, int totalMoney, ShowTime 
            showTime, TicketClerk ticketClerk, Customer customer, 
            int quantityNormal, int quantityPair, int quantityVip, 
            int quantityAll) {
        setAutoId();
        this.idTS = idTS;
        this.saleDate = saleDate;
        this.totalMoney = totalMoney;
        this.showTime = showTime;
        this.ticketClerk = ticketClerk;
        this.customer = customer;
        this.quantityNormal = quantityNormal;
        this.quantityPair = quantityPair;
        this.quantityVip = quantityVip;
        this.quantityAll = quantityAll;
    }    

    public TicketSale(String idTS, Date saleDate, int totalMoney, ShowTime showTime, TicketClerk ticketClerk, Customer customer, ArrayList<Seat> listSeat, int quantityNormal, int quantityPair, int quantityVip, int quantityAll) {
        this.setAutoId();
        this.idTS = idTS;
        this.saleDate = saleDate;
        this.totalMoney = totalMoney;
        this.showTime = showTime;
        this.ticketClerk = ticketClerk;
        this.customer = customer;
        this.listSeat = listSeat;
        this.quantityNormal = quantityNormal;
        this.quantityPair = quantityPair;
        this.quantityVip = quantityVip;
        this.quantityAll = quantityAll;
    }
    
    public static int getAutoId() {
        return autoId;
    }

    public static void setAutoId(int autoId) {
        TicketSale.autoId = autoId;
    }

    public String getIdTS() {
        return idTS;
    }

    public void setIdTS(String idTS) {
        if (idTS != null) { 
            this.idTS = idTS;
        } else {
            this.idTS = "TS" + autoId;
            autoId++;
        }
    }

    public Date getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }

    public int getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(int totalMoney) {
        this.totalMoney = totalMoney;
    }

    public ShowTime getShowTime() {
        return showTime;
    }

    public void setShowTime(ShowTime showTime) {
        this.showTime = showTime;
    }

    public TicketClerk getTicketClerk() {
        return ticketClerk;
    }

    public void setTicketClerk(TicketClerk ticketClerk) {
        this.ticketClerk = ticketClerk;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getQuantityNormal() {
        return quantityNormal;
    }

    public void setQuantityNormal(int quantityNormal) {
        this.quantityNormal = quantityNormal;
    }

    public int getQuantityPair() {
        return quantityPair;
    }

    public void setQuantityPair(int quantityPair) {
        this.quantityPair = quantityPair;
    }

    public int getQuantityVip() {
        return quantityVip;
    }

    public void setQuantityVip(int quantityVip) {
        this.quantityVip = quantityVip;
    }

    public int getQuantityAll() {
        return quantityAll;
    }

    public void setQuantityAll(int quantityAll) {
        this.quantityAll = quantityAll;
    }

    public ArrayList<Seat> getListSeat() {
        return listSeat;
    }

    public void setListSeat(ArrayList<Seat> listSeat) {
        this.listSeat = listSeat;
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + Objects.hashCode(this.idTS);
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
        final TicketSale other = (TicketSale) obj;
        return Objects.equals(this.idTS, other.idTS);
    }

    public void increNormal() {
        this.quantityNormal++;
    }
    
    public void decreNormal() {
        this.quantityNormal--;
    }

    public void increPair() {
        this.quantityPair++;
    }
    
    public void decrePair() {
        this.quantityPair--;
    }
    
    public void increVip() {
        this.quantityVip++;
    }
    
    public void decreVip() {
        this.quantityVip--;
    }
    
    public void calcuQuantityAll() {
        this.quantityAll = this.quantityPair + this.quantityNormal + this.quantityVip;
    }

    @Override
    public String toString() {
        return "TicketSale{" + "idTS=" + idTS + ", saleDate=" + new 
        SimpleDateFormat("HH:mm").format(saleDate) + ", totalMoney=" + totalMoney
                + ", showTime=" + showTime.getIdShowTime() + ", ticketClerk= khong co" + ", customer=" + customer.getId_customer() + 
                ", listSeat=" + listSeatTxt() + ", quantityNormal=" + quantityNormal + ","
                + " quantityPair=" + quantityPair + ", quantityVip=" + quantityVip + ","
                + " quantityAll=" + quantityAll + '}';
    }
    
    

    private String listSeatTxt() {
        String txt = "";
        for (Seat saet : listSeat) {
            txt += saet.getID_Seat().substring(0, 3);
        }
        return txt;
    }
    
    public void setAutoId() {
        DAL_Implement writeReadShowTimeSQLImp = new DAL_Implement();
        this.autoId = writeReadShowTimeSQLImp.getMaxIDTicketSale() + 1;
    }
}

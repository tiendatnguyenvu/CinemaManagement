/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Java_project_SGU.DTO;

import java.util.Objects;

/**
 *
 * @author ADMIN
 */
public class Seat {
     private String ID_Seat;
     private int row;
     private int colum;
     private TypeSeat typeSeat;
     private int unitPrice;
     
     // constructor
     public Seat(String iD_Seat, int row, int colum, 
             TypeSeat typeSeat, int unitPrice) {
          this.ID_Seat = iD_Seat;
          this.row = row;
          this.colum = colum;
          this.typeSeat = typeSeat;
          this.unitPrice = unitPrice;
     }

     public Seat() {}

     // getter and setter
     public String getID_Seat() {
          return ID_Seat;
     }

     public void setID_Seat(String iD_Seat) {
          ID_Seat = iD_Seat;
     }

     public int getRow() {
          return row;
     }

     public void setRow(int row) {
          this.row = row;
     }

     public int getColum() {
          return colum;
     }

     public void setColum(int colum) {
          this.colum = colum;
     }

     public TypeSeat getTypeSeat() {
          return typeSeat;
     }

     public void setTypeSeat(TypeSeat typeSeat) {
          this.typeSeat = typeSeat;
     }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.ID_Seat);
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
        final Seat other = (Seat) obj;
        return Objects.equals(this.ID_Seat, other.ID_Seat);
    }

    @Override
    public String toString() {
        return "Seat{" + "ID_Seat=" + ID_Seat + ", row=" + row + ", colum=" + colum + this.typeSeat.toString() + ", unitPrice=" + unitPrice + ", isChoosen=" + '}';
    }

    public void calcuPriceUnit(int origPrice ,int surchargePrice) {
        this.unitPrice =  origPrice + surchargePrice;
    }
}

package Java_project_SGU.DTO;

public class TicketPrice {
     private String nameTicketPrice;
     private int unitPrice;
     
     // constructor
     public TicketPrice(String nameTicketPrice, int unitPrice) {
          this.nameTicketPrice = nameTicketPrice;
          this.unitPrice = unitPrice;
     }

     public TicketPrice() {
          this.nameTicketPrice = "";
          this.unitPrice = 0;
     }

     // getter and setter
     public String getNameTicketPrice() {
          return nameTicketPrice;
     }

     public void setNameTicketPrice(String nameTicketPrice) {
          this.nameTicketPrice = nameTicketPrice;
     }

     public int getUnitPrice() {
          return unitPrice;
     }

     public void setUnitPrice(int unitPrice) {
          this.unitPrice = unitPrice;
     }
}

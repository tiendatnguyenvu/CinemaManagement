package Java_project_SGU.DTO;

public class TypeSeat {
     public static final String COUPLE = "COUPLE";
     public static final String ECONOMY = "ECONOMY";
     public static final String VIP = "VIP";
     private String idTypeSeat;
     private String typeSeat;
     private int surcharge;
     
     // contructor
     public TypeSeat(String idTypeSeat, String typeSeat, int surcharge) {
          this.idTypeSeat = idTypeSeat;
          this.typeSeat = typeSeat;
          this.surcharge = surcharge;
     }

     public TypeSeat() {}

     // getter and setter
     public String getTypeSeat() {
          return typeSeat;
     }

     public void setTypeSeat(String typeSeat) {
          this.typeSeat = typeSeat;
     }

     public int getSurcharge() {
          return surcharge;
     }

     public void setSurcharge(int surcharge) {
          this.surcharge = surcharge;
     }

    public String getIdTypeSeat() {
        return idTypeSeat;
    }

    public void setIdTypeSeat(String idTypeSeat) {
        this.idTypeSeat = idTypeSeat;
    }

    @Override
    public String toString() {
        return "TypeSeat{" + "idTypeSeat=" + idTypeSeat + ", typeSeat=" + typeSeat + ", surcharge=" + surcharge + '}';
    }
}

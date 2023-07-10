package Java_project_SGU.DTO;

public class MovieFormat {
     private String nameFormat;
     private int surcharge;

     // constructor
     public MovieFormat(String nameFormat, int surcharge) {
          this.nameFormat = nameFormat;
          this.surcharge = surcharge;
     }

     public MovieFormat() {
          this.nameFormat = "";
          this.surcharge = 0;
     }

     // getter and setter
     public String getNameFormat() {
          return nameFormat;
     }

     public void setNameFormat(String nameFormat) {
          this.nameFormat = nameFormat;
     }

     public int getSurcharge() {
          return surcharge;
     }

     public void setSurcharge(int surcharge) {
          this.surcharge = surcharge;
     }
     
     
}

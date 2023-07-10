
package Java_project_SGU.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import Java_project_SGU.GUI.BookTicketView;

public class BookTicketListener implements ActionListener {
    private BookTicketView booTicketView;
    private int sumMoney;
    
    public BookTicketListener (BookTicketView bookTicketView){
        this.booTicketView = bookTicketView;
        sumMoney = 0;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton srcObject = (JButton) e.getSource();
        if (srcObject.equals(this.booTicketView.getChooseSeatBtn())){
            if (this.booTicketView.getState() == BookTicketView.CHOOSE_SEAT) {
                this.booTicketView.showCorresRoomDialog();
            } else if (this.booTicketView.getState() == BookTicketView.PROCEED_PAYMENT) {
                this.booTicketView.finishPayment();
            }
        }
        
        if (srcObject.equals(this.booTicketView.getUpPairBtn())) {
            this.booTicketView.increPairTicket(); 
        } else if (srcObject.equals(this.booTicketView.getUpSingleBtn())) {
            this.booTicketView.increSingleTicket();
        }  else if (srcObject.equals(this.booTicketView.getUpVipBtn())) {
            this.booTicketView.increVipTicket();
        } else if (srcObject.equals(this.booTicketView.getDownPairBtn())) {
            this.booTicketView.decrePairTicket(); 
        } else if (srcObject.equals(this.booTicketView.getDownVipBtn())) {
            this.booTicketView.decreVipTicket(); 
        } else if (srcObject.equals(this.booTicketView.getDownSingleBtn())) {
            this.booTicketView.decrNormalTicket();
        }
    }
}

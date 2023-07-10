/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Java_project_SGU.Controller;

import Java_project_SGU.GUI.UpdateShowtimeDialog;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 *
 * @author ADMIN
 */
public class FocusListenerUpdateShowtimeDialog implements FocusListener{
    private UpdateShowtimeDialog updateShowtimeDialog;
    public FocusListenerUpdateShowtimeDialog(UpdateShowtimeDialog updateShowtimeDialog) {
        this.updateShowtimeDialog = updateShowtimeDialog;
    }
    
//    @Override
//    public void caretUpdate(CaretEvent e) {Object src =  e.getSource();
//       
//    }
    @Override
    public void focusGained(FocusEvent e) {
        
    }

    @Override
    public void focusLost(FocusEvent e) {
        Object src = e.getSource();
        if (src.equals(this.updateShowtimeDialog.getStartDateTxt())) {
            this.updateShowtimeDialog.setStartDateLB();
        } else if (src.equals(this.updateShowtimeDialog.getStartHourTxt())) {
            this.updateShowtimeDialog.setHourDateLB();
        } else if (src.equals(this.updateShowtimeDialog.getTicketPriceTxt())) {
            this.updateShowtimeDialog.setTicketPriceLB();
        }
    }
}

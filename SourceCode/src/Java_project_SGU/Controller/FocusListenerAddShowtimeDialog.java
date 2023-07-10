/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Java_project_SGU.Controller;

import Java_project_SGU.GUI.AddShowtimeDialog;
import Java_project_SGU.GUI.UpdateShowtimeDialog;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

/**
 *
 * @author ADMIN
 */
public class FocusListenerAddShowtimeDialog  implements  FocusListener{
    private AddShowtimeDialog addShowtimeDialog;
    private UpdateShowtimeDialog updateShowtimeDialog;

    public FocusListenerAddShowtimeDialog(AddShowtimeDialog addShowtimeDialog) {
        this.addShowtimeDialog = addShowtimeDialog;
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
         if (src.equals(this.addShowtimeDialog.getStartDateTxt())) {
            this.addShowtimeDialog.setStartDateLB();
        } else if (src.equals(this.addShowtimeDialog.getStartHourTxt())) {
            this.addShowtimeDialog.setHourDateLB();
        } else if (src.equals(this.addShowtimeDialog.getTicketPriceTxt())) {
            this.addShowtimeDialog.setTicketPriceLB();
        }
    }
}



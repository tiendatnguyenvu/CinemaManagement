/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Java_project_SGU.Controller;

import Java_project_SGU.GUI.Room2;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author ADMIN
 */
public class Seat2Listener implements ActionListener{
    private Room2 room2;

    public Seat2Listener(Room2 room2) {
        this.room2 = room2;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
//        String text = e.getActionCommand();
        JButton src = (JButton) e.getSource();
        this.room2.chooseButton(src);
        if (src.equals(this.room2.getRedoBtn())){
            room2.removeLastChoosenBtn();
        }
        else if (src.getText().equals("Hoàn Tất")){
                this.room2.proceedPayment();
                this.room2.dispose();   
        }
        else if (src.getText().equals("Quay lại")){
            this.room2.dispose();
        }
    }
}

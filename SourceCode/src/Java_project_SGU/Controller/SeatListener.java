
package Java_project_SGU.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import Java_project_SGU.GUI.Room1View;

public class SeatListener implements ActionListener{

    private Room1View room1View;

    public SeatListener(Room1View roomViewFrm) {
        this.room1View = roomViewFrm;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String text = e.getActionCommand();
        JButton src = (JButton) e.getSource();
        this.room1View.chooseButton(src);
        if (text.equals("Hoàn tác")){
            room1View.removeLastChoosenBtn();
        }
        if (text.equals("Hoàn Tất")){
            this.room1View.proceedPayment();
            this.room1View.dispose();
        }
        if (text.equals("Quay lại")){
            this.room1View.dispose();
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Java_project_SGU.Controller;

import Java_project_SGU.GUI.LoginFrm;
import Java_project_SGU.GUI.ManageEmployeeFrm;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

/**
 *
 * @author ADMIN
 */
public class MouseActionlistenerAdminPage implements MouseListener {

    private ManageEmployeeFrm manageEmployeeFrm;

    public MouseActionlistenerAdminPage(ManageEmployeeFrm manageEmployeeFrm) {
        this.manageEmployeeFrm = manageEmployeeFrm;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Object src = e.getSource();
        if (src.equals(manageEmployeeFrm.getCustomerLb())) {
            manageEmployeeFrm.showCustomerPage();
        } else if (src.equals(manageEmployeeFrm.getDataLb())) {
            manageEmployeeFrm.showDataPage();
        } else if (src.equals(manageEmployeeFrm.getRoomLb())) {
            manageEmployeeFrm.showRoomPage();
        } else if (src.equals(manageEmployeeFrm.getFoodLB())) {
            manageEmployeeFrm.showFoodPage();
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        Object src = e.getSource();
        if (src.equals(manageEmployeeFrm.getCustomerLb()))  {
            manageEmployeeFrm.changeCusColorPN();
        } else if (src.equals(manageEmployeeFrm.getDataLb()))  {
            manageEmployeeFrm.changeDataColorPN();
        } else if (src.equals(manageEmployeeFrm.getRoomLb()))  {
            manageEmployeeFrm.changeRoomColorPN();
        } else if (src.equals(manageEmployeeFrm.getFoodLB()))  {
            manageEmployeeFrm.changeFoodColorPN();
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        Object src = e.getSource();
        if (src.equals(manageEmployeeFrm.getCustomerLb()))  {
            manageEmployeeFrm.setCusBackgroundDefault();
        } else if (src.equals(manageEmployeeFrm.getDataLb()))  {
            manageEmployeeFrm.setDataBackgroundDefault();
        } else if (src.equals(manageEmployeeFrm.getRoomLb()))  {
            manageEmployeeFrm.setRoomBackgroundDefault();
        } else if (src.equals(manageEmployeeFrm.getFoodLB()))  {
            manageEmployeeFrm.setFoodBackgroundDefault();
        }
    }

    @Override
    public void mousePressed(MouseEvent e
    ) {

    }

    @Override
    public void mouseReleased(MouseEvent e
    ) {
    }
}

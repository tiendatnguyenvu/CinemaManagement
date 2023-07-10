/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Java_project_SGU.Controller;

import Java_project_SGU.GUI.ChooseMovieDialog;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author ADMIN
 */
public class MouseActionListenerChooseMovie implements MouseListener {
    private ChooseMovieDialog chooseMovieDialog;

    public MouseActionListenerChooseMovie(ChooseMovieDialog chooseMovieDialog) {
        this.chooseMovieDialog = chooseMovieDialog;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Object src = e.getSource();
        this.chooseMovieDialog.showCardRoomLOut(src);
        this.chooseMovieDialog.displayChooseSeatDialog(src);
        
        if (src.equals(this.chooseMovieDialog.getCalandarTxt())) {
            this.chooseMovieDialog.getCalandarTxt().setText("");
            this.chooseMovieDialog.getCalandarTxt().setForeground(Color.BLACK);
            this.chooseMovieDialog.showPanelAccorCalendarLB();
            this.chooseMovieDialog.showCalendarLB();
        } 
        else if (src.equals(this.chooseMovieDialog.getSearchCalendarLB())) {
            int rsSearchSuccess = chooseMovieDialog.FilterCalendarShowTime();
            
            if (rsSearchSuccess == 1) {
                this.chooseMovieDialog.filterHoursToPN1();
            } else if (rsSearchSuccess == 2) {
                this.chooseMovieDialog.filterHoursToPN2();
            } else if (rsSearchSuccess == 3) {
                this.chooseMovieDialog.filterHoursToPN1();
                this.chooseMovieDialog.filterHoursToPN2();
            }
            this.chooseMovieDialog.addActionToListLB();
        } 
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
       
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        Object src = e.getSource();
        this.chooseMovieDialog.changeColorHourLB(src);
        
        if (src.equals(this.chooseMovieDialog.getSearchCalendarLB())) {
           this.chooseMovieDialog.getSearchCalendarLB().setBackground(new java.awt.Color(255,153,0));
           this.chooseMovieDialog.getSearchCalendarLB().setForeground(Color.WHITE);
        } 
    }

    @Override
    public void mouseExited(MouseEvent e) {
        Object src = e.getSource();
        this.chooseMovieDialog.changeOrigColorHourLB(src);
        
        if (src.equals(this.chooseMovieDialog.getSearchCalendarLB())) {
           this.chooseMovieDialog.getSearchCalendarLB().setForeground(new java.awt.Color(153, 0, 153));
           this.chooseMovieDialog.getSearchCalendarLB().setBackground(Color.WHITE);
        }
    }
}

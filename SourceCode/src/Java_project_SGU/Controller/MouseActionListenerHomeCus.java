/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Java_project_SGU.Controller;

import Java_project_SGU.GUI.HomePageCusFrm;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;


/**
 *
 * @author ADMIN
 */
public class MouseActionListenerHomeCus implements MouseListener {
    private HomePageCusFrm homePageCusFrm;

    public MouseActionListenerHomeCus(HomePageCusFrm homePageCusFrm) {
        this.homePageCusFrm = homePageCusFrm;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Object src = e.getSource();
        if (src.equals(this.homePageCusFrm.getMenuIcon())) {
            if (this.homePageCusFrm.isIsOpenMenu()) {
                this.homePageCusFrm.closeMenuBlock();
            } else {
                this.homePageCusFrm.showMenuBlock();
            }
        } else if (src.equals(this.homePageCusFrm.getMovieShowingEvent())) {
            this.homePageCusFrm.showCardMovie();
        } else if (src.equals(this.homePageCusFrm.getFoodShowingEvent())) {
            this.homePageCusFrm.showCardFood();
        } else if (src.equals(this.homePageCusFrm.getLogoutMenu1())
                || src.equals(this.homePageCusFrm.getLogoutMenu2())) {
            this.homePageCusFrm.logout();
        } else if (src.equals(this.homePageCusFrm.getSearchNameMVBtn())) {
            this.homePageCusFrm.renderMVsByNameSearch();
        }
        
        for (int i = 0; i < this.homePageCusFrm.getListPanelMovie().size(); i++) {
            if (src.equals(this.homePageCusFrm.getListPanelMovie().get(i))) {
               this.homePageCusFrm.showDialogChooseMovie(i);
            }
        }
        for (int i = 0; i < this.homePageCusFrm.getListDeltaiMVLB().size(); i++) {
            if (src.equals(this.homePageCusFrm.getListDeltaiMVLB().get(i))) {
               this.homePageCusFrm.showDialogDeltailMovie(i);
            }
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
        if (src.equals(this.homePageCusFrm.getMovieShowingEvent())) {
            this.homePageCusFrm.changeColorMovieShowing();
        } else if (src.equals(this.homePageCusFrm.getFoodShowingEvent())) {
            this.homePageCusFrm.changeColorFoodShowing();
        } else if (src.equals(this.homePageCusFrm.getInfoCusIMenu1())
                || src.equals(this.homePageCusFrm.getInfoCusIMenu2())) {
            this.homePageCusFrm.changeBackgroundItem1MN();
        } else if (src.equals(this.homePageCusFrm.getLogoutMenu1())
                || src.equals(this.homePageCusFrm.getLogoutMenu2())) {
            this.homePageCusFrm.changeBackgroundItem2MN();
        }
        for (int i = 0; i < this.homePageCusFrm.getListPanelMovie().size(); i++) {
            if (src.equals(this.homePageCusFrm.getListPanelMovie().get(i))) {
               this.homePageCusFrm.changeColorPanel(i);
            }
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        Object src = e.getSource();
        if (src.equals(this.homePageCusFrm.getMovieShowingEvent())) {
            this.homePageCusFrm.changeOrigColorMovieShowing();
        } else if (src.equals(this.homePageCusFrm.getFoodShowingEvent())) {
            this.homePageCusFrm.changeOrigColorFoodShowing();
        } else if (src.equals(this.homePageCusFrm.getInfoCusIMenu1())
                || src.equals(this.homePageCusFrm.getInfoCusIMenu2())) {
            this.homePageCusFrm.changeOrigBackgroundItem1MN();
        } else if (src.equals(this.homePageCusFrm.getLogoutMenu1())
                || src.equals(this.homePageCusFrm.getLogoutMenu2())) {
            this.homePageCusFrm.changeOrigBackgroundItem2MN();
        }
        for (int i = 0; i < this.homePageCusFrm.getListPanelMovie().size(); i++) {
            if (src.equals(this.homePageCusFrm.getListPanelMovie().get(i))) {
               this.homePageCusFrm.changeColorOrigPanel(i);
            }
        }
    }
}

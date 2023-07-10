/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Java_project_SGU.BLL;

/**
 *
 * @author ADMIN
 */

import Java_project_SGU.DAL.DAL_Implement;
import Java_project_SGU.DTO.ShowTime;
import java.util.ArrayList;

class DaoShowTime implements DaoInterface<ShowTime>{
    private DAL_Implement dal;
    private ArrayList<ShowTime> listShowTime;

    public DaoShowTime() {
        dal = new DAL_Implement();
        this.listShowTime = (ArrayList<ShowTime>) dal.readShowTimesFromSQL();
    }
    
    @Override
    public ArrayList<ShowTime> getAll() {
        this.listShowTime = (ArrayList<ShowTime>) dal.readShowTimesFromSQL();
        return this.listShowTime;
    }

    @Override
    public ShowTime getById(ShowTime o) {
        for (ShowTime ShowTime : this.listShowTime) {
            if (ShowTime.equals(o)) return ShowTime;
        }
        return null;
    }

    @Override
    public int insert(ShowTime o) {
        if (getById(o) == null) {
            return 0;
        }
        this.listShowTime.add(o);
        dal.insertShowTimeToSQL(o);
        return 1;
    }

    @Override
    public int insertAll(ArrayList<ShowTime> o) {
        for (ShowTime ShowTime : o) {
            if (insert(ShowTime) == 0) return 0;
        }
        return 1;
    }

    @Override
    public int delete(ShowTime o) {
        if (getById(o) == null) {
            return 0;
        }
        this.listShowTime.remove(o);
        return 1;
    }

    @Override
    public int deleteAll(ArrayList<ShowTime> o) {
        for (ShowTime ShowTime : o) {
            if (delete(ShowTime) == 0) return 0;
        }
        return 1;
    }

    @Override
    public int update(ShowTime t) {
        if (getById(t) == null) {
            return 0;
        }
        this.listShowTime.remove(t);
        this.listShowTime.add(t);
        dal.updateShowTime(t);
        return 1;
    }
    
}

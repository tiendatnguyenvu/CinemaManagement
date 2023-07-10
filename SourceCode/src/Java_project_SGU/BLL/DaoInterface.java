/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Java_project_SGU.BLL;

import Java_project_SGU.DTO.Movie;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public interface DaoInterface<E> {
    ArrayList<E> getAll();
    E getById(E o);
    int insert(E o);
    int insertAll(ArrayList<E> o);
    int delete(E o);
    int deleteAll(ArrayList<E> o);
    int update(E t);
}

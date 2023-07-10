/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Java_project_SGU.DAL;

import Java_project_SGU.DTO.CleaningStaff;
import Java_project_SGU.DTO.CusSupStaff;
import Java_project_SGU.DTO.Customer;
import Java_project_SGU.DTO.FoodDrinkSaler;
import Java_project_SGU.DTO.ManagerRoom;
import Java_project_SGU.DTO.ManagerShowTimeMovie;
import Java_project_SGU.DTO.ManagerStaffClient;
import Java_project_SGU.DTO.Movie;
import Java_project_SGU.DTO.Room;
import Java_project_SGU.DTO.Seat;
import Java_project_SGU.DTO.ShowTime;
import Java_project_SGU.DTO.Staff;
import Java_project_SGU.DTO.TicketClerk;
import Java_project_SGU.DTO.TicketInspector;
import Java_project_SGU.DTO.TicketSale;
import Java_project_SGU.DTO.TypeSeat;
import Java_project_SGU.Exception.InvalidAccountCusException;
import Java_project_SGU.Exception.InvalidBirthdayException;
import Java_project_SGU.Exception.InvalidEmailException;
import Java_project_SGU.Exception.InvalidIdPersonException;
import Java_project_SGU.Exception.InvalidMoneyException;
import Java_project_SGU.Exception.InvalidNameException;
import Java_project_SGU.Exception.InvalidPasswordCusException;
import Java_project_SGU.Exception.InvalidPhoneException;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public interface InterfaceDAL {
    public static final String USER = "duy";
    public static final String PASSWORD = "Asdfgh1052003.";
    public static final String DB_NAME = "QLRP";
    public static final String SERVER = "LAPTOP-UGUU7LBC\\MAVAO";
    public static final int PORT = 1433;
    
    public SQLServerDataSource configDataSource();
    public List<Customer> readCustomersFromDataSource();
    public ArrayList<Room> getRoomsFromSql();
    public List<TicketSale> readTicketSaleFromDataSourse();
    // load thông tin hóa đơn lên bảng thống kê trên trang admin
    public List<TicketSale> infoTicketSaleForTable() throws InvalidNameException, InvalidPhoneException;
    public String findNameCustByID(String ID_Customer) throws SQLServerException, SQLException;
    // tìm số điện thoại khách hàng có id tương ứng
    public String findPhoneNumCusByID(String ID_Customer) throws SQLServerException, SQLException;
    // lấy danh sách ghế đã đặt
    public List<Seat> findSeatByID_TicketSale (String ID_TicketSale);
    public int insertData(Customer customer);
    public int upDateCustomer(Customer customer);
    public int activeSavePWSQL(int isTrue, Customer customer);
    public boolean insertShowTimeToSQL(ShowTime showTime);
    public ArrayList<ShowTime> readShowTimesFromSQL();
    public ShowTime readBookedShowTimesFromSQL(ShowTime showTime);
    public ArrayList<Seat> readSeatCorresSTFromSQL(ShowTime showTime);
    public void setIsDeleteST(String idShowTime);
    public void updateShowTime(ShowTime showTime);
    public ArrayList<ShowTime> readListST_CorrespondingWithMovie(String idMovieBooking);
    public TicketSale getBookingTicketSale(ShowTime showTime, Customer customer) throws ParseException;
    // lấy id TicketSale co gia tri lon nhat
    public int getMaxIDTicketSale();
    // lấy danh sách những ID_TicketSale với ShowTime tương ứng
    public ArrayList<String> getIDTicketSale(ShowTime showTime);
    // lấy giá và loại ghế theo mã ghế 
    public List<String> getInfoOfSeat(String ID_Seat);
    // ghi dữ liệu vào bảng TicketSale
    public void writeTicketSale(String ID_TicketSale, java.util.Date present, int total, ShowTime showTime, String ID_Staff);
    public void writeTicketSale2(String ID_TicketSale, java.util.Date present, int total, ShowTime showTime, String ID_Customer);
    // ghi những ghế được chọn vào bảng detailTicketSale
    public void writeDetailTicketSale(String ID_TicketSale, List<String> listSeatHasJustBeenSelected, ShowTime showTime);
    public int insertData(Staff staff);
    public int deleteStaff(String ID_StaffDelete);
    public int upDateStaff(Staff staff);
    // cập nhật số ngày làm cho nhân viên 
    public int updateNumOfDayWorked(String ID_Staff, int numOfDayWorked);
    // cap nhat muc luong cho nhan vien
    public int updateSalary(String ID_Staff, int newSalary); 
    public List<Movie> readMovieFromDS();
    public int insertMovieDataToSql(Movie movie);
    public void updateMovie(Movie movieUpdate);
}

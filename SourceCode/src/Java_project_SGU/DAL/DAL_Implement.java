/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Java_project_SGU.DAL;

import Java_project_SGU.DTO.CleaningStaff;
import Java_project_SGU.DTO.CusSupStaff;
import Java_project_SGU.Exception.InvalidAccountCusException;
import Java_project_SGU.Exception.InvalidBirthdayException;
import Java_project_SGU.Exception.InvalidEmailException;
import Java_project_SGU.Exception.InvalidIdPersonException;
import Java_project_SGU.Exception.InvalidNameException;
import Java_project_SGU.Exception.InvalidPasswordCusException;
import Java_project_SGU.Exception.InvalidPhoneException;
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
import Java_project_SGU.Exception.InvalidMoneyException;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author ADMIN
 */
public class DAL_Implement implements InterfaceDAL{

    @Override
    public SQLServerDataSource configDataSource() {
        SQLServerDataSource dataSource = new SQLServerDataSource();
        dataSource.setEncrypt(false); // (1)
        dataSource.setIntegratedSecurity(false); // (2)
        dataSource.setTrustServerCertificate(false);
        dataSource.setUser(InterfaceDAL.USER);
        dataSource.setPassword(InterfaceDAL.PASSWORD);
        dataSource.setDatabaseName(InterfaceDAL.DB_NAME);
        dataSource.setServerName(InterfaceDAL.SERVER);
        dataSource.setPortNumber(InterfaceDAL.PORT);
        return dataSource;
    }
    
    

    @Override
    public List<Customer> readCustomersFromDataSource() {
        List<Customer> customers = new ArrayList<>();
        SQLServerDataSource dataSource = configDataSource();
        try(var conn = dataSource.getConnection()) {
            String SqlQuery = "SELECT * FROM dbo.Customer WHERE isDelete = ?";
            var prepareStatement = conn.prepareStatement(SqlQuery);           
            prepareStatement.setString(1, "False");
            ResultSet resultSet =  prepareStatement.executeQuery();
            while (resultSet.next()) {
                String idCustomer = resultSet.getString(1);
                String fullName = resultSet.getString(2);
                String passWord = resultSet.getString(3);
                String phoneNumber = resultSet.getString(4);
                String email = resultSet.getString(5);
                String birthDate = "";
                try {
                    birthDate = changeDate(resultSet.getString(6));
                } catch (ParseException ex) {
                    ex.printStackTrace();
                }
                boolean sex = false;
                if (resultSet.getString(7).equals("1")) {
                    sex = true;
                } else { sex = false; }
                boolean isSavePw = false;
                if (resultSet.getString(8).equals("1")) {
                    isSavePw = true;
                } else { isSavePw = false; }
                String idPerson = resultSet.getString(9);
                String address = resultSet.getString(10);
                String account = resultSet.getString(11);
                SimpleDateFormat startDateFormart = new SimpleDateFormat("yyyy-MM-dd hh:ss:mm");
                String startDate = "";
                try {
                    startDate = changeDate_2(resultSet.getString(12));
                } catch (ParseException ex) {
                    ex.printStackTrace();
                }
                Customer customer = new Customer(idCustomer, account, 
                        passWord, isSavePw, fullName, email, phoneNumber,
                        address, birthDate, sex, idPerson);
                customer.setStartDate(startDate);
                customers.add(customer);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (InvalidNameException ex) {
            ex.printStackTrace();
        } catch (InvalidEmailException ex) {
            ex.printStackTrace();
        } catch (InvalidPhoneException ex) {
            ex.printStackTrace();
        } catch (InvalidBirthdayException ex) {
            ex.printStackTrace();
        } catch (InvalidIdPersonException ex) {
            ex.printStackTrace();
        } catch (InvalidAccountCusException ex) {
            ex.printStackTrace();
        } catch (InvalidPasswordCusException ex) {
            ex.printStackTrace();
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return customers;
    }   
    
    private static String changeDate (String date) throws ParseException {
        SimpleDateFormat fomartDateCustomer = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat fomartDateSql = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date dateSql = fomartDateSql.parse(date);
        String dateCustomer = fomartDateCustomer.format(dateSql);
        return dateCustomer;
    }

    private String changeDate_2(String date) throws ParseException {
        SimpleDateFormat fomartDateCustomer = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
        SimpleDateFormat fomartDateSql = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        java.util.Date dateSql = fomartDateSql.parse(date);
        String dateCustomer = fomartDateCustomer.format(dateSql);
        return dateCustomer;
    }

   @Override
    public ArrayList<Room> getRoomsFromSql() {
        ArrayList<Room> rooms = new ArrayList<>();
        SQLServerDataSource ds = configDataSource();
        try(var connect = ds.getConnection()) {
            String getRoomQuery = "SELECT * FROM Room";
            var prepareStm = connect.prepareStatement(getRoomQuery);
            ResultSet resultSet =  prepareStm.executeQuery();
            while (resultSet.next()) {
                String idRooom = resultSet.getString(1);
                int numRow = resultSet.getInt(2);
                int numCol = resultSet.getInt(3);
                Room room = new Room(idRooom, numRow, numCol);
                rooms.add(room);
            }
            return rooms;
        } catch (SQLServerException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return rooms;
    }
    
    public List<Staff> readStaffFromDataSource() {
        List<Staff> staffs = new ArrayList<>();
        SQLServerDataSource dataSource = configDataSource();
        try (var conn = dataSource.getConnection()) {
            String SqlQuery = "select * from dbo.Staff where isDelete = ?";
            var prepareStatement = conn.prepareStatement(SqlQuery);
            prepareStatement.setString(1, "0");
            ResultSet resultSet = prepareStatement.executeQuery();
            while (resultSet.next()) {
                String ID_Staff = resultSet.getString(1);
                String fullName = resultSet.getString(2);
                String password = resultSet.getString(3);
                String ID_Person = resultSet.getString(4);
                String phoneNumber = resultSet.getString(5);
                String email = resultSet.getString(6);
                String address = resultSet.getString(7);
                String startDate = changeDate_Staff(resultSet.getString(8));
                boolean sex = false;
                if (resultSet.getString(9).equals("1")){
                    sex = true;
                } else {
                    sex = false;
                }
                boolean isWorking = false;
                if (resultSet.getString(10).equals("1")){
                    isWorking = true;
                } else {
                    isWorking = false;
                }
                String nameTask = resultSet.getString(11);
                boolean isDelete = false;
                if (resultSet.getString(12).equals("1")){
                    isDelete = true;
                } else {
                    isDelete = false;
                }
                String birtDate = changeDate(resultSet.getString(13));
                int numOfDayWorked = Integer.parseInt(resultSet.getString(14));
                int salaryDay = Integer.parseInt(resultSet.getString(15));
                String account = resultSet.getString(16);
                if (nameTask.equals("Nhân viên bán vé")){
                    Staff ticketClerk = new TicketClerk(ID_Staff, fullName, password, ID_Person, phoneNumber, email, 
                            address, startDate, sex, isWorking, nameTask, isDelete, birtDate, 
                            numOfDayWorked, salaryDay, account);
                    staffs.add(ticketClerk);
                } else if(nameTask.equals("Nhân viên bán thức ăn")) {
                    Staff foodDrinkSaller = new FoodDrinkSaler(ID_Staff, fullName, password, ID_Person, phoneNumber, 
                            email, address, startDate, sex, isWorking, nameTask, isDelete, birtDate, 
                            numOfDayWorked, salaryDay, account);
                    staffs.add(foodDrinkSaller);
                } else if(nameTask.equals("Nhân viên soát vé")) {
                    Staff ticketInspector = new TicketInspector(ID_Staff, fullName, password, ID_Person, phoneNumber, 
                            email, address, startDate, sex, isWorking, nameTask, isDelete, birtDate, 
                            numOfDayWorked, salaryDay, account);
                    staffs.add(ticketInspector);
                } else if(nameTask.equals("Nhân viên vệ sinh")) {
                    Staff cleaningStaff = new CleaningStaff(ID_Staff, fullName, password, ID_Person, phoneNumber, 
                            email, address, startDate, sex, isWorking, nameTask, isDelete, birtDate, 
                            numOfDayWorked, salaryDay, account);
                    staffs.add(cleaningStaff);
                } else if(nameTask.equals("Nhân viên hỗ trợ khách hàng")) {
                    Staff cusSupStaff = new CusSupStaff(ID_Staff, fullName, password, ID_Person, phoneNumber, 
                            email, address, startDate, sex, isWorking, nameTask, isDelete, birtDate, 
                            numOfDayWorked, salaryDay, account);
                    staffs.add(cusSupStaff);
                } else if(nameTask.equals("Quản lí phòng rạp")) {
                    Staff managerRoom = new ManagerRoom(ID_Staff, fullName, password, ID_Person, phoneNumber, 
                            email, address, startDate, sex, isWorking, nameTask, isDelete, birtDate, 
                            numOfDayWorked, salaryDay, account);
                    staffs.add(managerRoom);
                } else if(nameTask.equals("Quản lí suất chiếu và phim")) {
                    Staff managerShowTimeMovie = new ManagerShowTimeMovie(ID_Staff, fullName, password, ID_Person, 
                            phoneNumber, email, address, startDate, sex, isWorking, nameTask, isDelete, birtDate, 
                            numOfDayWorked, salaryDay, account);
                    staffs.add(managerShowTimeMovie);
                } else if(nameTask.equals("Quản lí nhân viên và khách hàng")) {
                    Staff managerStaffClient = new ManagerStaffClient(ID_Staff, fullName, password, ID_Person, 
                            phoneNumber, email, address, startDate, sex, isWorking, nameTask, isDelete, 
                            birtDate, numOfDayWorked, salaryDay, account);
                    staffs.add(managerStaffClient);
                }
            }
        } catch (SQLServerException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (InvalidNameException ex) {
            ex.printStackTrace();
        } catch (InvalidEmailException ex) {
            ex.printStackTrace();
        } catch (InvalidPhoneException ex) {
            ex.printStackTrace();
        } catch (InvalidBirthdayException ex) {
            ex.printStackTrace();
        } catch (ParseException ex) {
            ex.printStackTrace();
        } catch (InvalidIdPersonException ex) {
            ex.printStackTrace();
        } catch (InvalidPasswordCusException ex) {
            ex.printStackTrace();
        } catch (InvalidMoneyException ex) {
            ex.printStackTrace();
        } catch (InvalidAccountCusException ex) {
            ex.printStackTrace();
        }
        return staffs;
    }

    private String changeDate_Staff(String date) throws ParseException {
        SimpleDateFormat formatDateStaff = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formatDateSql = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date dateSql = formatDateSql.parse(date);
        String dateStaff = formatDateStaff.format(dateSql);
        return dateStaff;
    }
    
    @Override
    public List<TicketSale> readTicketSaleFromDataSourse() {
        List<TicketSale> ticketSales = new ArrayList<>();

        SQLServerDataSource dataSource = configDataSource();
        try (var conn = dataSource.getConnection()) {
            String SqlQuery = "select * from dbo.TicketSale";
            var prepareStatement = conn.prepareStatement(SqlQuery);
            var resultSet = prepareStatement.executeQuery();
            while (resultSet.next()) {
                String ID_TicketSale = resultSet.getString(1);
                java.util.Date saleDate = changeDateOfTicketSale(resultSet.getString(2));
                int total = resultSet.getInt(3);
                
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ParseException ex) {
            ex.printStackTrace();
        }

        return ticketSales;
    }
    
    // load thông tin hóa đơn lên bảng thống kê trên trang admin
    public ArrayList<TicketSale> infoTicketSaleForTable() throws InvalidNameException, InvalidPhoneException {
        ArrayList<TicketSale> ticketSales = new ArrayList<>();
        SQLServerDataSource dataSource = configDataSource();
        try (var conn = dataSource.getConnection()) {
            String SqlQuery = "select ID_TicketSale, SaleDate, Total, ID_Customer from dbo.TicketSale";
            var prepareStatement = conn.prepareStatement(SqlQuery);
            var resultSet = prepareStatement.executeQuery();
            while (resultSet.next()) {
                String ID_TicketSale = resultSet.getString(1);
                java.util.Date saleDate = resultSet.getDate(2);
                int total = resultSet.getInt(3);
                String fullName = findNameCustByID(resultSet.getString(4));
                String phoneNumber = findPhoneNumCusByID(resultSet.getString(4));
                if(phoneNumber == null){
                    phoneNumber = "0900000000";
                }
                
                Customer customer = new Customer();
                customer.setFullName(fullName);
                customer.setPhoneNumber(phoneNumber);
                
                TicketSale ticketSale = new TicketSale();
                ticketSale.setIdTS(ID_TicketSale);
                ticketSale.setCustomer(customer);
                ticketSale.setTotalMoney(total);
                ticketSale.setSaleDate(saleDate);
                ticketSale.setListSeat((ArrayList<Seat>) findSeatByID_TicketSale(ID_TicketSale));
                
                ticketSales.add(ticketSale);
                }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return ticketSales;
    }
    
    // thống kê doanh thu của những bộ phim 
    public void revenueOfMovie() {
        
    }

    // tìm tên khách hàng có id tương ứng
    public String findNameCustByID(String ID_Customer) throws SQLServerException, SQLException {
        String fullName = "";
        SQLServerDataSource dataSource = configDataSource();
        try (var conn = dataSource.getConnection()) {
            String SqlQuery = "select FullName from dbo.Customer where ID_Customer = ?";
            var prepareStatement = conn.prepareStatement(SqlQuery);
            prepareStatement.setString(1, ID_Customer);
            var resultSet = prepareStatement.executeQuery();
            while (resultSet.next()) {
                fullName = resultSet.getString(1);
            }
        }
        return fullName;
    }
    
    // tìm số điện thoại khách hàng có id tương ứng
    public String findPhoneNumCusByID(String ID_Customer) throws SQLServerException, SQLException {
        String phoneNumber = "";
        SQLServerDataSource dataSource = configDataSource();
        try (var conn = dataSource.getConnection()) {
            String SqlQuery = "select PhoneNumber from dbo.Customer where ID_Customer = ?";
            var prepareStatement = conn.prepareStatement(SqlQuery);
            prepareStatement.setString(1, ID_Customer);
            var resultSet = prepareStatement.executeQuery();
            while (resultSet.next()) {
                phoneNumber = resultSet.getString(1);
            }
        }
        return phoneNumber;
    }
    
    // lấy danh sách ghế đã đặt
    public List<Seat> findSeatByID_TicketSale (String ID_TicketSale) {
        List<Seat> seats = new ArrayList<>();
        SQLServerDataSource dataSource = configDataSource();
        try (var conn = dataSource.getConnection()) {
            String SqlQuery = "select ID_Seat from TicketSale join DetailTicketSale "
                    + "on TicketSale.ID_TicketSale = DetailTicketSale.ID_TicketSale\n" +
                    "where TicketSale.ID_TicketSale = ?";
            var prepareStatement = conn.prepareStatement(SqlQuery);
            prepareStatement.setString(1, ID_TicketSale);
            var resultSet = prepareStatement.executeQuery();
            while (resultSet.next()) {
                String ID_Seat = resultSet.getString(1);
                Seat seat = new Seat();
                seat.setID_Seat(ID_Seat);
                seats.add(seat);
            }
        } catch (SQLServerException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return seats;
    }

    // đổi kiểu date trong sql sang date dạng string
    private java.util.Date changeDateOfTicketSale(String date) throws ParseException {
        SimpleDateFormat dateFormatOfTicketSale = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        java.util.Date dateOfTicketSale = dateFormatOfTicketSale.parse(date);
        return dateOfTicketSale;
    }
    
    public int insertData(Customer customer) {
        SQLServerDataSource ds = configDataSource();
        try (var conn = ds.getConnection()) {
            var sql = "INSERT INTO dbo.Customer(ID_Customer, Name, Password,"
                    + " PhoneNumber, Email, DayOfBirth, Sex, isSavepw, ID_Person,"
                    + " Address, Account, StartDate, isDelete) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            var prepareStm = conn.prepareStatement(sql);
            prepareStm.setString(1, customer.getId_customer());
            prepareStm.setString(2, customer.getFullName());
            prepareStm.setString(3, customer.getPassword());
            prepareStm.setString(4, customer.getPhoneNumber());
            prepareStm.setString(5, customer.getEmail());
            SimpleDateFormat fomartDateSql = new SimpleDateFormat("yyyy-MM-dd");
            prepareStm.setString(6, fomartDateSql.format(customer.getBirthDay()));
            if (customer.getSex()) {
                prepareStm.setString(7, "True");
            } else {
                prepareStm.setString(7, "False");
            }
            if (customer.getIsSavePW()) {
                prepareStm.setString(8, "True");
            } else {
                prepareStm.setString(8, "False");
            }
            prepareStm.setString(9, customer.getId_person());
            prepareStm.setString(10, customer.getAddress());
            prepareStm.setString(11, customer.getAccount());
            SimpleDateFormat fomartSartDateSql = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            prepareStm.setString(12, fomartSartDateSql.format(customer.getStartDate()));
            prepareStm.setString(13, "False");
            return prepareStm.executeUpdate();
        } catch (SQLServerException throwables) {
            throwables.printStackTrace();
            return -1;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return -1;
        }
    }
    
    public int deleteCus(String id_cusDelete) {
        SQLServerDataSource ds = configDataSource();
        try (Connection connect = ds.getConnection()){
            String deleteCusQuery = "UPDATE dbo.Customer SET isDelete = 1 WHERE ID_Customer = ?";
            var prepareStm = connect.prepareStatement(deleteCusQuery);
            prepareStm.setString(1, id_cusDelete);
            return prepareStm.executeUpdate();
        } catch (SQLServerException ex) {
            ex.printStackTrace();
            return -1;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return -1;
        }
    }

    public int upDateCustomer(Customer customer) {
        SQLServerDataSource ds = configDataSource();
        try (Connection connect = ds.getConnection()) {
            String updateCusQuery = "UPDATE dbo.Customer SET Name = ?,"
                    + " PhoneNumber = ?, Email = ?, DayOfBirth = ?, Sex = ?, ID_Person = ?,"
                    + " Address = ? WHERE ID_Customer = ?";
            var prepareStm = connect.prepareStatement(updateCusQuery);
            prepareStm.setString(1, customer.getFullName());
            prepareStm.setString(2, customer.getPhoneNumber());
            prepareStm.setString(3, customer.getEmail());
            SimpleDateFormat fomartDateSql = new SimpleDateFormat("yyyy-MM-dd");
            prepareStm.setString(4, fomartDateSql.format(customer.getBirthDay()));
            if (customer.getSex()) {
                prepareStm.setString(5, "True");
            } else {
                prepareStm.setString(5, "False");
            }
            prepareStm.setString(6, customer.getId_person());
            prepareStm.setString(7, customer.getAddress());
            prepareStm.setString(8, customer.getId_customer());
            System.out.println(customer.getId_customer());
            return prepareStm.executeUpdate();
        } catch (SQLServerException ex) {
            ex.printStackTrace();            
            return -1;
        } catch (SQLException ex) {
            ex.printStackTrace();            
            return -1;
        }
    }

    public int activeSavePWSQL(int isTrue, Customer customer) {
        SQLServerDataSource ds = configDataSource();
        try (var connect = ds.getConnection()) {
            String activePWSQL = "UPDATE dbo.Customer SET isSavepw = ? WHERE ID_Customer = ?";
            var prepareStm = connect.prepareStatement(activePWSQL);
            prepareStm.setString(1, isTrue + "");
            prepareStm.setString(2, customer.getId_customer());
            return prepareStm.executeUpdate();
        } catch (SQLServerException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return -1;
    }
    
     @Override
    public boolean insertShowTimeToSQL(ShowTime showTime) {
        SQLServerDataSource ds = configDataSource();
        try (var connect = ds.getConnection()) {
            String insertQuery = "INSERT INTO ShowTime Values(?, ?, ?, ?, ?, ?, ?)";
            var prepareStm = connect.prepareStatement(insertQuery);
            prepareStm.setString(1, showTime.getIdShowTime());
            prepareStm.setString(2, changeDateSQL(showTime.getStartTime()));
            prepareStm.setString(3, showTime.getMovie().getIdMovie());
            prepareStm.setString(4, showTime.getRoom().getIdRoom());
            prepareStm.setString(5, showTime.getMovieFomart());
            prepareStm.setString(6, "0");
            prepareStm.setInt(7, showTime.getTicketPrice());
            return prepareStm.execute();
        } catch (SQLServerException ex) {
            ex.printStackTrace();
            return false;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public ArrayList<ShowTime> readShowTimesFromSQL() {
        ArrayList<ShowTime> listShowTimeSQL = new ArrayList<>();
        SQLServerDataSource ds = configDataSource();
        try (var connect = ds.getConnection()) {
            String SQLQuery = "SELECT ID_ShowTime, StartTime, MV.ID_Movie,"
                    + " MV.Name, MV.Time, MV.AgeLimit, MV.OpeningDate, MV.Language,"
                    + " MV.Country, MV.Director, MV.Content, MV.TypeMovie, MV.Producer,"
                    + " MV.IsShowing, MV.ImageLink, R.ID_Room, R.RowOfChair, "
                    + "R.ColumOfChair, ST.MovieFormat, ST.TicketPrice FROM ShowTime"
                    + " ST JOIN Movie MV ON ST.ID_Movie = MV.ID_Movie JOIN Room R "
                    + "ON R.ID_Room = ST.ID_Room WHERE isDeleteST = '0' AND MV.isShowing = '1'";
            var prepareStm = connect.prepareStatement(SQLQuery);
            var rsSet = prepareStm.executeQuery();
            while (rsSet.next()) {
                String idShowTime = rsSet.getString(1);
                String startDateST = changeDateSTJava(rsSet.getString(2));
                //Movie
                String idMV = rsSet.getString(3);
                String nameMV = rsSet.getString(4);
                int timeMV = Integer.parseInt(rsSet.getString(5));
                int ageLimitMV = Integer.parseInt(rsSet.getString(6));
                String dateMV = changeDateMovie(rsSet.getString(7));
                String languageMV = rsSet.getString(8);
                String countryMV = rsSet.getString(9);
                String directorMV = rsSet.getString(10);
                String contentMV = rsSet.getString(11);
                String typeMV = rsSet.getString(12);
                String producerMV = rsSet.getString(13);
                boolean isShowingMV = rsSet.getBoolean(14);
                String linkImageMV = rsSet.getString(15);
                //Room
                String idRm = rsSet.getString(16);
                int rowChairR = Integer.parseInt(rsSet.getString(17));
                int colChairR = Integer.parseInt(rsSet.getString(18));
                String mVfomart = rsSet.getString(19);
                int ticketPrice = rsSet.getInt(20);
                //init
                Movie movie = new Movie(idMV, nameMV, timeMV,
                        ageLimitMV, dateMV, languageMV,
                        countryMV, producerMV, contentMV, typeMV,
                        directorMV, isShowingMV, linkImageMV);
                Room room = new Room(idRm, rowChairR, colChairR);
                ShowTime showTime = new ShowTime(idShowTime, startDateST, movie,
                        room, mVfomart, ticketPrice, false);
                listShowTimeSQL.add(showTime);
            }
        } catch (SQLServerException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ParseException ex) {
            ex.printStackTrace();
        } catch (InvalidBirthdayException ex) {
            ex.printStackTrace();
        }
        return listShowTimeSQL;
    }

    @Override
    public ShowTime readBookedShowTimesFromSQL(ShowTime showTime) {
        ShowTime showTimeInit = new ShowTime();
        Room room = new Room();
        SQLServerDataSource ds = configDataSource();
        try (var connect = ds.getConnection()) {
            String idRoomQuery = showTime.getRoom().getIdRoom();
            String movieFomartQuery = showTime.getMovieFomart();
            String startDateQuery = new SimpleDateFormat("yyyy-MM-dd HH:mm")
                    .format(showTime.getStartTime());
            String getShowTimeQuery = "SELECT ID_ShowTime, ST.StartTime, MV.ID_Movie,"
                    + " MV.Name, MV.Time, MV.AgeLimit, MV.OpeningDate, MV.Language,"
                    + " MV.country, MV.director, MV.content, MV.typeMovie,"
                    + " MV.producer, MV.isShowing, MV.imageLink, R.ID_Room,"
                    + " R.RowOfChair, R.ColumOfChair, R.NumOfVipChair,"
                    + " R.NumOfCoupleChair, ST.movieFormat, ST.ticketPrice FROM "
                    + "ShowTime ST JOIN Movie MV ON ST.ID_Movie = MV.ID_Movie JOIN"
                    + " Room R ON R.ID_Room = ST.ID_Room  WHERE ST.isDeleteST = '0'"
                    + " AND MV.isShowing = '1' AND ST.ID_Room = '" + idRoomQuery + "' AND "
                    + "ST.movieFormat = '" + movieFomartQuery + "' AND ST.StartTime = '"
                    + startDateQuery + "'";
            var prePareStm = connect.prepareStatement(getShowTimeQuery);
            var rsSet = prePareStm.executeQuery();
            while (rsSet.next()) {
                String idShowTime = rsSet.getString(1);
                String startDateST = changeDateSTJava(rsSet.getString(2));
                //Movie
                String idMV = rsSet.getString(3);
                String nameMV = rsSet.getString(4);
                int timeMV = Integer.parseInt(rsSet.getString(5));
                int ageLimitMV = Integer.parseInt(rsSet.getString(6));
                String dateMV = changeDateMovie(rsSet.getString(7));
                String languageMV = rsSet.getString(8);
                String countryMV = rsSet.getString(9);
                String directorMV = rsSet.getString(10);
                String contentMV = rsSet.getString(11);
                String typeMV = rsSet.getString(12);
                String producerMV = rsSet.getString(13);
                boolean isShowingMV = rsSet.getBoolean(14);
                String linkImageMV = rsSet.getString(15);
                //Room
                String idRm = rsSet.getString(16);
                int rowChairR = Integer.parseInt(rsSet.getString(17));
                int colChairR = Integer.parseInt(rsSet.getString(18));
                int numVipChair = Integer.parseInt(rsSet.getString(19));
                int numPairChair = Integer.parseInt(rsSet.getString(20));
                String mVfomart = rsSet.getString(21);
                int ticketPrice = rsSet.getInt(22);

                Movie movie = new Movie(idMV, nameMV, timeMV,
                        ageLimitMV, dateMV, languageMV,
                        countryMV, producerMV, contentMV, typeMV,
                        directorMV, isShowingMV, linkImageMV);

                room = new Room(idRm, rowChairR, colChairR,
                        numPairChair, numVipChair, null);
                room.calcuNormalChair();

                showTimeInit = new ShowTime(idShowTime, startDateST,
                        movie, room, mVfomart, ticketPrice, false);
            }
            ArrayList<Seat> listSeatST = readSeatCorresSTFromSQL(showTime);

            room.setListSeat(listSeatST);
            showTimeInit.setRoom(room);

            return showTimeInit;
        } catch (SQLServerException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ParseException ex) {
            ex.printStackTrace();
        } catch (InvalidBirthdayException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public ArrayList<Seat> readSeatCorresSTFromSQL(ShowTime showTime) {
        ArrayList<Seat> listSeat = new ArrayList<>();
        SQLServerDataSource ds = configDataSource();
        try (var connect = ds.getConnection()) {
            String idRoomQuery = showTime.getRoom().getIdRoom();
            String movieFomartQuery = showTime.getMovieFomart();
            String startDateQuery = new SimpleDateFormat("yyyy-MM-dd HH:mm")
                    .format(showTime.getStartTime());
            String getSeatListST = "SELECT t.ID_TypeSeat, t.NameTypeSeat, "
                    + "t.Surcharge, s.ID_Seat, s.Colum, s.Row FROM ShowTime"
                    + " ST JOIN Movie MV ON ST.ID_Movie = MV.ID_Movie JOIN"
                    + " Room R ON R.ID_Room = ST.ID_Room  JOIN Seat s  ON"
                    + " s.ID_Room = R.ID_Room JOIN TypeOfSeat t ON "
                    + "s.ID_TypeSeat = t.ID_TypeSeat WHERE ST.isDeleteST = '0'"
                    + " AND MV.isShowing = '1' AND ST.ID_Room = '" + idRoomQuery + "' AND "
                    + "ST.movieFormat = '" + movieFomartQuery + "' AND ST.StartTime = '"
                    + startDateQuery + "'";
            var prePareStm2 = connect.prepareStatement(getSeatListST);
            var rsSetSeatST = prePareStm2.executeQuery();
            while (rsSetSeatST.next()) {
                //TypeSeat
                String idTypeSeat = rsSetSeatST.getString(1);
                String typeOfSeat = rsSetSeatST.getString(2);
                int surCharge = rsSetSeatST.getInt(3);
                //Seat
                String idSeat = rsSetSeatST.getString(4);
                int colum = rsSetSeatST.getInt(5);
                int row = rsSetSeatST.getInt(6);

                //init TypeSeat
                TypeSeat typeSeat = new TypeSeat(idTypeSeat, typeOfSeat, surCharge);
                //init Seat
                Seat seat = new Seat(idSeat, row, colum, typeSeat, 0);
                listSeat.add(seat);
            }
            return listSeat;
        } catch (SQLServerException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listSeat;
    }

    private String changeDateSTJava(String dateSQLStr) {
        SimpleDateFormat fomartSQL = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        SimpleDateFormat fomartJava = new SimpleDateFormat("HH:mm dd/MM/yyyy");
        java.util.Date dateSQL = new java.util.Date();
        try {
            dateSQL = fomartSQL.parse(dateSQLStr);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        String dateJavaStr = fomartJava.format(dateSQL);
        return dateJavaStr;
    }

    private static String changeDateMovie(String date) {
        try {
            SimpleDateFormat fortDateOpingMovie = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat fomartDateSql = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date dateSql = fomartDateSql.parse(date);
            String dateCustomer = fortDateOpingMovie.format(dateSql);
            return dateCustomer;
        } catch (ParseException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public void setIsDeleteST(String idShowTime) {
        SQLServerDataSource ds = configDataSource();
        try (var connect = ds.getConnection()) {
            String SQLQuery = "UPDATE ShowTime SET isDeleteST = 1 where ID_ShowTime = ?";
            var prepareStm = connect.prepareStatement(SQLQuery);
            prepareStm.setString(1, idShowTime);
            prepareStm.execute();
        } catch (SQLServerException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void updateShowTime(ShowTime showTime) {
        SQLServerDataSource ds = configDataSource();
        try (var connect = ds.getConnection()) {
            String SQLQuery = "UPDATE ShowTime SET StartTime = ?, ID_Movie = ?, ID_Room = ?, movieFormat = ?, ticketPrice = ? where ID_ShowTime = ?";
            var prepareStm = connect.prepareStatement(SQLQuery);
            prepareStm.setString(1, changeDateSQL(showTime.getStartTime()));
            prepareStm.setString(2, showTime.getMovie().getIdMovie());
            prepareStm.setString(3, showTime.getRoom().getIdRoom());
            prepareStm.setString(4, showTime.getMovieFomart());
            prepareStm.setInt(5, showTime.getTicketPrice());
            prepareStm.setString(6, showTime.getIdShowTime());
            prepareStm.executeUpdate();
        } catch (SQLServerException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private String changeDateSQL(java.util.Date date) {
        SimpleDateFormat fomartSQL = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String dateSQL = fomartSQL.format(date);
        return dateSQL;
    }

    public ArrayList<ShowTime> readListST_CorrespondingWithMovie(String idMovieBooking) {
        System.out.println(idMovieBooking);
        ArrayList<ShowTime> listShowTimeSQL = new ArrayList<>();
        SQLServerDataSource ds = configDataSource();
        try (var connect = ds.getConnection()) {
            String SQLQuery = "SELECT ID_ShowTime, StartTime, MV.ID_Movie,"
                    + " MV.Name, MV.Time, MV.AgeLimit, MV.OpeningDate, MV.Language,"
                    + " MV.country, MV.director, MV.content, MV.typeMovie, MV.producer,"
                    + " MV.isShowing, MV.imageLink, R.ID_Room, R.RowOfChair, "
                    + "R.ColumOfChair, ST.movieFormat, ST.ticketPrice FROM ShowTime ST JOIN"
                    + " Movie MV ON ST.ID_Movie = MV.ID_Movie JOIN Room as "
                    + "R ON R.ID_Room = ST.ID_Room WHERE isDeleteST = 0 AND MV.ID_Movie = ?";
            var prepareStm = connect.prepareStatement(SQLQuery);
            prepareStm.setString(1, idMovieBooking);
            var rsSet = prepareStm.executeQuery();
            while (rsSet.next()) {
                String idShowTime = rsSet.getString(1);
                String startDateST = changeDateSTJava(rsSet.getString(2));
                //Movie
                String idMV = rsSet.getString(3);
                String nameMV = rsSet.getString(4);
                int timeMV = Integer.parseInt(rsSet.getString(5));
                int ageLimitMV = Integer.parseInt(rsSet.getString(6));
                String dateMV = changeDateMovie(rsSet.getString(7));
                String languageMV = rsSet.getString(8);
                String countryMV = rsSet.getString(9);
                String directorMV = rsSet.getString(10);
                String contentMV = rsSet.getString(11);
                String typeMV = rsSet.getString(12);
                String producerMV = rsSet.getString(13);
                boolean isShowingMV = rsSet.getBoolean(14);
                String linkImageMV = rsSet.getString(15);
                //Room
                String idRm = rsSet.getString(16);
                int rowChairR = Integer.parseInt(rsSet.getString(17));
                int colChairR = Integer.parseInt(rsSet.getString(18));
                String mVfomart = rsSet.getString(19);
                int ticketPrice = rsSet.getInt(20);

                //init 
                Movie movie = new Movie(idMV, nameMV, timeMV,
                        ageLimitMV, dateMV, languageMV,
                        countryMV, producerMV, contentMV, typeMV,
                        directorMV, isShowingMV, linkImageMV);
                Room room = new Room(idRm, rowChairR, colChairR);
                ShowTime showTime = new ShowTime(idShowTime, startDateST,
                        movie, room, mVfomart, ticketPrice, false);
                listShowTimeSQL.add(showTime);
            }
        } catch (SQLServerException ex) {
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ParseException ex) {
            ex.printStackTrace();
        } catch (InvalidBirthdayException ex) {
            ex.printStackTrace();
        }
        return listShowTimeSQL;
    }

    public TicketSale getBookingTicketSale(ShowTime showTime, Customer customer) throws ParseException {
        TicketSale ticketSale = new TicketSale();
        SQLServerDataSource ds = configDataSource();
        try (var connect = ds.getConnection()) {
            // lấy toàn bộ trường dữ liệu của TicketSale (chỉ lấy 1 dòng)
            String SQLQuery = "SELECT ID_TicketSale, SaleDate, Total, "
                    + "quantityNormal, quantityPair, quantityAllSeat, "
                    + "quantityVip, FROM TicketSale TS JOIN Customer CUS ON "
                    + "TS.ID_Customer = CUS.ID_Customer JOIN Seat S  ON "
                    + "TS.ID_Seat = S.ID_Seat";
            var prepareStm = connect.prepareStatement(SQLQuery);
            prepareStm.setString(1, showTime.getIdShowTime());
            var rsSet = prepareStm.executeQuery();
            String ID_TikcetSale = rsSet.getString(1);
            SimpleDateFormat dateFormat = new SimpleDateFormat();
            String saleDate = changeDateSQL(rsSet.getDate(2));
            java.util.Date SaleDate = dateFormat.parse(saleDate);
            int Total = Integer.parseInt(rsSet.getString(3));
            int quantityNormal = Integer.parseInt(rsSet.getString(4));
            int quantityPair = Integer.parseInt(rsSet.getString(5));
            int quantityVIP = Integer.parseInt(rsSet.getString(6));
            int quantityAllSeat = Integer.parseInt(rsSet.getString(7));

            ticketSale.setIdTS(ID_TikcetSale);
            ticketSale.setSaleDate(SaleDate);
            ticketSale.setTotalMoney(Total);
            ticketSale.setShowTime(showTime);
            ticketSale.setCustomer(customer);
            ticketSale.setQuantityNormal(quantityNormal);
            ticketSale.setQuantityPair(quantityPair);
            ticketSale.setQuantityVip(quantityVIP);
            ticketSale.setQuantityAll(quantityAllSeat);
            ticketSale.setListSeat(this.readSeatCorresSTFromSQL(showTime));
        } catch (SQLServerException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ticketSale;
    }
    
    // lấy id TicketSale co gia tri lon nhat
    public int getMaxIDTicketSale() {
        int max = 0;
        SQLServerDataSource ds = configDataSource();
        try (var connect = ds.getConnection()) {
            String SQLQuery = "SELECT ID_TicketSale FROM TicketSale";
            var prePareStm = connect.prepareStatement(SQLQuery);
            var rsSet = prePareStm.executeQuery();
            while (rsSet.next()) {
                String ID_TicketSale = rsSet.getString(1);
                int tmp = Integer.parseInt(ID_TicketSale.substring(2));
                if(max < tmp) {
                    max = tmp;
                }
            }
        } catch (SQLServerException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return max;
    }

    // lấy danh sách những ID_TicketSale với ShowTime tương ứng
    public ArrayList<String> getIDTicketSale(ShowTime showTime) {
        ArrayList<String> listID_TicketSale = new ArrayList<>();
        SQLServerDataSource ds = configDataSource();
        try (var connect = ds.getConnection()) {
            String SQLQuery = "SELECT ID_TicketSale FROM TicketSale WHERE ID_ShowTime = ?";
            var prePareStm = connect.prepareStatement(SQLQuery);
            prePareStm.setString(1, showTime.getIdShowTime());
            var rsSet = prePareStm.executeQuery();
            while (rsSet.next()) {
                String ID_TicketSale = rsSet.getString(1);
                listID_TicketSale.add(ID_TicketSale);
            }
        } catch (SQLServerException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listID_TicketSale;
    }

    // lấy danh sách những ghế đã được chọn với ShowTime tương ứng 
    public ArrayList<String> getSeatChoosen(ShowTime showTime) {
        ArrayList<String> listID_TicketSale = getIDTicketSale(showTime);
        ArrayList<String> listSeatChoosen = new ArrayList<>();
        SQLServerDataSource ds = configDataSource();
        for (String x : listID_TicketSale) {
            try (var connect = ds.getConnection()) {
                String SQLQuery = "SELECT ID_Seat FROM DetailTicketSale WHERE ID_TicketSale = ?";
                var prePareStm = connect.prepareStatement(SQLQuery);
                prePareStm.setString(1, x);
                var rsSet = prePareStm.executeQuery();
                while (rsSet.next()) {
                    String ID_Seat = rsSet.getString(1);
                    listSeatChoosen.add(ID_Seat);
                }
            } catch (SQLServerException ex) {
                ex.printStackTrace();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return listSeatChoosen;
    }

    // lấy giá và loại ghế theo mã ghế 
    public List<String> getInfoOfSeat(String ID_Seat) {
        List<String> InfoSeat = new ArrayList<>();
        SQLServerDataSource ds = configDataSource();
        try (var connect = ds.getConnection()) {
            // lấy toàn bộ trường dữ liệu của TicketSale (chỉ lấy 1 dòng)
            String SQLQuery = "SELECT UnitPrice, ID_TypeSeat FROM Seat WHERE ID_Seat = ?";
            var prepareStm = connect.prepareStatement(SQLQuery);
            prepareStm.setString(1, ID_Seat);
            var rsSet = prepareStm.executeQuery();
            while (rsSet.next()) {
                String UnitPrice = rsSet.getString(1);
                String ID_TypeSeat = rsSet.getString(2);
                InfoSeat.add(UnitPrice);
                InfoSeat.add(ID_TypeSeat);
            }
        } catch (SQLServerException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return InfoSeat;
    }

    // ghi dữ liệu vào bảng TicketSale
    public void writeTicketSale(String ID_TicketSale, java.util.Date present, int total, ShowTime showTime, String ID_Staff) {
        SQLServerDataSource ds = configDataSource();
        try (var connect = ds.getConnection()) {
            String insertQuery = "INSERT INTO TicketSale(ID_TicketSale, SaleDate, Total, ID_ShowTime, ID_Staff, ID_Customer) Values(?, ?, ?, ?, ?, ?)";
            var prepareStm = connect.prepareStatement(insertQuery);
            prepareStm.setString(1, ID_TicketSale);
            prepareStm.setString(2, changeDateSQL(present));
            prepareStm.setString(3, total + "");
            prepareStm.setString(4, showTime.getIdShowTime());
            prepareStm.setString(5, ID_Staff);
            prepareStm.setString(6, "CUS0000");
            prepareStm.execute();
        } catch (SQLServerException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void writeTicketSale2(String ID_TicketSale, java.util.Date present, int total, ShowTime showTime, String ID_Customer) {
        SQLServerDataSource ds = configDataSource();
        try (var connect = ds.getConnection()) {
            String insertQuery = "INSERT INTO TicketSale(ID_TicketSale, SaleDate, Total, ID_ShowTime, ID_Staff, ID_Customer) Values(?, ?, ?, ?, ?, ?)";
            var prepareStm = connect.prepareStatement(insertQuery);
            prepareStm.setString(1, ID_TicketSale);
            prepareStm.setString(2, changeDateSQL(present));
            prepareStm.setString(3, total + "");
            prepareStm.setString(4, showTime.getIdShowTime());
            prepareStm.setString(5, "Staff0000");
            prepareStm.setString(6, ID_Customer);
            prepareStm.execute();
        } catch (SQLServerException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    // ghi những ghế được chọn vào bảng detailTicketSale
    public void writeDetailTicketSale(String ID_TicketSale, List<String> listSeatHasJustBeenSelected, ShowTime showTime) {
        SQLServerDataSource ds = configDataSource();
        try (var connect = ds.getConnection()) {
            for (String x : listSeatHasJustBeenSelected) {
                String insertQuery = "INSERT INTO DetailTicketSale(ID_TicketSale, ID_Seat) Values(?, ?)";
                var prepareStm = connect.prepareStatement(insertQuery);
                prepareStm.setString(1, ID_TicketSale);
                prepareStm.setString(2, x + showTime.getRoom().getIdRoom());
                prepareStm.execute();
            }
        } catch (SQLServerException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    @Override
    public int insertData(Staff staff) {
        SQLServerDataSource ds = configDataSource();
        try(var conn = ds.getConnection()) {
            var sql = "insert into dbo.Staff(ID_Staff, FullName, Password, ID_Person, PhoneNumber, Email, Address, StartDate, Sex, IsWorking, NameTask, IsDelete, BirthDate, NumOfDayWorked, SalaryDay, Account)" + 
                    " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            var prepareStm = conn.prepareStatement(sql);
            System.out.println(staff.getID_Staff());
            prepareStm.setString(1, staff.getID_Staff()); //
            prepareStm.setString(2, staff.getFullName()); //
            prepareStm.setString(3, staff.getPassword()); //
            prepareStm.setString(4, staff.getId_person()); //
            prepareStm.setString(5, staff.getPhoneNumber()); //
            prepareStm.setString(6, staff.getEmail()); //
            prepareStm.setString(7, staff.getAddress()); //
            SimpleDateFormat formatDateSql = new SimpleDateFormat("yyyy-MM-dd");
            prepareStm.setString(8, formatDateSql.format(staff.getStartDate())); //
            if (staff.getSex()){
                prepareStm.setString(9, "true");
            } else {
                prepareStm.setString(9, "false");
            } //
            if (staff.isIsWorking()){
                prepareStm.setString(10, "true");
            } else {
                prepareStm.setString(10, "false");
            } //
            prepareStm.setString(11, staff.getNameTask()); //
            if (staff.isIsDelete()){
                prepareStm.setString(12, "true");
            } else {
                prepareStm.setString(12, "false");
            } //
            prepareStm.setString(13, formatDateSql.format(staff.getBirthDay())); //
            prepareStm.setInt(14, staff.getNumOfDateWorked()); // 
            prepareStm.setInt(15, staff.getSalaryDate());
            prepareStm.setString(16, staff.getAccount());
            return prepareStm.executeUpdate();
        } catch (SQLServerException ex) {
            ex.printStackTrace();
            return -1;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return -1;
        }  
    }

    @Override
    public int deleteStaff(String ID_StaffDelete) {
        SQLServerDataSource ds = configDataSource();
        try(var connect = ds.getConnection()) {
            String deleteStaffQuery = "update dbo.Staff set isDelete = 1 where ID_Staff = ?";
            var prepareStm = connect.prepareStatement(deleteStaffQuery);
            prepareStm.setString(1, ID_StaffDelete);
            return prepareStm.executeUpdate();
        } catch (SQLServerException ex) {
            ex.printStackTrace();
            return -1;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return -1;
        }
    }

    @Override
    public int upDateStaff(Staff staff) {
        SQLServerDataSource ds = configDataSource();
        try(var connect = ds.getConnection()) {
            String updateStaffQuery = "update dbo.Staff set FullName = ?, PhoneNumber = ?, "
                    + "Email = ?, Address = ?, StartDate = ?, Sex = ?, NameTask = ?, BirthDate = ? where ID_Staff = ?";
            var prepareStm = connect.prepareStatement(updateStaffQuery);
            prepareStm.setString(1, staff.getFullName());
            prepareStm.setString(2, staff.getPhoneNumber());
            prepareStm.setString(3, staff.getEmail());
            prepareStm.setString(4, staff.getAddress());
            SimpleDateFormat formatDateSql = new SimpleDateFormat("yyyy-MM-dd");
            prepareStm.setString(5, formatDateSql.format(staff.getStartDate()));
            if (staff.getSex()){
                prepareStm.setString(6, "1");
            } else {
                prepareStm.setString(6, "0");
            }
            prepareStm.setString(7, staff.getNameTask());
            prepareStm.setString(8, formatDateSql.format(staff.getBirthDay()));
            prepareStm.setString(9, staff.getID_Staff());
            return prepareStm.executeUpdate();
        } catch (SQLServerException ex) {
            ex.printStackTrace();
            return -1;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return -1;
        }
    }
    
    // cập nhật số ngày làm cho nhân viên 
    public int updateNumOfDayWorked(String ID_Staff, int numOfDayWorked) {
        SQLServerDataSource ds = configDataSource();
        try(var connect = ds.getConnection()) {
            String updateStaffQuery = "update dbo.Staff set NumOfDayWorked = ? where ID_Staff = ?";
            var prepareStm = connect.prepareStatement(updateStaffQuery);
            prepareStm.setInt(1, numOfDayWorked);
            prepareStm.setString(2, ID_Staff);
            return prepareStm.executeUpdate();
        } catch (SQLServerException ex) {
            ex.printStackTrace();
            return -1;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return -1;
        }
    }
    
    // cap nhat muc luong cho nhan vien
    public int updateSalary(String ID_Staff, int newSalary) {
        SQLServerDataSource ds = configDataSource();
        try(var connect = ds.getConnection()) {
            String updateStaffQuery = "update dbo.Staff set SalaryDay = ? where ID_Staff = ?";
            var prepareStm = connect.prepareStatement(updateStaffQuery);
            prepareStm.setInt(1, newSalary);
            prepareStm.setString(2, ID_Staff);
            return prepareStm.executeUpdate();
        } catch (SQLServerException ex) {
            ex.printStackTrace();
            return -1;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return -1;
        }
    }
    
    @Override
    public List<Movie> readMovieFromDS() {
        List <Movie> listMovie = new ArrayList<>();
        SQLServerDataSource ds = configDataSource();
        try (var connect = ds.getConnection()) {
            String sqlReadMovieQuery = "SELECT * FROM Movie WHERE isShowing = 1";
            var prepareStm = connect.prepareStatement(sqlReadMovieQuery);
            var rs = prepareStm.executeQuery();
            while(rs.next()) {
                String idMovie = rs.getString(1);
                String name = rs.getString(2);
                int time = rs.getInt(3);
                int ageLimit = rs.getInt(4);
                String dateOpening = changeDate(rs.getString(5));
                String language = rs.getString(6);
                String country = rs.getString(7);
                String director = rs.getString(8);
                String content = rs.getString(9);
                String typeMovie = rs.getString(10);
                String producer = rs.getString(11);
                boolean isShowing = false;
                if (rs.getString(12) == "1") {
                    isShowing = true;
                }
                String imageLink = rs.getString(13);
                Movie movie = new Movie(idMovie, name, time, ageLimit, 
                        dateOpening, language, country, producer, content,
                        typeMovie, director, isShowing, imageLink);
                listMovie.add(movie);
            }
        } catch (SQLServerException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ParseException ex) {
            ex.printStackTrace();
        } catch (InvalidBirthdayException ex) {
            ex.printStackTrace();
        }
        return listMovie;
    }


    public int deleteMovie(Movie movie) {
        SQLServerDataSource ds = configDataSource();
        try (var connect = ds.getConnection()) {
            String deleteMovieQuery = "UPDATE dbo.Movie SET isShowing = 0 WHERE ID_Movie = ?";
            var prepareStm = connect.prepareStatement(deleteMovieQuery);
            prepareStm.setString(1, movie.getIdMovie());
            return prepareStm.executeUpdate();
        } catch (SQLServerException ex) {
            ex.printStackTrace();
            return -1;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return -1;
        }
    }

    public void updateMovie(Movie movieUpdate) {
        SQLServerDataSource ds = configDataSource();
        try (var connect = ds.getConnection()) {
            String updateMovieQuery = "UPDATE Movie SET Name = ?, Time = ?,"
                    + " AgeLimit = ?, OpeningDate = ?, Language = ?, country = ?,"
                    + " director = ?, content = ?, typeMovie = ?, producer = ?,"
                    + " isShowing = ?, imageLink = ? WHERE ID_Movie = ?;";
            var prepareStm = connect.prepareStatement(updateMovieQuery);
             prepareStm.setString(1, movieUpdate.getNameMovie());
            prepareStm.setInt(2, movieUpdate.getTime());
            prepareStm.setInt(3, movieUpdate.getAgeLimit());
            prepareStm.setString(4, new SimpleDateFormat("yyyy-MM-dd").
                    format(movieUpdate.getOpeningDate()));
            prepareStm.setString(5, movieUpdate.getLaguage());
            prepareStm.setString(6, movieUpdate.getCountry());
            prepareStm.setString(7, movieUpdate.getDirector());
            prepareStm.setString(8, movieUpdate.getContent());
            prepareStm.setString(9, movieUpdate.getTypeMovie());
            prepareStm.setString(10, movieUpdate.getProducer());
            if (movieUpdate.isIsShowing()) {
                prepareStm.setString(11,"1");
            } else {
                prepareStm.setString(11, "0");
            }
            prepareStm.setString(12,movieUpdate.getLinkImage());
            prepareStm.setString(13,movieUpdate.getIdMovie());
            prepareStm.executeUpdate();
        } catch (SQLServerException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
    }

    public int insertMovieDataToSql(Movie movie) {
        SQLServerDataSource ds = configDataSource();
        try (var connect = ds.getConnection()) {
            String inSertMoviesqlQuery = "INSERT INTO dbo.Movie(ID_Movie, Name,"
                    + " Time, AgeLimit, OpeningDate, Language, country, director,"
                    + " content, typeMovie, producer, isShowing,imageLink)\n" +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            var prepareStm = connect.prepareStatement(inSertMoviesqlQuery);
            prepareStm.setString(1, movie.getIdMovie());
            prepareStm.setString(2, movie.getNameMovie());
            prepareStm.setInt(3, movie.getTime());
            prepareStm.setInt(4, movie.getAgeLimit());
            prepareStm.setString(5, new SimpleDateFormat("yyyy-MM-dd").
                    format(movie.getOpeningDate()));
            prepareStm.setString(6, movie.getLaguage());
            prepareStm.setString(7, movie.getCountry());
            prepareStm.setString(8, movie.getDirector());
            prepareStm.setString(9, movie.getContent());
            prepareStm.setString(10, movie.getTypeMovie());
            prepareStm.setString(11, movie.getProducer());
            if (movie.isIsShowing()) {
                prepareStm.setString(12,"True");
            } else {
                prepareStm.setString(12, "False");
            }
            prepareStm.setString(13,movie.getLinkImage());
            return prepareStm.executeUpdate();
        } catch (SQLServerException ex) {
            ex.printStackTrace();
            return -1;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return -1;
        }
    }
    
    public int insertShowTimeInToSQL_New(ShowTime showTime) {
        SQLServerDataSource ds = configDataSource();
        try {
            Connection connect = ds.getConnection();
            String querySQL = "INSERT INTO ShowTime VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preStm = connect.prepareStatement(querySQL);
            preStm.setString(1, showTime.getIdShowTime());
            preStm.setString(2, new SimpleDateFormat("yyyy-MM-dd HH:ss").format(showTime.getStartTime()));
            preStm.setString(3, showTime.getMovie().getIdMovie());
            preStm.setString(4, showTime.getRoom().getIdRoom());
            preStm.setString(5, showTime.getMovieFomart());
            preStm.setString(6, "0");
            preStm.setInt(7, showTime.getTicketPrice());
            return preStm.executeUpdate();
        } catch (SQLServerException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
         return 0;
    }
}
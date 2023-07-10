package Java_project_SGU.FoodsDrinks;
import java.sql.*;

public class sqlConnect {
    private Connection con;
    private Statement sta;
    // thong tin sql server
    private String SERVER = "MSI\\SQLEXPRESS";
    private String USER = "sa";
    private String PASSWORD = "tiendat3121410148";
    private String DB_NAME = "QuanLyRapChieuPhim";
    private int PORT = 1433;
    
    public sqlConnect() {
        connectsql();
    }
    
    public void connectsql() {
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            this.con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=QuanLyRapChieuPhim;trustServerCertificate=true;integratedSecurity=true;user=sa;password=tiendat3121410148");
            this.sta = con.createStatement();
        }catch(Exception e){
                System.out.println(e);
        }
    }
    
    public Connection get_con() {
        return this.con;
    }
    
    public Statement get_sta(){
        return this.sta;
    }
    
    
}

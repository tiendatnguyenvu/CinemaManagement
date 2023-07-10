/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Java_project_SGU.DAL;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class ConnectSql {

    public static void main(String[] args) {
        int PORT = 1433;
        String SERVER = "LAPTOP-UGUU7LBC\\MAVAO";
        String USER = "sa";
        String PASSWORD = "Asdfgh1052003.";
        String DB_NAME = "QLRP";

        SQLServerDataSource ds = new SQLServerDataSource();
        ds.setUser(USER);
        ds.setPassword(PASSWORD);
        ds.setDatabaseName(DB_NAME);
        ds.setServerName(SERVER);
        ds.setPortNumber(PORT);
        ds.setEncrypt(false); // (1)
        ds.setIntegratedSecurity(false); // (2)
        ds.setTrustServerCertificate(false);
        try (Connection conn = ds.getConnection()) {
            System.out.println("Kết nối thành công!");
            System.out.println("DB: " + conn.getCatalog());
        } catch (SQLServerException ex) {
            Logger.getLogger(ConnectSql.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectSql.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

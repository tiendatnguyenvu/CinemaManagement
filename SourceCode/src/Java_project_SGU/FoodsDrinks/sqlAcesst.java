package Java_project_SGU.FoodsDrinks;
import Java_project_SGU.DAL.DAL_Implement;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class sqlAcesst {
    private String SERVER = "MSI\\SQLEXPRESS";
    private String USER = "sa";
    private String PASSWORD = "tiendat3121410148";
    private String DB_NAME = "QuanLyRapChieuPhim";
    private int PORT = 1433;
    private sqlConnect sql;
    
    public sqlAcesst(){
        this.sql = new sqlConnect();
    }
    
    public ArrayList<Food> getFoods(String getfor,String value){
        ArrayList<Food> list = new ArrayList<>();
        ResultSet rs = null;
        try {
            if(getfor.equals("manager")){
                switch (value) {
                    case "Tất cả":
                        rs = sql.get_sta().executeQuery("select ID_Food, Name, IsSaling, TypeFood, UnitPrice, Img_url from Food;");                
                        break;
                    case "Đang bán":
                        rs = sql.get_sta().executeQuery("select ID_Food, Name, IsSaling, TypeFood, UnitPrice, Img_url from Food where IsSaling =1;");
                        break;
                    case "Đang ẩn":
                        rs = sql.get_sta().executeQuery("select ID_Food, Name, IsSaling, TypeFood, UnitPrice, Img_url from Food where IsSaling =0;");
                        break;
                    default:
                        rs = sql.get_sta().executeQuery("select ID_Food, Name, IsSaling, TypeFood, UnitPrice, Img_url from Food where TypeFood= '"+value+"';");
                        break;
                }
            }
            else if(getfor.equals("user")){
                switch (value) {
                    case "Tất cả":
                        rs = sql.get_sta().executeQuery("select ID_Food, Name, IsSaling, TypeFood, UnitPrice, Img_url from Food where IsSaling=1;");                
                        break;
                    default:
                        rs = sql.get_sta().executeQuery("select ID_Food, Name, IsSaling, TypeFood, UnitPrice, Img_url from Food where IsSaling=1 and TypeFood= '"+value+"';");
                        break;
                }
            }
            else if(getfor.equals("mSearch")){
                if(!value.equals("")&&!value.equals("Tìm kiếm")){
                    rs = sql.get_sta().executeQuery("select ID_Food, Name, IsSaling, TypeFood, UnitPrice, Img_url from Food where Name like '%"+value+"%' or ID_Food like '%"+value+"%';");
                }
            }
            else if(getfor.equals("uSearch")){
                if(!value.equals("")&&!value.equals("Tìm kiếm")){
                    rs = sql.get_sta().executeQuery("select ID_Food, Name, IsSaling, TypeFood, UnitPrice, Img_url from Food where IsSaling=1 and Name like '%"+value+"%' or ID_Food like '%"+value+"%';");
                }
            }
            while(rs.next()){
                Food f = new Food();
                f.set(rs.getString(1), rs.getString(2), rs.getBoolean(3), rs.getString(4), rs.getInt(5), rs.getString(6));
                list.add(f);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
    
    public void setSaling(String id, boolean value){
        try {
            if(value==true){
                this.sql.get_sta().executeUpdate("update Food set IsSaling= 1 where ID_Food='"+id+"';");
            }
            else{
                this.sql.get_sta().executeUpdate("update Food set IsSaling= 0 where ID_Food='"+id+"';");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void insertFood(String id, String name, boolean isSaling, String type, int price, String url){
        try {
            if(isSaling==true){
                sql.get_sta().executeUpdate("insert into Food(ID_Food, Name, IsSaling, TypeFood, UnitPrice, Img_url) values('"+id+"','"+name+"',1,'"+type+"',"+price+",'"+url+"');");
            }
            else{
                sql.get_sta().executeUpdate("insert into Food(ID_Food, Name, IsSaling, TypeFood, UnitPrice, Img_url) values('"+id+"','"+name+"',0,'"+type+"',"+price+",'"+url+"');");                
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void insertDetailedFood(cart i){
        try {
            sql.get_sta().executeUpdate("insert into DetailedFood(ID_DetailedFood, Quantity, SizeFood, ID_Food) values('"+i.getID()+"',"+i.getQuantity()+",'"+i.getSize()+"','"+i.getID_Food()+");");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void dropByIDFood(String id){
        try {
            sql.get_sta().executeUpdate("delete from Food where ID_Food = '"+id+"';");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public boolean isInDatabase(String name, String type){
        try{
            ResultSet check =this.sql.get_sta().executeQuery("select count(*) from Food where TypeFood = '"+type+"' and Name = '"+name+"';");
            check.next();
            if(check.getInt(1)!=0){
                return false;
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return true;
    }
    
    // chỉnh sửa doc kieu khac
    public SQLServerDataSource configDataSource() {
        SQLServerDataSource dataSource = new SQLServerDataSource();
        dataSource.setEncrypt("false"); 
        dataSource.setIntegratedSecurity(false); 
        dataSource.setTrustServerCertificate(false);
        dataSource.setUser(DAL_Implement.USER);
        dataSource.setPassword(DAL_Implement.PASSWORD);
        dataSource.setDatabaseName(DAL_Implement.DB_NAME);
        dataSource.setServerName(DAL_Implement.SERVER);
        dataSource.setPortNumber(DAL_Implement.PORT);
        return dataSource;
    }
    
    public List<Food> readFoodFormDataForManager() {
        List<Food> foods = new ArrayList<>();
        SQLServerDataSource dataSource = configDataSource();
        try (var conn = dataSource.getConnection();) {
            String SqlQuery = "select ID_Food, Name, IsSaling, TypeFood, UnitPrice, Img_url from dbo.Food";
            var prepareStatement = conn.prepareStatement(SqlQuery);
            ResultSet resultSet = prepareStatement.executeQuery();
            while (resultSet.next()) {
                String ID_Food = resultSet.getString(1);
                String name = resultSet.getString(2);
                boolean isSaling = false;
                if (resultSet.getString(3).equals("1")) {
                    isSaling = true;
                }
                String typeFood = resultSet.getString(4);
                int unitPrice = resultSet.getInt(5);
                String imgUrl = resultSet.getString(6);
                
                Food food = new Food(ID_Food, name, isSaling, typeFood, unitPrice, imgUrl);
                foods.add(food);
            }
        } catch (SQLServerException ex) {
            Logger.getLogger(sqlAcesst.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(sqlAcesst.class.getName()).log(Level.SEVERE, null, ex);
        }
        return foods;
    }
    
    public List<Food> readFoodFormDataForUser() {
        List<Food> foods = new ArrayList<>();
        SQLServerDataSource dataSource = configDataSource();
        try (var conn = dataSource.getConnection();) {
            String SqlQuery = "select ID_Food, Name, IsSaling, TypeFood, UnitPrice, Img_url from dbo.Food";
            var prepareStatement = conn.prepareStatement(SqlQuery);
            ResultSet resultSet = prepareStatement.executeQuery();
            while (resultSet.next()) {
                String ID_Food = resultSet.getString(1);
                String name = resultSet.getString(2);
                boolean isSaling = false;
                if (resultSet.getString(3).equals("1")) {
                    isSaling = true;
                }
                String typeFood = resultSet.getString(4);
                int unitPrice = resultSet.getInt(5);
                String imgUrl = resultSet.getString(6);
                
                Food food = new Food(ID_Food, name, isSaling, typeFood, unitPrice, imgUrl);
                foods.add(food);
            }
        } catch (SQLServerException ex) {
            Logger.getLogger(sqlAcesst.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(sqlAcesst.class.getName()).log(Level.SEVERE, null, ex);
        }
        return foods;
    }
}
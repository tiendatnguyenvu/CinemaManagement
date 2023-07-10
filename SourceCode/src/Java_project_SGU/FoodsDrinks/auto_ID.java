package Java_project_SGU.FoodsDrinks;
import java.sql.*;

        
public class auto_ID {
    private String id_food;
    private String id_detail;
    private sqlConnect sql;
    
    public auto_ID() {
        this.id_food=null;
        this.id_detail=null;
        this.sql=new sqlConnect();
    }
    
    public String init_new_id_food(String type) {
        try {
            ResultSet last_id = sql.get_sta().executeQuery("select count(*) as 'quantity' from Food where TypeFood ='"+type+"';");
            last_id.next();
            int num_id=0;
            switch (type) {
                case "Thức ăn":
                    while(true){
                        ResultSet id = sql.get_sta().executeQuery("select count(*) from Food where ID_Food='"+"F"+num_id+"';");
                        id.next();
                        if(id.getInt(1)!=0){
                            num_id+=1;
                        }
                        else{
                            this.id_food="F"+num_id;
                            break;
                        }
                    }
                    break;
                case "Nước":
                    while(true){
                        ResultSet id = sql.get_sta().executeQuery("select count(*) from Food where ID_Food='"+"D"+num_id+"';");
                        id.next();
                        if(id.getInt(1)!=0){
                            num_id+=1;
                        }
                        else{
                            this.id_food="D"+num_id;
                            break;
                        }
                    }
                    break;
                case "Combo":
                    while(true){
                        ResultSet id = sql.get_sta().executeQuery("select count(*) from Food where ID_Food='"+"C"+num_id+"';");
                        id.next();
                        if(id.getInt(1)!=0){
                            num_id+=1;
                        }
                        else{
                            this.id_food="C"+num_id;
                            break;
                        }
                    }
                    break;
                default:
                    break;
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return this.id_food;
    }
    
    public String init_new_id_detail() {
        try {
            int num_id=0;
            while(true){
                ResultSet id = sql.get_sta().executeQuery("select count(*) from DetailedFood where ID_DetailedFood='FB"+num_id+"';");
                id.next();
                if(id.getInt(1)!=0){
                    num_id+=1;
                }
                else{
                    this.id_detail="FB"+num_id;
                    break;
                }
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return this.id_detail;
    }
}

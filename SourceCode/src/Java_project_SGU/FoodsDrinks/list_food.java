package Java_project_SGU.FoodsDrinks;
import java.util.ArrayList;

public class list_food {
    private ArrayList<Food> list;
    private sqlAcesst getset_sql;
    private auto_ID ID;
    
    public list_food(){
        this.list = new ArrayList<>();
        this.getset_sql=new sqlAcesst();  
        this.ID=new auto_ID();
    }
    
    public void setList(String getfor,String type){
        this.list=this.getset_sql.getFoods(getfor ,type);
    }
    
    public void setSaling(Food i){
        this.getset_sql.setSaling(i.getID(), i.getSaling());
    }
    
    public ArrayList<Food> getList(){
        return this.list;
    }
    
    public void dropFood(Food i){
        this.getset_sql.dropByIDFood(i.getID());
    }
    
    public boolean addNewFood(String id, String name, String isSaling, String type, String price, String url){
        if(this.getset_sql.isInDatabase(name,type)==true){
            if(isSaling.equals("có")){
                this.getset_sql.insertFood(this.ID.init_new_id_food(id), name, true, type,Integer.parseInt(price), url);
            }
            else{
                this.getset_sql.insertFood(this.ID.init_new_id_food(id), name, false, type,Integer.parseInt(price), url);
            }
            return true;
        }
        else{
            return false;
        }
    }
}

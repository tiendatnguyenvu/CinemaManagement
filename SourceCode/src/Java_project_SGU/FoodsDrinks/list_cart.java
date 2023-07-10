package Java_project_SGU.FoodsDrinks;

import java.util.ArrayList;
    
public class list_cart {
    private ArrayList<cart> list;
    private sqlAcesst getset_sql;
    private auto_ID ID;
    
    public list_cart(){
        this.list = new ArrayList<>();
        this.getset_sql=new sqlAcesst();  
        this.ID=new auto_ID();
    }

    public ArrayList<cart> getList(){
        return this.list;
    }
    
    public boolean addList(cart i){
        this.list.add(i);
        return true;
    }
    
    public cart getCart(int quantity, String size, String id_food){
        cart c = new cart();
        c.set(ID.init_new_id_detail(), quantity, size, id_food);
        return c;
    }
    
    public void clearCart(){
        this.list.clear();
    }
    
    public void addNewCart(cart i){
        try {
            getset_sql.insertDetailedFood( i);
        }catch (Exception e) {
            System.out.println(e);
        }
    }
//////////////////////////////    
    public Object[] makeObjects(){
        Object[] data={};
        return data;
    }
}

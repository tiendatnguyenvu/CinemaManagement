package Java_project_SGU.FoodsDrinks;

public class cart {
    private String id;
    private int quantity;
    private String size;
    private String id_food;
    
    public cart(){
        this.id=null;
        this.quantity=0;
        this.size=null;
        this.id_food=null;
    }
    
    public void set(String id, int quantity, String size, String id_food){
        this.id=id;
        this.quantity=quantity;
        this.size=size;
        this.id_food=id_food;
    }
    
    public void setID(String id){
        this.id=id;
    }
    public void setQuantity(int quantity){
        this.quantity=quantity;
    }
    public void setSize(String size){
        this.size=size;
    }
    public void setID_Food(String id_food){
        this.id_food=id_food;
    }
    
    public String getID(){
        return this.id;
    }
    public int getQuantity(){
        return this.quantity;
    }
    public String getSize(){
        return this.size;
    }
    public String getID_Food(){
        return this.id_food;
    }
    
}

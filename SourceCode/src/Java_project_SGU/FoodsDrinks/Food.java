package Java_project_SGU.FoodsDrinks;

public class Food {
    private String ID;
    private String name;
    private boolean IsSaling;
    private String type;
    private int price;
    private String img_url;
    
    // constructor
    public Food(){
        this.ID=null;
        this.name=null;
        this.IsSaling=true;
        this.type=null;
        this.price=0;
        this.img_url=null;
    }
    
    public Food(String id, String name, boolean sale, String type, int price, String url){
        this.ID=id;
        this.name=name;
        this.IsSaling=sale;
        this.type=type;
        this.price=price;
        this.img_url=url;
    }
    
    // getter and setter
    public void set(String id, String name, boolean sale, String type, int price, String url){
        this.ID=id;
        this.name=name;
        this.IsSaling=sale;
        this.type=type;
        this.price=price;
        this.img_url=url;
    }
    
    public void setID(String id){
        this.ID=id;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setSaling(boolean sale){
        this.IsSaling=sale;
    }
    public void setType(String type){
        this.type=type;
    }
    public void setPrice(int price){
        this.price=price;
    }
    public void setImg(String url){
        this.img_url=url;
    }
    
    public String getID(){
        return this.ID;
    }
    public String getName(){
        return this.name;
    }
    public boolean getSaling(){
        return this.IsSaling;
    }
    public String getType(){
        return this.type;
    }
    public int getPrice(){
        return this.price;
    }
    public String getImg(){
        return this.img_url;
    }
}

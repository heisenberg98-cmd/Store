public class Product {
   private int id;
    private String name;
    private double price;
    private int stock;
    private static int nextId=1000;
    Product(String name, double price, int stock){
        if(name==null||name.equals("")){
            this.name="Unknown";
        }
        else{
            this.name=name;
        }
        if(price<=0){
            this.price=1;
        }
        else{
            this.price=price;
        }
        if(stock<0){
            this.stock=0;
        }
        else{
            this.stock=stock;
        }
        id=nextId++;
    }
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public double getPrice(){
        return price;
    }
    public int getStock(){
        return stock;
    }
    public boolean setName(String name){
        int count=0;
        while(count<name.length()&&name.charAt(count)==' '){
            count++;
        }
        if(count==name.length()){
            return false;
        }
        name=name.substring(count);
        count=0;
        while(name.charAt(name.length()-1-count)==' '){
            count--;
        }
        name=name.substring(0,count*(-1));
            this.name=name;
            return true;

    }
    public boolean setPrice(double price){
        if(price>0){
            this.price=price;
            return true;
        }
        return false;
    }
    public boolean setStock(int stock){
        if(stock>=0){
            this.stock=stock;
            return true;
        }
        return false;
    }
    public boolean sell(int quantity){
        if(quantity>0&&stock-quantity>=0){
            stock-=quantity;
            return true;
        }
        return false;
    }
    public String getInfo(){
        return "Id: "+id+", Name: "+name+", Price: "+price+", Stock: "+stock;
    }
    public static int getNextid(){
        return nextId;
    }
}

public class Store {
    private String storeName;
    private Product[] product;
    private int[] soldCount;
    private int productCount;

    Store(String storeName, int capacity){
        this.storeName=storeName;
        product=new Product[capacity];
        soldCount=new int[capacity];
        productCount=0;
    }
    public boolean addProduct(Product product){
        if(productCount==this.product.length){
            return false;
        }
        for(int i=0;i<productCount;i++){
            if(this.product[i].getId()==product.getId()){
                return false;
            }
        }
        this.product[productCount++]=product;
        return true;
    }
    public int findProductIndex(int id){
        int i=0;
        while(i<productCount){
            if(product[i].getId()==id){
                break;
            }
            i++;
        }
        if(i==productCount){
            return -1;
        }
        return i;
    }

    public boolean sellPorduct(int id,int quantity){
        int i=0;
        while(i<productCount){
            if(product[i].getId()==id){
                if(product[i].sell(quantity)) {
                    soldCount[i] += quantity;
                    return true;
                }
                return false;
            }
            i++;
        }
        return false;
    }
    public void printAvailableProducts(){
        for(int i=0;i<productCount;i++){
            if(product[i].getStock()==0){
                continue;
            }
            System.out.println(product[i].getInfo());
        }
    }
    public void printSalesReport(){
        System.out.println("Store name: "+storeName);
        for(int i=0;i<productCount;i++) {
            System.out.print("" + product[i].getName() + ": " + soldCount[i] + ". ");
        }
        System.out.println("");
    }
    public int getTotalUnitsSold(){
        int sum=0;
        for(int i=0;i<productCount;i++){
            sum+=soldCount[i];
        }
        return sum;
    }

}

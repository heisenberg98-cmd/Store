public class Main {
    public static void main(String[]args){
        Store store=new Store("eyal",3);
        Product product1=new Product("NoteBook",12.5,3);
        Product product2=new Product("Pen",4,2);
        Product product3=new Product("Bottle",30,0);
        System.out.println(""+store.addProduct(product1));
        System.out.println(""+store.addProduct(product2));
        System.out.println(""+store.addProduct(product3));
        Product product4=new Product("Pants",50,4);
        System.out.println(""+store.addProduct(product4));
        System.out.println(""+store.sellPorduct(product1.getId(),2));
        System.out.println(""+store.sellPorduct(product2.getId(),3));
        store.printSalesReport();
        store.sellPorduct(product2.getId(),2);
        store.printSalesReport();
        product1.setPrice(-5);
        System.out.println(product1.getPrice());
        store.printAvailableProducts();
        store.printSalesReport();
        System.out.println(store.getTotalUnitsSold());
        System.out.print("Products id: ");
        for(int i=1000;i<Product.getNextid();i++){
            if(i==Product.getNextid()-1){
                System.out.println(i);
            }
            else{
                System.out.print(i+", ");
            }
        }
        System.out.println("Next products id: "+Product.getNextid());
    }
}

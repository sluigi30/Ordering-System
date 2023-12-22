public class History{
    private String itemName;
    private String newitemName;
    private int quantity;
    private int newquantity;
    private int totalPrice;

    public History(String itemName, int quantity, String newitemName, int newquantity, int totalPrice) {
        this.itemName = itemName;
        this.itemName = newitemName;
        this.quantity = quantity;
        this.quantity = newquantity;
        this.totalPrice = totalPrice;
    }

    public String getitemName(){
        return itemName;
    }
    public String getnewitemName(){
        return newitemName;
    }
    public int getquantity(){
        return quantity;
    }
    public int getnewquantity(){
        return newquantity;
    }
    
    public int gettotalPrice(){
        return totalPrice;
    }
}
// public class History {
//     private String itemName;
//     private String newitemName;
//     private int quantity;
//     private int newquantity;
//     private int total;

//     public History(String itemName, int quantity, String newitemName, int newquantity, int totalPrice) {
//         this.itemName = itemName;
//         this.newitemName = newitemName;
//         this.quantity = quantity;
//         this.newquantity = newquantity;
//         this.total = total;
//     }

//     public String getitemName() {
//         return itemName;
//     }

//     public String getnewitemName() {
//         return newitemName;
//     }

//     public int getquantity() {
//         return quantity;
//     }

//     public int getnewquantity() {
//         return newquantity;
//     }

//     public int gettotalPrice() {
//         return total;
//     }

//     public void setnewitemName(String newitemName) {
//         this.newitemName = newitemName;
//     }

//     public void setnewquantity(int newquantity) {
//         this.newquantity = newquantity;
//     }

//     public void setnewtotal(int total) {
//         this.total = total;
//     }

// }
public class History {
    private String itemHistory;
    public History(String itemHistory){
        this.itemHistory = itemHistory;
    }

    public String getitemHistory(){
        return itemHistory;
    }
}
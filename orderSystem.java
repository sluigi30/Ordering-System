import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class orderSystem{
    private static String[] items = {"PIATTOS", "COKE", "PEPSI", "OISHI", "CALBEE"};
    private static int [] price = {15, 20, 20, 9, 20};
    private static int payment;
    private static int change;
    private static int total;
    private static int buyitem;
    private static int newbuyitem;
    private static int quantitymore;
    private static int buyQuantity;
    private static List<History> orderHistory = new ArrayList<>();

    
    public static void main(String[] args) {
        MainMenu();
    }

    public static void MainMenu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("++=========================================++");
        System.out.println("              1. *PURCHASE*                  ");
        System.out.println("              2. *ADD PRODUCT*               ");
        System.out.println("              3. *HISTORY*                   ");
        System.out.println("++=========================================++");
        System.out.print("SELECT AN OPTION ");
        int mainnum = scanner.nextInt();
        switch (mainnum) {
            case 1:
                Buy();
                break;
            case 2:
                Add();
                break;
            case 3:
                showHistory();
                break;
            default:
                System.out.println("PLEASE CHOOSE THE GIVEN CHOICES");
                MainMenu();
                break;
        }
    }

    public static void Products() {
        Scanner scanner = new Scanner(System.in);
        double total=0;
        int quantity = 0;
        
        
        System.out.println("++=========================================++");
        if (items.length == price.length) {
            for (int i = 0; i < items.length; i++) {
                System.out.println("             "+i +"  *"+ items[i] + " = " + price[i]+"*");
            }
        } 
        System.out.println("++=========================================++");
    }

    public static void Buy(){
        Scanner scanner = new Scanner(System.in);
        Products();
        System.out.println("SELECT THE NUMBER OF THE ITEM");
        buyitem = scanner.nextInt();
        Validation();
        System.out.println("HOW MANY?");
        int buyQuantity = scanner.nextInt();
        total = price[buyitem] * buyQuantity;
        
        History newHistory = new History(items[buyitem],buyQuantity, items[newbuyitem], quantitymore , total);
        orderHistory.add(newHistory);
        BuyMenu();
    }

    public static void Checkout(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("PAYMENT AMOUNT: ");
        payment = scanner.nextInt();
        if (payment == total) {
            System.out.println("THANK YOU FOR BUYING!");
            MainMenu();
        }else if (payment>total) {
            change = payment - total;
            System.out.println("YOUR CHANGE IS "+ change);
            System.out.println("THANK YOU FOR BUYING!");
            MainMenu();
        }else{
            System.out.println("NOT ENOUGH PAYMENT! ERROR!");
            Checkout();
        }
    }

    public static void Add(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("PRODUCT NAME: ");
        String name = scanner.nextLine();
        System.out.println("PRODUCT PRICE: ");
        int productPrice = scanner.nextInt();
        items = addItemToArray(items, name);
        price = addItemToArray(price, productPrice);
        System.out.println("Product added successfully!");
        Products();
        MainMenu();
    }

    public static String[] addItemToArray(String[] oldArray, String newItem) {
        String[] newArray = new String[oldArray.length + 1];
        System.arraycopy(oldArray, 0, newArray, 0, oldArray.length);
        newArray[newArray.length - 1] = newItem;
        return newArray;
    }

    public static int[] addItemToArray(int[] oldArray, int newItem) {
        int[] newArray = new int[oldArray.length + 1];
        System.arraycopy(oldArray, 0, newArray, 0, oldArray.length);
        newArray[newArray.length - 1] = newItem;
        return newArray;
    }

    public static void Validation(){
        if(items.length > buyitem && buyitem >= 0 ){
            return;
        }else{
            System.out.println("ERROR: PLEASE CHOOSE THE GIVEN OPTION ONLY!");
            Buy();
        }
    }

    public static void Validation2(){
        if(items.length > newbuyitem && newbuyitem >= 0 ){
            return;
        }else{
            System.out.println("ERROR: PLEASE CHOOSE THE GIVEN OPTION ONLY!");
            buymore();
        }
    }
    public static void buymore(){
        Scanner scanner = new Scanner(System.in);
        Products();
        System.out.println("SELECT THE NUMBER OF THE ITEM");
        newbuyitem = scanner.nextInt();
        Validation2();
        System.out.println("HOW MANY?");
        int quantitymore = scanner.nextInt();
        total = total + price[newbuyitem] * quantitymore;
        System.out.println("YOUR TOTAL IS: "+ total);
        BuyMenu();
        History newHistory = new History(items[buyitem], buyQuantity, items[newbuyitem], quantitymore , total);
        orderHistory.add(newHistory);
        System.out.println("Item added to order history in Buymenu method.");
        BuyMenu();
        
    }
    public static void BuyMenu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("++=========================================++");
        System.out.println("              1. *BUY MORE?*                   ");
        System.out.println("              2. *CHECK OUT*                   ");
        System.out.println("++=========================================++");
        int buyCheck = scanner.nextInt();
        switch (buyCheck) {
            case 1:
               buymore();
               break;
            case 2:
                System.out.println("YOUR TOTAL IS: " + total);
                Checkout();
                break;
            default:
                break;
        }
    }

    public static void showHistory(){
        System.out.println("++=========================================++");
        System.out.println("                  *HISTORY*                  ");
        System.out.println("++=========================================++");
        for(History history : orderHistory){
            System.out.println(history.getitemName());
            System.out.println(history.getnewitemName());
            System.out.println(history.getquantity());
            System.out.println(history.getnewquantity());
            System.out.println(history.gettotalPrice());
            
        }
        
    }
}
/*ystem.out.println("ITEMS: " + history.getitemName() + ", " + history.getnewitemName());
            System.out.println("QUANTITY: " + history.getquantity() +", "+ history.getnewquantity());
            System.out.println("TOTAL: " + history.gettotalPrice());
            System.out.println("----------- ----");*/
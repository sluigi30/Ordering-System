import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class orderSystem{
    private static String[] items = {"PIATTOS", "COKE", "PEPSI", "OISHI", "CALBEE"};
    private static int [] price = {15, 20, 20, 9, 20};
    private static int payment;
    private static int change;
    private static int total;
    private static int buyItem;
    private static int newbuyitem;
    private static int quantitymore;
    private static int buyQuantity;
    private static int buyChoice;
    private static int mainnum;
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
        mainnum = scanner.nextInt();
        
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
        buyItem = scanner.nextInt();
        Validation();
        System.out.println("HOW MANY?");
        buyQuantity = scanner.nextInt();
        total = price[buyItem] * buyQuantity;
        newbuyitem = buyItem;
        quantitymore = buyQuantity;
        String history = "ITEM: " + items[buyItem] + ", QUANTITY: " + buyQuantity ;
        History newHistory = new History(history);
        orderHistory.add(newHistory);
        BuyMenu();
    }

    public static void buymore(){
        Scanner scanner = new Scanner(System.in);
        Products();
        System.out.println("SELECT THE NUMBER OF THE ITEM");
        newbuyitem = scanner.nextInt();
        Validation2();
        System.out.println("HOW MANY?");
        quantitymore = scanner.nextInt();
        total = total + price[newbuyitem] * quantitymore;
        System.out.println("YOUR TOTAL IS: "+ total);
        String newHistory = "ADDED PRODUCT: " + items[newbuyitem] + ", QUANTITY: " + quantitymore;
        History Histories = new History(newHistory);
        orderHistory.add(Histories); 
        BuyMenu();
        
    }

        public static void BuyMenu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("++=========================================++");
        System.out.println("              1. *BUY MORE?*                   ");
        System.out.println("              2. *CHECK OUT*                   ");
        System.out.println("++=========================================++");
        buyChoice = scanner.nextInt();
        switch (buyChoice) {
            case 1:
               buymore();
               break;
            case 2:
                System.out.println("YOUR TOTAL IS: " + total);
                Checkout();
                break;
            default:
                System.out.println("ERROR: PLEASE CHOOSE THE GIVEN OPTION ONLY!");
                BuyMenu();
                break;
        }
    }

    public static void Checkout(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("PAYMENT AMOUNT: ");
        payment = scanner.nextInt();
        change = payment - total;
        if (payment == total) {
            System.out.println("THANK YOU FOR BUYING!");
        }else if (payment>total) {
            System.out.println("YOUR CHANGE IS "+ change);
            System.out.println("THANK YOU FOR BUYING!");
        }else{
            System.out.println("NOT ENOUGH PAYMENT! ERROR!");
            Checkout();
        }
        String totalPrice = "TOTAL: " + total + " PAYMENT: " + payment + " CHANGE: " + change + " ||";
        History Histories = new History(totalPrice);
        orderHistory.add(Histories);
        MainMenu();
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

    private static void Validation() {
        if(items.length > buyItem && buyItem >= 0 ){
            return;
        }else{
            System.out.println("ERROR: PLEASE CHOOSE THE GIVEN OPTION ONLY!");
            Buy();
        }
    }

    private static void Validation2() {
        if(items.length > newbuyitem && newbuyitem >= 0 ){
            return;
        }else{
            System.out.println("ERROR: PLEASE CHOOSE THE GIVEN OPTION ONLY!");
            buymore();
        }
    }


    public static void showHistory(){
        System.out.println("++=========================================++");
        System.out.println("                  *HISTORY*                  ");
        System.out.println("++=========================================++");
        for(History newhistory : orderHistory){
            System.out.println(newhistory.getitemHistory());
        }
        System.out.println("----------------------------");
        MainMenu();
    }
}

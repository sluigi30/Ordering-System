import java.util.Scanner;
public class orderSystem{
    private static String[] items = {"PIATTOS", "COKE", "PEPSI", "OISHI", "CALBEE"};
    private static int [] price = {15, 20, 20, 9, 20};
    private static int payment;
    private static int change;
    private static int total;
    private static int buyitem;
    
    public static void main(String[] args) {
        MainMenu();
    }

    public static void MainMenu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("++=========================================++");
        System.out.println("              1. *PURCHASE*                   ");
        System.out.println("              2. *ADD PRODUCT*                ");
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
        BuyMenu();
    }

    public static void Checkout(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("PAYMENT AMOUNT: ");
        payment = scanner.nextInt();
        if (payment == total) {
                    System.out.println("THANK YOU FOR BUYING!");
                }else if (payment>total) {
                    change = payment - total;
                    System.out.println("YOUR CHANGE IS "+ change);
                    System.out.println("THANK YOU FOR BUYING!");
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
        if(items.length > buyitem && buyitem >= 0){
            return;
        }else{
            System.out.println("PLEASE CHOOSE THE GIVEN OPTION ONLY! ERROR! ERROR!");
            Buy();
        }
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
                Products();
                System.out.println("SELECT THE NUMBER OF THE ITEM");
                buyitem = scanner.nextInt();
                Validation();
                System.out.println("HOW MANY?");
                int quantitymore = scanner.nextInt();
                total = total + price[buyitem] * quantitymore;
                System.out.println("YOUR TOTAL IS: "+ total);
                BuyMenu();
                break;
            case 2:
                System.out.println("YOUR TOTAL IS: " + total);
                Checkout();
                break;
            default:
                break;
        }
    }
}
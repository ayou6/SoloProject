package solo;
import java.util.ArrayList;
import java.util.Scanner;
public class Item {
	
    Scanner scn = new Scanner(System.in);

	String itemName;
    int id;
    double price;
    int quantity;

     static ArrayList<Item> itemList = new ArrayList();
     public void addItem(Scanner scn) {
         System.out.print("Enter item name: ");
         String itemName = scn.nextLine();
         System.out.print("Enter item ID: ");
         int id = scn.nextInt();
         System.out.print("Enter item price: ");
         double price = scn.nextDouble();
         System.out.print("Enter item quantity: ");
         int quantity = scn.nextInt();
         
         Item newItem = new Item();
         itemList.add(newItem);
         
         System.out.println("Item added successfully.");
     }

}


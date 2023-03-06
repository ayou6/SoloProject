package solo;
import java.util.ArrayList;
import java.util.Scanner;
public class Item {
	
    static Scanner scn = new Scanner(System.in);

	String itemName;
    int id;
    double price;
    int quantity;

     static ArrayList<Item> itemList = new ArrayList();
     public void addItem() {
     	Boolean Load = true;
        while (Load) {
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
         System.out.println("Do you want to add more? y/n");
         String more = scn.next();
         if (more.equalsIgnoreCase("y")) {
         	 Load = true;
         } else {
             Load = false;
         }break;
}

     }
     
     public static void deleteItem() {
         System.out.print("Enter item ID to delete: ");
         int id = scn.nextInt();
         
         
         // search for item with matching ID and remove from itemList
         boolean found = false;
         for (Item item : itemList) {
             if (item.getId() == id) {
                 itemList.remove(item);
                 found = true;
                 break;
             }
         }
         
         if (found) {
             System.out.println("Item deleted successfully.");
         } else {
             System.out.println("Item not found.");
         }
     }

	private int getId() {
		// TODO Auto-generated method stub
		return 0;
	}

}


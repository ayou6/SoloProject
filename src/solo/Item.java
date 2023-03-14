package solo;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.nio.file.*;

public class Item {

    static Scanner scn = new Scanner(System.in);

    String itemName;
    int id;
    double price;
    int quantity;
    double qty;




    public void addItem() {
        boolean load = true;
        while (load) {
        	Item Itm = new Item();
        	Main.myShop.itemList.add(Itm);
        	
            System.out.print("Enter item name: ");
            String itemName = scn.next();
            Itm.itemName = itemName;
            
            System.out.print("Enter item ID: ");
            int id = scn.nextInt();
            Itm.id = id;
            
            System.out.print("Enter item price: ");
            double price = scn.nextDouble();
            Itm.price = price;
            
            System.out.print("Enter item quantity: ");
            int quantity = scn.nextInt();
            Itm.quantity = quantity;

            Item newItem = new Item();
            newItem.itemName = itemName;
            newItem.id = id;
            newItem.price = price;
            newItem.quantity = quantity;

            System.out.println("Item added successfully.");
            System.out.println("Do you want to add more? y/n");
            String more = scn.next();
            if (more.equalsIgnoreCase("y")) {
                load = true;
            } else {
                load = false;
                break;
            }
        }
    }

    public static void deleteItem() {
        System.out.print("Enter item ID to delete: ");
        int id = scn.nextInt();

        boolean found = false;
        for (Item item : ShopSet.itemList) {
            if (item.id == id) {
            	ShopSet.itemList.remove(item);
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

    public static void changeItemPrice() {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter item ID: ");
        int itemId = scn.nextInt();
        System.out.print("Enter new item price: ");
        double newPrice = scn.nextDouble();

        for (Item item : Main.myShop.itemList) {
            if (item.id == itemId) {
                item.price = newPrice;
                System.out.println("Item price changed successfully!");
                return;
            }
        }
        System.out.println("Item not found.");
    }
    
    public String stringup() {
    	return "Item{" +
    			"id=" + id +
    			", name='" + itemName + '\'' +
    			", Price=" + price +
    			'}';
    }

    public static void reportAllItems() {
        System.out.println("Report All Items");
        System.out.println("-----------------------");
        for (Item item : Main.myShop.itemList) {
        System.out.println(item.stringup());
        }
        System.out.println("-----------------------");

        

        if (Main.myShop.itemList.isEmpty()) {
            System.out.println("No items to report.");
            return;
        }
}
    
    public int getId() {
        return id;
    }
    



	public int getPrice() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getQuantity() {
		// TODO Auto-generated method stub
		return 0;
	}



    }
    
    
    

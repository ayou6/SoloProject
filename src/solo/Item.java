package solo;

import java.util.ArrayList;
import java.util.Scanner;

public class Item {

    static Scanner scn = new Scanner(System.in);

    String itemName;
    int id;
    double price;
    int quantity;



    public void addItem() {
        boolean load = true;
        while (load) {
            System.out.print("Enter item name: ");
            String itemName = scn.next();
            System.out.print("Enter item ID: ");
            int id = scn.nextInt();
            scn.nextLine();
            System.out.print("Enter item price: ");
            double price = scn.nextDouble();
            scn.nextLine(); 
            System.out.print("Enter item quantity: ");
            int quantity = scn.nextInt();
            scn.nextLine();

            Item newItem = new Item();
            newItem.itemName = itemName;
            newItem.id = id;
            newItem.price = price;
            newItem.quantity = quantity;
            Main.Shpst.itemList.add(newItem);

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

        for (Item item : Main.Shpst.itemList) {
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
        for (Item item : Main.Shpst.itemList) {
        System.out.println(item.stringup());
        }
        System.out.println("-----------------------");

        

        if (Main.Shpst.itemList.isEmpty()) {
            System.out.println("No items to report.");
            return;
        }
}
    
    public int getId() {
        return id;
    }
    
}
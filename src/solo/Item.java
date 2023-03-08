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
    

    public void saveItems() {
    	Invoice inv = new Invoice();
    	Main.Shpst.invoiceList.add(inv);
        double total = 0;
        boolean addMoreItems = true;
        while (addMoreItems) {
            System.out.print("Enter item name: ");
            String itemName = scn.next();
            inv.itemList1.get(Main.Shpst.invoiceList.size()-1).itemName = itemName;
            System.out.print("Enter item ID: ");
            int id = scn.nextInt();
            inv.itemList1.get(Main.Shpst.invoiceList.size()-1).id = id;
            scn.nextLine();
            System.out.print("Enter item price: ");
            double price = scn.nextDouble();
            inv.itemList1.get(Main.Shpst.invoiceList.size()-1).price = price;
            scn.nextLine();
            System.out.print("Enter item quantity: ");
            int quantity = scn.nextInt();
            inv.itemList1.get(Main.Shpst.invoiceList.size()-1).quantity =quantity;

            scn.nextLine();

            Item newItem = new Item();
            newItem.itemName = itemName;
            newItem.id = id;
            newItem.price = price;
            newItem.quantity = quantity;
            Main.Shpst.itemList.add(newItem);
            double itemTotal = quantity * price;
            total += itemTotal;

            try {
                Path dirPath = Paths.get("C:\\Users\\Lenovo\\eclipse-workspace\\InvoiceSolo/Soloproject");
                if (!Files.exists(dirPath)) {
                    Files.createDirectories(dirPath);
                }
                String filePath = "C:\\Users\\Lenovo\\eclipse-workspace\\InvoiceSolo/Soloproject/invoice.txt";
                BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true));
                if (total == itemTotal) {
                    writer.write("+--------------------------------------------------------------------------+\n");
                    writer.write("|                         Dukkan Abood                                |\n");
                    writer.write("+--------------------------------------------------------------------------+\n");
                    writer.write(String.format("| %-10s | %-15s | %-15s | %-15s | %-10s |\n", "INVO NO", "Tel", "Fax", "Email", "Website"));
                    writer.write(String.format("| %-10s | %-15s | %-15s | %-15s | %-10s |\n", Main.inv.getInvoNO(), "24574", "244042", "laban@s.com", "w-394.com"));
                    writer.write("+--------------------------------------------------------------------------+\n");
                    writer.write(String.format("%-20s %-10s %-10s %-10s %-14s\n", "Item Name", "ID", "Price", "Quantity", "Total"));
                }
                writer.write(String.format("%-20s %-10d %-10.2f %-10d %-10.2f\n", itemName, id, price, quantity, itemTotal));
                writer.close();
                System.out.println("Item added successfully.");
            } catch (IOException e) {
                System.out.println("Error writing to file");
            }

            System.out.println("Do you want to add more items? y/n");
            String more = scn.next();
            if (more.equalsIgnoreCase("y")) {
                addMoreItems = true;
            } else {
                addMoreItems = false;
                try {
                    String filePath = "C:\\Users\\Lenovo\\eclipse-workspace\\InvoiceSolo/Soloproject/invoice.txt";
                    BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true));
                    writer.write(String.format("%-50s %-10.2f\n", "Total:", total));
                    writer.close();
                } catch (IOException e) {
                    System.out.println("Error writing to file");
                }
            }
        }
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
    
    
    

package solo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class ShopSet {
	String shopName;
	String email;
	String website;
	int tel;
	int fax;

	public static void ShopSet() {
		boolean shopsetLoop = true;
		while (shopsetLoop) {
			System.out.println("[1] Load Data");
			System.out.println("[2] Set Shop Name ");
			System.out.println("[3] Set Invoice Header");
			System.out.println("[4] Go Back");
			String choose = Main.scn.next();
			switch (choose) {
			case "1":
				/*
				 * Boolean Load = true; 
				 while (Load) { System.out.println("INVOICE DETAILS :");
				 * System.out.println("Enter Invoice NO: ");
				 Main.setInvoNO(Main.scn.nextInt());
				 * System.out.println("Enter Costumer Name");
				 Main.inv.setCosName(Main.scn.next());
				 * System.out.println("Enter Phone NO :");
				 Main.inv.setPhone(Main.scn.nextInt());
				 * System.out.println("No Of Items");
				 Main.inv.setNumberOfItems(Main.scn.nextInt());
				 * System.out.println("Total :");
				 Main.inv.setTotalAmount(Main.scn.nextDouble());
				 * invoiceList.add(Main.inv);
				 * System.out.println("Do you want to add more? y/n"); String more = Main.scn.next();
				 * if (more.equalsIgnoreCase("y")) { Load = true; } else { Load = false; }
				 * 
				 * }
				 */
				break;

			case "2":
				System.out.println("Enter Shop Name :");
				String shopName = Main.scn.next();
				Main.myShop.shopName = shopName;
				break;

			case "3":
				System.out.println("Shop Data :");
				System.out.println("Tel :");
				int tel = Main.scn.nextInt();
				Main.myShop.tel = tel;
				
				System.out.println("FAX:");
				Main.myShop.fax = Main.scn.nextInt();
				
				System.out.println("Email:");
				Main.myShop.email = Main.scn.next();
				
				System.out.println("Website :");
				Main.myShop.website = Main.scn.next();
				
				break;

			case "4":
				shopsetLoop = false;

				break;

			default:
				System.out.println("Invalid option. Please choose again.");
				break;
			}

		}
	}
	
	

	static ArrayList<Invoice> invoiceList = new ArrayList<>();
	static ArrayList<Item> itemList = new ArrayList<Item>();
	HashSet<String> mailList = new HashSet<String>();

	
}



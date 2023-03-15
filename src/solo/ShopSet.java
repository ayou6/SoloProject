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

	public static ShopSet settingInvoiceHeader(ShopSet shopToSet , Scanner scn) {

		System.out.println("Shop Data ");
		System.out.println("Tel :");
		int tel = scn.nextInt();
		shopToSet.tel = tel;

		System.out.println("FAX:");
		shopToSet.fax = scn.nextInt();

		System.out.println("Email:");
		shopToSet.email =scn.next();

		System.out.println("Website :");
		shopToSet.website = scn.next();
		return shopToSet;
	}

	public static void ShopSettings(Scanner scan) {

		ShopSet shop = new ShopSet();

		boolean shopsetLoop = true;
		while (shopsetLoop) {
			System.out.println("[1] Load Data");
			System.out.println("[2] Set Shop Name ");
			System.out.println("[3] Set Invoice Header");
			System.out.println("[4] Go Back");
			String choose = scan.next();
			switch (choose) {
			case "1":
				/*
				 * Boolean Load = true; while (Load) { System.out.println("INVOICE DETAILS :");
				 * System.out.println("Enter Invoice NO: "); Main.setInvoNO(Main.scn.nextInt());
				 * System.out.println("Enter Costumer Name");
				 * Main.inv.setCosName(Main.scn.next()); System.out.println("Enter Phone NO :");
				 * Main.inv.setPhone(Main.scn.nextInt()); System.out.println("No Of Items");
				 * Main.inv.setNumberOfItems(Main.scn.nextInt()); System.out.println("Total :");
				 * Main.inv.setTotalAmount(Main.scn.nextDouble()); invoiceList.add(Main.inv);
				 * System.out.println("Do you want to add more? y/n"); String more =
				 * Main.scn.next(); if (more.equalsIgnoreCase("y")) { Load = true; } else { Load
				 * = false; }
				 * 
				 * }
				 */
				break;

			case "2":
				System.out.println("Enter Shop Name :");
				String shopName = scan.next();
				shop.shopName = shopName;
				break;

			case "3":
				System.out.println("Shop Data :");
				System.out.println("Tel :");
				int tel = scan.nextInt();
				shop.tel = tel;

				System.out.println("FAX:");
				shop.fax = scan.nextInt();

				System.out.println("Email:");
				shop.email = scan.next();

				System.out.println("Website :");
				shop.website = scan.next();

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

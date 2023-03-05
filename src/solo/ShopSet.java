package solo;

import java.util.Scanner;

public class ShopSet {
	static Scanner scn = new Scanner(System.in);

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
                        System.out.println("Enter Invoice NO: ");
                        Main.inv.invoNO = scn.nextInt();
                        
                        System.out.println("Enter Costumer Name");
                        Main.inv.cosName = scn.next();
                        
                        System.out.println("Enter Phone NO :");
	                	Main.inv.phone = scn.nextInt();
	                	
	                	System.out.println("No Of Items");
	                	Main.inv.numberOfItems = scn.nextInt();
	                	
	                	System.out.println("Total :");
	                	Main.inv.totalAmount = scn.nextDouble();
	                	
                        Main.inv.invoiceList.add(Main.inv);
                        
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
  }
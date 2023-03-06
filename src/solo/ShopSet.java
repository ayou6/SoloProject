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
	                	Boolean Load = true;
                        while (Load) {
	                	System.out.println("INVOICE DETAILS :");
	                	
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
                        System.out.println("Do you want to add more? y/n");
                        String more = scn.next();
                        if (more.equalsIgnoreCase("y")) {
                        	 Load = true;
                        } else {
                            Load = false;
   }
                        	
    }
	                    break;
	                    
	                case "2":
	                	System.out.println("Enter Shop Name :");
	                	Main.shop.shopName = scn.next();
	                	break;
	                	
	                case "3":
	                	System.out.println("Shop Data :");
	                	System.out.println("Tel :");
	                	Main.shop.tel = scn.nextInt();
	                	System.err.println("FAX:");
	                	Main.shop.fax = scn.nextInt();
	                	System.out.println("Email:");
	                	Main.shop.email = scn.next();
	                	System.out.println("Website :");
	                	Main.shop.website = scn.next();
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

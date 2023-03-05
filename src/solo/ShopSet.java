package solo;


public class ShopSet {


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
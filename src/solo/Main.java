package solo;

import java.util.Scanner;

public class Main {
	static Scanner scn = new Scanner(System.in);
	static Menu Mainmenu = new Menu();
	static ShopSet Shpst = new ShopSet();
	static Item Itm = new Item();
	static Shop shop = new Shop();
	static Invoice inv = new Invoice();
	
	public static void main(String[] args) {
	        String choose = Main.scn.next();
			
	        switch (choose) {
	        case "1":
	        	ShopSet.ShopSet();
                break;
                
            case "2":
            	Mainmenu.Menu2();
            	break;
            	
            case "3":
            	
            	
            	break;
            	
            case "4":
            	
            	break;
            	
            case "5":
            	
            	break;
            case "6":
            	
            	break;
            	
            case "7":
            	
            	break;
            	
            case "8":
                break;

                default:
                System.out.println("Invalid option. Please choose again.");
                break;	

        	}
        }      
	}

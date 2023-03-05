package solo;

import java.util.Scanner;

public class Main {
	static Scanner scn = new Scanner(System.in);
	public static void main(String[] args) {
	        String choose = Main.scn.next();
			Menu Mainmenu = new Menu();
			ShopSet Shpst = new ShopSet();
			
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

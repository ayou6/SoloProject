package solo;

public class Menu {
	
	public void Menu() {
		System.out.println(" -----------");
		System.out.println("| Main Menu |");
		System.out.println(" -----------");
		System.out.println("[1] Shop Settings");
		System.out.println("[2] Manage Shop Items");
		System.out.println("[3] Create New Invoice");
		System.out.println("[4] Report: Statistics ");
		System.out.println("[5] Report: All Invoices");
		System.out.println("[6] Search");
		System.out.println("[7] Program Statistics");
		System.out.println("[8] Exit");

	}

public void Menu2() {
	Boolean Load = true;
	    while (Load) {
	        System.out.println(" -----------");
	        System.out.println("| Manage Shop items |");
	        System.out.println(" -----------");
	        System.out.println("[1] add");
	        System.out.println("[2] delete");
	        System.out.println("[3] change price");
	        System.out.println("[4] Report");
	        System.out.println("[5] Go Back");
	        String choose = Main.scn.next();
	        switch (choose) {
	            case "1":
	                Main.Itm.addItem();
	                break;
	            case "2":
	                Main.Itm.deleteItem();
	                break;
	            case "3":
	                Main.Itm.changeItemPrice();
	                break;
	            case "4":
	                Main.Itm.reportAllItems();
	                break;
	            case "5":
	                System.out.println("Good Bye!!!");
	                Load = false;
	                break;
	            default:
	                System.out.println("Invalid option. Please choose again.");
	                break;
	        }
	    }
	}


}

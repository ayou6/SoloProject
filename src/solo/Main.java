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
		int cntStat1 = 0;
		int cntStat2 = 0;
		int cntStat3 = 0;
		int cntStat4 = 0;
		int cntStat5 = 0;
		int cntStat6 = 0;
		int cntStat7 = 0;
		int cntStat8 = 0;
		boolean loop = false;
		while (loop == false) {
		Mainmenu.Menu();
	        String choose = Main.scn.next();
			
	        switch (choose) {
	        case "1":
				cntStat1++;

	        	ShopSet.ShopSet();
                break;
                
            case "2":
        		cntStat2++;

            	Mainmenu.Menu2();
            	
            	break;
            	
            case "3":
                cntStat3++;

               
                    System.out.println("Add Invoice!");
                    
                    System.out.println("Enter Invoice NO: ");
                    inv.setInvoNO(scn.nextInt());
                    Itm.saveItem();
                    
                   /* 	
                     System.out.println("+--------------------------------------------------------------------------+");
                     System.out.println("|                         INVOICE DETAILS                   |");
                     System.out.println("+--------------------------------------------------------------------------+");
                     System.out.printf("| %-10s | %-15s | %-15s | %-15s | %-10s |\n", "INVO NO", "Tel", "Fax", "Email", "Website");
                     System.out.printf("| %-10s | %-15s | %-15s | %-15s | %-10s |\n", Main.inv.getInvoNO(), "24574", "244042", "laban@s.com", "w-394.com");
                     System.out.println("+---------------------------------------------------------------------------+");
                     for (int i = 0; i < Main.Shpst.invoiceList.size(); i++) {
                     System.out.printf("| %-10d | %-15d | %-15d | %-15s | %-10s |\n", Main.Shpst.invoiceList.get(i).getInvoNO(),
                     Main.Shpst.invoiceList.get(i).getPhone(), Main.Shpst.invoiceList.get(i).getFax(),
                     Main.Shpst.invoiceList.get(i).getEmail(), Main.Shpst.invoiceList.get(i).getWeb());
                        }
                     System.out.println("+-----------------------------------------------------------+");
                    */

                
                break;

            	
            case "4":
        		cntStat4++;
        
            	break;
            	
            case "5":
        		cntStat5++;
            	break;
            case "6":
            	cntStat6++;
            	/*{
				int x = 0;
				boolean loop1 = true;
				while (loop1) {
					System.out.println("Enter Invoice NO: ");
					int searchInvo = scn.nextInt();
					for (int i = 0; i < Main.inv.invoiceList.size(); i++) {
						if (Main.inv.invoNO.equal(searchInvo))
							System.out.println("School Name: " + mySchool.name);
							System.out.println("Student Name:" + mySchool.studentList.get(i).stuName);
							for (int j = 0; j < mySchool.subjectList.size(); j++) {
								System.out.println(mySchool.subjectList.get(j) + " mark is: "
										+ mySchool.studentList.get(i).studentSubjectList.get(j).studentMark.mark);
							}
							x = x + 1;
						}
					}
					if (x == 0) {
						System.out.println("NOT FOUND!!!");
			}
				}*/
				break;

            	
            case "7":
                cntStat7++;
                System.out.println("[1] Shop Settings " + cntStat1);
                System.out.println("[2] Manage Shop Items " + cntStat2);
                System.out.println("[3] Create New Invoice " + cntStat3);
                System.out.println("[4] Report: Statistics " + cntStat4);
                System.out.println("[5] Report: All Invoices " + cntStat5);
                System.out.println("[6] Search " + cntStat6);
                System.out.println("[7] Program Statistics " + cntStat7);
                System.out.println("[8] Exit " + cntStat8);
                break;

            	
            case "8":
            	cntStat8++;
                System.out.print("Are you sure you want to exit? (Y/N): ");
                String confirm = scn.next();
                if (confirm.equalsIgnoreCase("Y")) {
                loop = true;
           }

                break;


            default:
            	System.out.println("Invalid option. Please choose again.");
            	break;	
        	}
        }      
		System.out.println("Good Bye!!!");
	}
}

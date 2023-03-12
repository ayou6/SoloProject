package solo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
	static Scanner scn = new Scanner(System.in);
	static Menu Mainmenu = new Menu();
	static ShopSet Shpst = new ShopSet();
	static Item Itm = new Item();
	static Shop myShop = new Shop();
	

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

				Invoice newInvoice = new Invoice(0,0,null,null, 0,0,0);
				System.out.println("Add Invoice!");
				
				System.out.println("Enter Invoice NO: ");
                newInvoice.setInvoNO(scn.nextInt());
                System.out.println("Enter Costumer Name:");
                newInvoice.setCosName(scn.next());
                System.out.println("Enter Phone No:");
                newInvoice.setPhone(scn.nextInt());
                LocalDate Invoicedate = LocalDate.now();
                newInvoice.setDate(Invoicedate);

                myShop.invoiceList.add(newInvoice);
                
                
		        



				
				

				break;

			case "4":
				cntStat4++;
				

				break;

			case "5":
				cntStat5++;
				break;
			case "6":
				cntStat6++;
				/*
				 * { int x = 0; boolean loop1 = true; while (loop1) {
				 * System.out.println("Enter Invoice NO: "); int searchInvo = scn.nextInt(); for
				 * (int i = 0; i < Main.inv.invoiceList.size(); i++) { if
				 * (Main.inv.invoNO.equal(searchInvo)) System.out.println("School Name: " +
				 * mySchool.name); System.out.println("Student Name:" +
				 * mySchool.studentList.get(i).stuName); for (int j = 0; j <
				 * mySchool.subjectList.size(); j++) {
				 * System.out.println(mySchool.subjectList.get(j) + " mark is: " +
				 * mySchool.studentList.get(i).studentSubjectList.get(j).studentMark.mark); } x
				 * = x + 1; } } if (x == 0) { System.out.println("NOT FOUND!!!"); } }
				 */
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

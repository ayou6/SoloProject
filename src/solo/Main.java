package solo;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
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
			String choose = scn.next();

			switch (choose) {
			case "1":
				cntStat1++;

				ShopSet.ShopSettings(scn);
				break;

			case "2":
				cntStat2++;

				Mainmenu.Menu2();

				break;

			case "3":
				cntStat3++;

				Invoice newInvoice = new Invoice();
				myShop.invoiceList.add(newInvoice);

				System.out.println("Add Invoice!");

				System.out.println("Enter Invoice NO: ");
				newInvoice.setInvoNO(scn.nextInt());
				System.out.println("Enter Customer Name:");
				newInvoice.setCosName(scn.next());
				System.out.println("Enter Phone No:");
				newInvoice.setPhone(scn.nextInt());
				LocalDate invoiceDate = LocalDate.now();
				newInvoice.setDate(invoiceDate);

				if (myShop.itemList.isEmpty()) {
					System.out.println("Add some items first!!");
				} else {
					boolean doneAddingItems = false;
					while (!doneAddingItems) {
						System.out.println("Choose an item from the list:");
						for (int i = 0; i < Main.myShop.itemList.size(); i++) {
							System.out.println(i + 1 + ") " + Main.myShop.itemList.get(i).itemName);
						}
						int itemNo = scn.nextInt() - 1;
						if (itemNo < 0 || itemNo >= Main.myShop.itemList.size()) {
							System.out.println("Invalid choice!");
							continue;
						}
						newInvoice.itemList1.add(myShop.itemList.get(itemNo));
						newInvoice.itemList1.get(itemNo).price = myShop.itemList.get(itemNo).price;
						System.out.println("Enter item quantity: ");
						int quantity = scn.nextInt();
						newInvoice.itemList1.get(itemNo).quantity = quantity;
						double total = newInvoice.itemList1.get(itemNo).quantity
								* newInvoice.itemList1.get(itemNo).price;
						newInvoice.itemList1.get(itemNo).qty = total;

						System.out.println("Do you want to add more items? (Y/N)");
						String answer = scn.next();
						doneAddingItems = answer.equalsIgnoreCase("N");
					}

					System.out.println("Invoice created and added to the list!");
					System.out.println("=================================");

					System.out.println(
							"+=====================================================================================+");
					System.out.println("| |                                       " + Shpst.shopName
							+ "                                             |");
					System.out.println(
							"+--------------------------------------------------------------------------------------+");
					System.out.println("| | email: " + Shpst.email + " | fax: " + Shpst.fax + " | web: "
							+ Shpst.website + " |");
					System.out.println("| | " + newInvoice.getDate() + " | " + newInvoice.getInvoNO() + " | "
							+ newInvoice.getCosName() + " |");
					System.out.println(
							"+=========================================================================================+");
					System.out.println("| Items |");
					double total = 0;
					for (int i = 0; i < newInvoice.itemList1.size(); i++) {
						System.out.println("| | | | | " + newInvoice.itemList1.get(i).itemName + " |"
								+ newInvoice.itemList1.get(i).quantity);
						total = total + newInvoice.itemList1.get(i).qty;
					}
					System.out.println("| | | | |");
					System.out.println("| | | | |");
					System.out.println("| | |");
					System.out.println("| Total: R.O " + total + " |");
					System.out.println(
							"+=========================================================================================+");
					FileOutputStream fos = null;
					try {
						fos = new FileOutputStream("invoices.txt", true);
						String data = "=================================\n"
								+ "+=====================================================================================+\n"
								+ "| |                                       " + Shpst.shopName
								+ "                                             |\n"
								+ "+--------------------------------------------------------------------------------------+\n"
								+ "| | email: " + Shpst.email + " | fax: " + Shpst.fax + " | web: " + Shpst.website
								+ " |\n" + "| | " + newInvoice.getDate() + " | " + newInvoice.getInvoNO() + " | "
								+ newInvoice.getCosName() + " |\n"
								+ "+=========================================================================================+\n"
								+ "| Items |\n";
						double total1 = 0;
						for (int i = 0; i < newInvoice.itemList1.size(); i++) {
							data += "| | | | | " + newInvoice.itemList1.get(i).itemName + " |"
									+ newInvoice.itemList1.get(i).quantity + "\n";
							total1 = total1 + newInvoice.itemList1.get(i).qty;
						}
						data += "| | | | |\n" + "| | | | |\n" + "| | |\n" + "| Total: R.O " + total1 + " |\n"
								+ "+=========================================================================================+\n";
						fos.write(data.getBytes());
						System.out.println("Successfully wrote to the file.");
					} catch (IOException e) {
						System.out.println("An error occurred.");
						e.printStackTrace();
					} finally {
						if (fos != null) {
							try {
								fos.close();
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
					}

				}

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

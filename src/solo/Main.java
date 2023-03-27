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
	static JDBC jdbc = new JDBC();

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
						int itemNo = scn.nextInt();
						itemNo = itemNo - 1;
						if (itemNo < 0 || itemNo >= Main.myShop.itemList.size()) {
							System.out.println("Invalid choice!");
							continue;
						}
						newInvoice.itemList1.add(myShop.itemList.get(itemNo));
						newInvoice.itemList1.get(newInvoice.itemList1.size() - 1).price = myShop.itemList
								.get(itemNo).price;
						System.out.println("Enter item quantity: ");
						int quantity = scn.nextInt();
						newInvoice.itemList1.get(newInvoice.itemList1.size() - 1).quantity = quantity;
						double total = newInvoice.itemList1.get(newInvoice.itemList1.size() - 1).quantity
								* newInvoice.itemList1.get(newInvoice.itemList1.size() - 1).price;
						newInvoice.itemList1.get(newInvoice.itemList1.size() - 1).qty = total;

						System.out.println("Do you want to add more items? (Y/N)");
						String answer = scn.next();
						doneAddingItems = answer.equalsIgnoreCase("N");
					}
					Serielized srzld = new Serielized();
					Serielized.saveInvoicesSerialized();
					System.out.println("Invoice created and added to the list!");
					System.out.println("=================================");

					System.out.println(
							"+=====================================================================================+");
					System.out.println("| |                                       " + ShopSet.headerList.get(0).shopName
							+ "                                             |");
					System.out.println(
							"+--------------------------------------------------------------------------------------+");
					System.out.println("| | email: " + ShopSet.headerList.get(0).email + " | fax: "
							+ ShopSet.headerList.get(0).fax + " | web: " + ShopSet.headerList.get(0).website + " |");
					System.out.println("| | " + newInvoice.getDate() + " | " + newInvoice.getInvoNO() + " | "
							+ newInvoice.getCosName() + " |");
					System.out.println(
							"+=========================================================================================+");
					System.out.println("| Items |");
					double total = 0;
					for (int i = 0; i < newInvoice.itemList1.size() - 1; i++) {
						System.out.println("| | | | | " + newInvoice.itemList1.get(i).itemName + " |"
								+ newInvoice.itemList1.get(i).quantity);
						total = total + newInvoice.itemList1.get(i).qty;
					}
					newInvoice.setTotalAmount(total);
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
								+ "| |                                       " + ShopSet.headerList.get(0).shopName
								+ "                                             |\n"
								+ "+--------------------------------------------------------------------------------------+\n"
								+ "| | email: " + ShopSet.headerList.get(0).email + " | fax: "
								+ ShopSet.headerList.get(0).fax + " | web: " + ShopSet.headerList.get(0).website
								+ " |\n" + "| | " + newInvoice.getDate() + " | " + newInvoice.getInvoNO() + " | "
								+ newInvoice.getCosName() + " |\n"
								+ "+=========================================================================================+\n"
								+ "| Items |\n";
						double total1 = 0;
						for (int i = 0; i < newInvoice.itemList1.size() - 1; i++) {
							data += "| | | | | " + newInvoice.itemList1.get(i).itemName + " |"
									+ newInvoice.itemList1.get(i).quantity + "\n";
							total1 = total1 + newInvoice.itemList1.get(i).qty;
						}
						data += "| | | | |\n" + "| | | | |\n" + "| | |\n" + "| Total: R.O " + total + " |\n"
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

				} // JDBC.createInvoiceTable();
				JDBC.inseartInvoices();

				break;

			case "4":
				cntStat4++;
				myShop.generateStatisticsReport();
				break;

			case "5":
				cntStat5++;

				System.out.println("All Invoices:");
				for (int i = 0; i < myShop.invoiceList.size(); i++) {

					System.out.println("=================================");

					System.out.println(
							"+=====================================================================================+");
					System.out.println("| |                                       " + ShopSet.headerList.get(i).shopName
							+ "                                             |");
					System.out.println(
							"+--------------------------------------------------------------------------------------+");
					System.out.println("| | email: " + ShopSet.headerList.get(i).email + " | fax: "
							+ ShopSet.headerList.get(i).fax + " | web: " + ShopSet.headerList.get(i).website + " |");
					System.out.println(
							"| | " + myShop.invoiceList.get(i).getDate() + " | " + myShop.invoiceList.get(i).getInvoNO()
									+ " | " + myShop.invoiceList.get(i).getCosName() + " |");
					System.out.println(
							"+=========================================================================================+");
					System.out.println("| Items |");
					double total = 0;
					for (int j = 0; j < myShop.invoiceList.get(i).itemList1.size(); j++) {
						System.out.println("| | | | | " + myShop.invoiceList.get(i).itemList1.get(j).itemName + " |"
								+ myShop.invoiceList.get(i).itemList1.get(j).quantity);
						total = total + myShop.invoiceList.get(i).itemList1.get(j).qty;
					}
					System.out.println("| | | | |");
					System.out.println("| | | | |");
					System.out.println("| | |");
					System.out.println("| Total: R.O " + total + " |");
					System.out.println(
							"+=========================================================================================+");

				}

				break;
			case "6":
				cntStat6++;

				System.out.println("Enter Invoice NO: ");
				int searchInvo = scn.nextInt();

				boolean found = false;

				for (int i = 0; i < myShop.invoiceList.size(); i++) {
					Invoice invoice = myShop.invoiceList.get(i);

					if (invoice.getInvoNO() == searchInvo) {

						System.out.println("=================================");
						System.out.println(
								"+=====================================================================================+");
						System.out.println(
								"| |                                       " + ShopSet.headerList.get(i).shopName
										+ "                                             |");
						System.out.println(
								"+--------------------------------------------------------------------------------------+");
						System.out.println("| | email: " + ShopSet.headerList.get(i).email + " | fax: "
								+ ShopSet.headerList.get(i).fax + " | web: " + ShopSet.headerList.get(i).website
								+ " |");
						System.out.println("| | " + invoice.getDate() + " | " + invoice.getInvoNO() + " | "
								+ invoice.getCosName() + " |");
						System.out.println(
								"+=========================================================================================+");
						System.out.println("| Items |");
						double total = 0;
						for (int j = 0; j < invoice.itemList1.size(); j++) {
							System.out.println("| | | | | " + invoice.itemList1.get(j).itemName + " |"
									+ invoice.itemList1.get(j).quantity);
							total = total + invoice.itemList1.get(j).qty;
						}
						System.out.println("| | | | |");
						System.out.println("| | | | |");
						System.out.println("| | |");
						System.out.println("| Total: R.O " + total + " |");
						System.out.println(
								"+=========================================================================================+");

						found = true;

						break;
					}
				}

				if (!found) {
					System.out.println("NOT FOUND!!!");
				}

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

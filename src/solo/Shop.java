package solo;

import java.util.ArrayList;
import java.util.HashSet;

public class Shop {
	String shopName;
	String email;
	String website;
    int tel;
    int fax;
    ArrayList<Item>  itemList = new ArrayList<Item>();
    ArrayList<Invoice>  invoiceList = new ArrayList<Invoice>();
    
    public String generateStatisticsReport() {

        int numOfItems =itemList.size();
        int numOfInvoices =invoiceList.size();
        double sumSales = 0;
        
        for(int i = 0; i < invoiceList.size(); i++) {
            sumSales = sumSales + invoiceList.get(i).getTotalAmount();
        }
        
        System.out.println("Statistics Report:");
        System.out.println("Total Items: " + numOfItems);
        System.out.println("Total Invoices: " + numOfInvoices);
        System.out.println("Total Sales: R.O " + sumSales);
		return null;
    }
}
	


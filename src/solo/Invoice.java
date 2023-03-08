package solo;
import java.util.ArrayList;

public class Invoice {
    private int invoNO;
    private int phone;
    private double totalAmount;
    private double balance;
    private String cosName;
    private String date;
    private String email;
	private double paid;
	public ArrayList<Item> itemList1;


    public int getInvoNO() {
        return invoNO;
    }

    public void setInvoNO(int invoNO) {
        this.invoNO = invoNO;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCosName() {
        return cosName;
    }

    public void setCosName(String cosName) {
        this.cosName = cosName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    /*public ArrayList<Invoice> getInvoiceList() {
        return getInvoiceList();
    }

    public void setInvoiceList(ArrayList<Invoice> invoiceList) {
        this.invoiceList = invoiceList;
    }
    
    String statisticsReport = generateStatisticsReport();
    public String generateStatisticsReport() {
        int totalItems = 0;
        int totalInvoices = 0;
        double totalSales = 0;

        for (Invoice invoice : Main.Shpst.invoiceList) {
            totalInvoices++;
            for (Item item : Main.inv.getNumberOfItems()) {
                totalItems += item.getQuantity();
                totalSales += item.getPrice() * item.getQuantity();
            }
        }

        System.out.println("Statistics Report:");
        System.out.println("Total Items: " + totalItems);
        System.out.println("Total Invoices: " + totalInvoices);
        System.out.println("Total Sales: $" + totalSales);
    }*/

	public double getPaid() {
		return paid;
	}

	public void setPaid(double paid) {
		this.paid = paid;
	}


}

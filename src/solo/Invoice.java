package solo;
import java.time.LocalDate;
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
	private ArrayList<Invoice> invoiceList;
	
    public Invoice( int invoNO ,int phone,LocalDate invoiceDate, 
			ArrayList<Item> itemList1, double totalAmount, double paid, double balance) {
    	this.invoNO = invoNO;
		this.cosName = cosName;
		this.phone = phone;
		this.date = date;
		this.itemList1 = itemList1;
		this.totalAmount = totalAmount;
		this.paid = paid;
		this.balance = balance; 
	}


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
    
    public ArrayList<Invoice> getInvoiceList() {
        return getInvoiceList();
    }

    public void setInvoiceList(ArrayList<Invoice> invoiceList) {
        this.invoiceList = invoiceList;
    }
    
    public String generateStatisticsReport() {
        int totalItems = 0;
        int totalInvoices = 0;
        double totalSales = 0;
        
        int numOfItems = Main.myShop.itemList.size();
        int numOfInvoices = Main.myShop.invoiceList.size();

        

        System.out.println("Statistics Report:");
        System.out.println("Total Items: " + totalItems);
        System.out.println("Total Invoices: " + totalInvoices);
        System.out.println("Total Sales: $" + totalSales);
		return null;
    }

	public double getPaid() {
		return paid;
	}

	public void setPaid(double paid) {
		this.paid = paid;
	}


}

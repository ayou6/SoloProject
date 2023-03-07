package solo;
import java.util.ArrayList;

public class Invoice {
    private int invoNO;
    private int phone;
    private int numberOfItems;
    private double totalAmount;
    private double balance;
    private String cosName;
    private String date;
    private String email;
    private int fax;
    private String website;


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

    public int getNumberOfItems() {
        return numberOfItems;
    }

    public void setNumberOfItems(int numberOfItems) {
        this.numberOfItems = numberOfItems;
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
    
    public int getFax() {
        return fax;
    }
    
    public String getWeb() {
        return website;
    }

    public ArrayList<Invoice> getInvoiceList() {
        return invoiceList;
    }

    public void setInvoiceList(ArrayList<Invoice> invoiceList) {
        this.invoiceList = invoiceList;
    }
}

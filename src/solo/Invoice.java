package solo;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Invoice {
    private int invoNO;
    private int phone;
    private double totalAmount = 0;
    private double balance;
    private String cosName;
    private LocalDate date;
    private String email;
	private double paid;
	public List<Item> itemList1 = new ArrayList <Item> ();
	
   

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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate invoicedate) {
        this.date = invoicedate;
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



        

        



	public double getPaid() {
		return paid;
	}

	public void setPaid(double paid) {
		this.paid = paid;
	}


}

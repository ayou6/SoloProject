package solo;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBC {

	public static boolean createShopTable() {

	    String url = "jdbc:sqlserver://localhost:1433;" + "databaseName=myShop;" + "encrypt=true;"
	        + "trustServerCertificate=true";
	    String user = "sa";
	    String pass = "root";

	    String tableName = "Shop_Details";
	    String sql = "CREATE TABLE " + tableName + " "
	        + "(Shop_Name text , "
	        + " Email VARCHAR(50) NOT NULL, "
	        + " Tel int NOT NULL,"
	        + " Website VARCHAR(50) NOT NULL, "
	        + " FAX int NOT NULL );";
	    Connection conn = null;
	    try {
	        Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
	        DriverManager.registerDriver(driver);
	        conn = DriverManager.getConnection(url, user, pass);
	        Statement st = conn.createStatement();

	        // Check if the table already exists
	        DatabaseMetaData dbm = conn.getMetaData();
	        ResultSet tables = dbm.getTables(null, null, tableName, null);
	        if (tables.next()) {
	            System.out.println("Table " + tableName + " already exists in the database.");
	            return false;
	        }

	        // Create the table if it does not exist
	        int m = st.executeUpdate(sql);
	        if (m >= 1) {
	            System.out.println("Created table " + tableName + " in given database...");
	            return true;
	        }
	        conn.close();
	    } catch (Exception ex) {
	        System.err.println(ex);
	    }

	    return false;
	}

	public static boolean createItemTable() {

		String url = "jdbc:sqlserver://localhost:1433;" 
				+ "databaseName=myShop;" 
				+ "encrypt=true;"
				+ "trustServerCertificate=true";
		String user = "sa";
		String pass = "root";

	String sql1 = "CREATE TABLE Item_List " 
	             + "(itemName nvarchar(50) , " 
	             + " quantity int, "
	             + " price decimal(10,2), "
	             + " id int );";
		Connection conn = null;
		try {
			Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			DriverManager.registerDriver(driver);
			conn = DriverManager.getConnection(url, user, pass);
			Statement st = conn.createStatement();
			int m = st.executeUpdate(sql1);
			if (m >= 1) {
				System.out.println("Created table in given database...");
				return true;
			} else {
				System.out.println(" table already Created in given database...");
			}
			conn.close();
		} catch (Exception ex) {
			System.err.println(ex);
		}
 
		return false;
	}

	public static boolean createInvoiceTable() {

		String url = "jdbc:sqlserver://localhost:1433;" 
				+ "databaseName=myShop;" 
				+ "encrypt=true;"
				+ "trustServerCertificate=true";
		String user = "sa";
		String pass = "root";

		String sql2 = "CREATE TABLE Invoice_List " 
	             + "(shopName text, " 
	             + "(invoNo int , " 
	             + " Email VARCHAR(50) NOT NULL, "
	             + " phone int NOT NULL, " 
	             + " cosName nvarchar(50) NOT NULL, " 
	             + " date int NOT NULL, " 
	             + " totalAmount decimal(10,2) NOT NULL " 
	             + ");";
		Connection conn = null;
		try {
			Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			DriverManager.registerDriver(driver);
			conn = DriverManager.getConnection(url, user, pass);
			Statement st = conn.createStatement();
			int m = st.executeUpdate(sql2);
			if (m >= 1) {
				System.out.println("Created table in given database...");
				return true;
			} else {
				System.out.println(" table already Created in given database...");
			}
			conn.close();
		} catch (Exception ex) {
			System.err.println(ex);
		}
	 
		return false;
	}
	public static void insertIntoItems() {
       String insertQuery = "INSERT INTO Item_List (itemName,quantity, price,id) VALUES (?, ?, ?,?)";

			try (Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;" + "databaseName=myShop;" + "encrypt=true;"
					+ "trustServerCertificate=true", "sa", "root");
					PreparedStatement stmt = conn.prepareStatement(insertQuery)
					) {
				//Random rn = new Random();

				for (int i = 0; i < Main.myShop.itemList.size(); i++) {

				stmt.setString(1, Main.myShop.itemList.get(i).itemName);
				stmt.setDouble(2, Main.myShop.itemList.get(i).quantity);
				stmt.setDouble(3, Main.myShop.itemList.get(i).price);
				stmt.setInt   (4, Main.myShop.itemList.get(i).getId());
				
				stmt.addBatch();
				
				}

				int[] results = stmt.executeBatch();
				System.out.println("Inserted " + results.length + " rows into items table.");
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		
	}
	
	public static void truncateFromItems() {
        String insertQuery = "truncate table Item_List";

			try (Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;" + "databaseName=myShop;" + "encrypt=true;"
					+ "trustServerCertificate=true", "sa", "root");
					PreparedStatement stmt = conn.prepareStatement(insertQuery)
					) {

				int results = stmt.executeUpdate();
				System.out.println(results + " Item_List table truncated.");
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		
	}
	
	public static void deleteFromItems() {

        String insertQuery = "delete from Item_List where id like " + Item.deleteItem();

			try (Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;" + "databaseName=myShop;" + "encrypt=true;"
					+ "trustServerCertificate=true", "sa", "root");
					PreparedStatement stmt = conn.prepareStatement(insertQuery)
					) {

				int results = stmt.executeUpdate();
				System.out.println(results + " Item_List table truncated.");
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		
	}
	
	public static void inseartInvoices() {
		String insertQuery = "insert into invoices (shopName ,invoNo , Email , phone , cosName , date , totalAmount) VALUES (?,?,?,?,?,?,?);";

		try (Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;" + "databaseName=myShop;" + "encrypt=true;"
				+ "trustServerCertificate=true", "sa", "root");
				PreparedStatement stmt = conn.prepareStatement(insertQuery)
				) {
			for( int i = 0 ; i<Main.myShop.invoiceList.size(); i++) {
				stmt.setString  (1,ShopSet.headerList.get(0).shopName);
				stmt.setInt		(2,Main.myShop.invoiceList.get(i).getInvoNO());
				stmt.setString	(3,Main.myShop.invoiceList.get(i).getEmail());
				stmt.setInt		(4,Main.myShop.invoiceList.get(i).getPhone());
				stmt.setString  (5,Main.myShop.invoiceList.get(i).getCosName());
				stmt.setString	(6,Main.myShop.invoiceList.get(i).getDate().toString());
				stmt.setDouble	(7,Main.myShop.invoiceList.get(i).getTotalAmount());
				stmt.addBatch();
			}
			int[] results = stmt.executeBatch();
			System.out.println("Inserted " + results.length + " rows into Invoices table.");		}
		catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	
	public static boolean insertShopDetails() {
	    String url = "jdbc:sqlserver://localhost:1433;" + "databaseName=myShop;" + "encrypt=true;"
	            + "trustServerCertificate=true";
	    String user = "sa";
	    String pass = "root";

	    String myShop = "Shop_Details";
	    String sql = "INSERT INTO " + myShop + " (Shop_Name, Email, Tel, Website, FAX) "
	            + "VALUES (?, ?, ?, ?, ?);";
	    Connection conn = null;
	    try {
	        Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
	        DriverManager.registerDriver(driver);
	        conn = DriverManager.getConnection(url, user, pass);
	        PreparedStatement ps = conn.prepareStatement(sql);
	        ps.setString(1, ShopSet.headerList.get(0).shopName);
	        ps.setString(2, ShopSet.headerList.get(0).email);
	        ps.setInt(3, ShopSet.headerList.get(0).tel);
	        ps.setString(4, ShopSet.headerList.get(0).website);
	        ps.setInt(5, ShopSet.headerList.get(0).fax);
	        int m = ps.executeUpdate();
	        if (m >= 1) {
	            System.out.println("Inserted record into " + myShop + " table...");
	            return true;
	        }
	        conn.close();
	    } catch (Exception ex) {
	        System.err.println(ex);
	    }

	    return false;
	}
	
}

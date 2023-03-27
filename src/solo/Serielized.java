package solo;
/*
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import com.google.gson.Gson;+++
*/
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Serielized implements Serializable {
 
	 static void saveItemsSerialized()
{
		Shop myShop = new Shop();
		 try{
		       FileOutputStream file = new FileOutputStream("ItemList.txt");
		       ObjectOutputStream out = new ObjectOutputStream(file);
		       
		       out.writeObject(myShop.itemList);
		       
		       out.close();
		       file.close();
		       System.out.println("serialized and saved");

		   }catch (Exception e){
		     e.printStackTrace();

		   }
}
	 
	 static void saveInvoicesSerialized()
	 {
	 		Shop myShop = new Shop();
	 		 try{
	 		       FileOutputStream file = new FileOutputStream("Invoicess.txt");
	 		       ObjectOutputStream out = new ObjectOutputStream(file);
	 		       
	 		       out.writeObject(myShop.invoiceList);
	 		       
	 		       out.close();
	 		       file.close();
	 		       System.out.println("serialized and saved");

	 		   }catch (Exception e){
	 		     e.printStackTrace();

	 		   }
	 }

}

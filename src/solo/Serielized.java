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
 
	private static void saveItemsSerialized(ArrayList<Serielized> items)
{
		 try {
		 FileOutputStream fos = new FileOutputStream("items.txt");
		 ObjectOutputStream oos = new ObjectOutputStream(fos);
		 oos.writeObject(items);
		 oos.close();
		 fos.close();
		 System.out.println("Items saved(serialized) successfully.");
		 }
		 catch (IOException ioe) {
		 ioe.printStackTrace();
	  }
		 /*
   }
	

		    
		    public static void main(String[] args) {
		        String apiUrl = "https://example.com/api/endpoint";
		        try {
		            URL url = new URL(apiUrl);
		            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		            conn.setRequestMethod("GET");
		            conn.setRequestProperty("Accept", "application/json");
		            
		            if (conn.getResponseCode() != 200) {
		                throw new RuntimeException("HTTP error code : " + conn.getResponseCode());
		            }
		            
		            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
		            String output;
		            StringBuilder json = new StringBuilder();
		            
		            while ((output = br.readLine()) != null) {
		                json.append(output);
		            }
		            
		            conn.disconnect();
		            
		            Gson gson = new Gson();
		            MyObject myObj = gson.fromJson(json.toString(), MyObject.class);
		            
		            // Use myObj for further processing
		            
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		    }
		}

		class MyObject {
		    // Define your object properties here
	}*/
		 
		 
		}

}

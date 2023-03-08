package solo;

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
   }

}

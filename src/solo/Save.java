

import java.io.*;

public class Save {

	public static void saveData() {
		try {
			FileWriter writer = new FileWriter("Transcript1.txt", true);
			writer.write(String.format("%20s %20s %20s %20s %20s\n", "Shop Name", "Invoice no", "Subject name",
					"Mark", "Email"));
			writer.write(
					"_____________________________________________________________________________________________________________________\n");
			for (int i = 0; i < Main.Itm.itemList.size(); i++) {
				for (int j = 0; j < Main.Itm.itemList.size(); j++) {
					writer.write(String.format("%20s %20s %20s %20s %20s\n", Main.shop.shopName,
							Main.shop.mailList.get(i).mailList));
				}
				writer.write(
						"_____________________________________________________________________________________________________________________\n");
			}
			writer.close();
			System.out.println("DATA SAVED!");
		} catch (Exception e) {
			System.out.println("ERROR!!!!");
			e.printStackTrace();
		}
	}
}


package solo;
import java.io.File;
import java.io.FileWriter;

public class Save {

	public static void saveDataFolder() {
		File newFolder = new File("C:\\Users\\Lenovo\\Documents\\Invoices");
		if (!newFolder.exists()) {
			newFolder.mkdirs();
		}

		File file = new File("C:\\Users\\Lenovo\\Documents\\Invoices\\invoice.txt");
		try {
			FileWriter writer = new FileWriter(file, true);
			writer.write(String.format("%20s %20s %20s %20s %20s\n", "Shop Name", "Tel", "Fax",
					"Email", "Email"));
			writer.write(
					"_____________________________________________________________________________________________________________________\n");
			for (int i = 0; i < Main.Itm.itemList.size(); i++) {
				for (int j = 0; j < Main.Itm.itemList.size(); j++) {
					writer.write(String.format("%20s %20s %20s %20s %20s\n", Main.shop.shopName,
							Main.shop.tel;

				}
				writer.write(
						"_____________________________________________________________________________________________________________________\n");
			}
			writer.close();
			System.out.println("Sucessfully Created");
		} catch (Exception e) {
			System.out.println("an errrrroooooor");
		}
	}
}

import java.util.ArrayList;
import java.util.Vector;

public class ProductControl {
	public ProductControl() {
	}

	public void addProductToSystem(Product product) {
	}

	public void removeProductFromSystem(Product product) {
	}

	public static void viewProduct(Product product) {
		System.out.println("product name: " + product.getName());
		System.out.println("product price: " + product.getPrice());
		System.out.println("product category: " + product.getCategory().getName());
		System.out.println("product brand: " + product.getBrand().getName());
		product.setNumberOfviews(product.getNumberOfviews() + 1);
	}

	public static ArrayList<String> productInfo(Product product) {
		ArrayList<String> info = new ArrayList<>();
		info.add(product.getName());
		info.add(product.getID());
		info.add(Long.toString(product.getNumberOfviews()));
		return info;
	}

	public static long exploreProductNumOfViews(String id) {
		ArrayList<Product> products = ProductDB.getAllProducts();
		for (int i = 0; i < products.size(); i++) {
			if (products.get(i).getID().equals(id))
				return products.get(i).getNumberOfviews();
		}
		return 0;
	}

	public static Product getMostViewedProduct() {
		ArrayList<Product> products = ProductDB.getAllProducts();
		long mx = 0;
		Product product = new Product();
		for (int i = 0; i < products.size(); i++) {
			long numberOfViewsPfTheCurrentProduct = products.get(i).getNumberOfviews();
			if (numberOfViewsPfTheCurrentProduct > mx) {
				product = products.get(i);
				mx = numberOfViewsPfTheCurrentProduct;
			}
		}
		return product;
	}

	public void removeProductFromCart(Product product) {
	}

	public void searchByProductName(String name) {
	}

	public boolean producrExistInThesystem(Product requiredToAdd) {
		boolean check = false;
		ArrayList<Product> products = ProductDB.getAllProducts();
		for (int i = 0; i < products.size(); i++) {
			if (products.get(i).getName().equals(requiredToAdd.getName()))
				check = true;
		}
		return check;
	}

	public void addProductToStore(Product product) {
		if (producrExistInThesystem(product) == false) {
			ProductDB.addProduct(product);
		}
	}

	public static Product productdExistInThesystem(Product product) {
		String name = product.getName(), ID = product.getID();
		ArrayList<Product> products = ProductDB.getAllProducts();
		for (int i = 0; i < products.size(); i++) {
			if (products.get(i).getStoreOwner().equals(product.getStoreOwner())
					&& products.get(i).getName().equals(name) && products.get(i).getName().equals(ID)) {
				return products.get(i);
			}
		}
		return null;
	}

	public static boolean productExistInTheAdminSystem(String name, String ID) {
		Vector<Product> products = AdminDB.Virtual_DB.getProducts();
		for (int i = 0; i < (int) products.size(); i++) {
			if (products.get(i).getName().equals(name) && products.get(i).getID().equals(ID)) {
				return true;
			}
		}
		return false;
	}

	public void removeProductFromStore(Product product, Store store) {
	}

	public void marketProduct(Product product) {
	}

	public void suggestProduct(Product product) {
		RequestsPage RP = new RequestsPage();
		RP.addProduct(product);
	}

	public static void addToCart(Product product, Cart cart) {
		CartDB.addProduct(product, cart);
	}
}
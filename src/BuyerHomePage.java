import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BuyerHomePage implements HomePage {

	private static Buyer buyer;
	private static List<Advertisment> advertisments = new ArrayList<Advertisment>();
	private List<Store> stores = new ArrayList<Store>();
	private StoreControl SC;
	private ProductControl PC;
	private CartControl CC;

	public BuyerHomePage() {
		StoreDB DB1 = new StoreDB();
		stores = DB1.getAllStores();
	}

	public void displayPage() {

		while (true) {
			System.out.println(buyer.getFirstName() + "'s Home Page");
			System.out.println("..........................");
			System.out.println("stores:");
			for (int i = 0; i < stores.size(); i++) {
				System.out.println("- " + stores.get(i).getName());
			}
			System.out.println("..........................");

			System.out.println("1. Suggest product");
			System.out.println("2. Explore products in store");
			System.out.println("3. view cart");
			System.out.println("4. Exit System");

			switch (Input.takeIntInput()) {
			case 1:
				suggestProduct();
				break;
			case 2:
				viewStore();
				break;
			// case 3:
			// viewCart();
			// break;
			case 4:
				System.exit(0);
				break;

			default:
				System.out.println("invalid input!");
				break;
			}
		}
	}

	public void suggestProduct() {
		CategoryDB DB1 = new CategoryDB();
		BrandDB DB2 = new BrandDB();

		Product suggestedProduct = new Product();

		System.out.print("product name: ");
		suggestedProduct.setName(Input.takeStrInput());

		// Determine suggested product's category

		System.out.println("choose category: ");
		for (int i = 0; i < DB1.getAllCategories().size(); i++) {
			System.out.println((i + 1) + "- " + DB1.getAllCategories().get(i).getName());
		}
		System.out.println((DB1.getAllCategories().size() + 1) + "- Other");
		System.out.print("category number: ");
		int input = Input.takeIntInput();

		if (input == (DB1.getAllCategories().size() + 1)) {
			Category suggestedCategory = new Category();

			System.out.print("new category's name: ");
			suggestedCategory.setName(Input.takeStrInput());
			suggestedProduct.setCategory(suggestedCategory);
		} else if (input > 0 && input <= DB1.getAllCategories().size()) {
			suggestedProduct.setCategory(DB1.getAllCategories().get(input));
		} else {
			System.out.println("invalid input!");
		}

		// Determine suggested product's Brand

		System.out.println("choose brand: ");
		for (int i = 0; i < DB2.getAllBrands().size(); i++) {
			System.out.println((i + 1) + "- " + DB2.getAllBrands().get(i).getName());
		}
		System.out.println((DB2.getAllBrands().size() + 1) + "- Other");
		System.out.print("Brand number: ");
		input = Input.takeIntInput();

		if (input == (DB2.getAllBrands().size() + 1)) {
			Brand suggestedBrand = new Brand();

			System.out.print("new Brand's name: ");
			suggestedBrand.setName(Input.takeStrInput());
			suggestedProduct.setBrand(suggestedBrand);
		} else if (input > 0 && input <= DB2.getAllBrands().size()) {
			suggestedProduct.setBrand(DB2.getAllBrands().get(input));
		} else {
			System.out.println("invalid input!");
		}

		PC.suggestProduct(suggestedProduct);
	}

	public void viewStore() {
		List<Product> storeProducts = new ArrayList<Product>();

		while (true) {
			for (int i = 0; i < stores.size(); i++) {
				System.out.println((i + 1) + "- " + stores.get(i).getName());
			}
			System.out.print("select a store: ");

			storeProducts = SC.viewStore(stores.get(Input.takeIntInput() - 1)); // all products in store are printed

			int input = Input.takeIntInput();
			if (input > storeProducts.size() + 1 || input < 0) {
				System.out.println("invalid input");
			} else if (input == storeProducts.size() + 1) {
				break;
			} else {
				viewProduct(storeProducts.get(input - 1));
			}
		}
	}

	public void viewProduct(Product product) {
		PC.viewProduct(product); // product details printed

		System.out.println("1- add product to cart");
		System.out.println("2- go back to store");

		switch (Input.takeIntInput()) {
		case 1:
			addToCart(product);
			break;
		case 2:
			break;
		default:
			System.out.println("invalid input!");
			break;
		}
	}

	public void addToCart(Product product) {
		PC.addProductToCart(product);
	}

	public void setBuyer(Buyer buyer) {// use it when the user log in as a buyer, to send the buyer to the buyer home
										// page.
		this.buyer = buyer;
	}

	// public void viewCart() {
	// CC.viewCart(buyer.getCart());
	// System.out.println("..........................");
	//
	// System.out.println("1. Buy products");
	// System.out.println("2. Return to home page");
	//
	// switch (Input.takeIntInput()) {
	// case 1:
	// buyProducts();
	// break;
	// case 2:
	// break;
	// default:
	// System.out.println("Invalid input!");
	// break;
	// }
	// }

	public void buyProducts() {
		CC.buyProducts(buyer.getCart());
	}

	public Buyer getBuyer() {
		return buyer;
	}

	public void removeFromCart() {
		// TODO implement here
	}

	public void searchByCategory() {
		// TODO implement here
	}

	public void searchByBrand() {
		// TODO implement here
	}

	public void searchByName() {
		// TODO implement here
	}
}
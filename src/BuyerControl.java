
public class BuyerControl {
	public BuyerControl() {
	}

	public void register(Buyer buyer) {
		// TODO implement here
	}

	public void payOnDelivery(String address) {
		// TODO implement here
	}

	public static void addToCart(Product product) {
		ProductControl.addToCart(product);
	}

	BuyerControl viewCart(Buyer buyer) {
		CartControl.viewCart(buyer);
	}

}
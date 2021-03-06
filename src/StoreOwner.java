import java.util.ArrayList;
import java.util.List;

public class StoreOwner extends User {

	public StoreOwner(String userName, String firstName, String lastName, String email, String password,
			String phoneNum) {
		super(userName, firstName, lastName, email, password, phoneNum);
	}

	public StoreOwner() {
		super();
	}

	public StoreOwner(User user) {
		super(user);
	}

	protected String commercialEmail;
	protected List<Store> stores = new ArrayList<Store>();

	public void setCommercialEmail(String email) {
		this.commercialEmail = email;
	}

	public String getCommercialEmail() {
		return commercialEmail;
	}

	public List<Store> getStores() {
		return stores;
	}

	@Override
	public boolean equals(Object obj) {
		return userName == ((StoreOwner) obj).userName;
	}

}